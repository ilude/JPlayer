package jplayer.player;

import java.io.*;
import java.util.*;
import javax.sound.sampled.*;

import jplayer.audio.*;
import helliker.id3.*;
import java.net.URL;
import jplayer.event.*;

public class JPlayer extends Thread
{
  //private static final AudioFormat TARGET_FORMAT  = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);
  //private static final int         BytesPerSec    = (int)(TARGET_FORMAT.getFrameSize() * TARGET_FORMAT.getFrameRate());
  private static final int BUFFER         = 4608;

  // Player States
  private static final int STOPPED        = 0;
  private static final int PLAYING        = 1;
  private static final int PAUSED         = 2;
  private static final int FILE_COMPLETE  = 3;
  private static final int NEXT           = 4;
  private static final int BACK           = 5;

  private JPlayerListener   listener      = null;
  private List              listeners     = null;
  private AudioLine         line          = null;
  private AudioInputStream  audio_stream  = null;
  private PlayList          playlist      = null;
  private Thread            thread        = null;

  private int               STATE         = STOPPED;
  private byte[]	          data          = new byte[BUFFER];

  public JPlayer() {}

  public void addJPlayerListener(JPlayerListener listener)
  {
    if(listeners == null)
      listeners = new ArrayList(3);

    listeners.add(listener);
  }

  public void setPlayList(PlayList playlist)
  {
    this.playlist = playlist;
    this.startPlayback();
  }

  public PlayList getPlayList()
  {
    return this.playlist;
  }

  public void startPlayback()
  {
    if(thread == null || !thread.isAlive())
    {
      STATE = PLAYING;

      thread = new Thread(this);
      thread.setName("Player");
      thread.start();
      while(!thread.isAlive())
      {
  try
  {
    Thread.sleep(1000);
  }
  catch (InterruptedException ex) {
  }
      }
    }
  }

  public void stopPlayback()
  {
    if(STATE == PLAYING)
    {
      STATE = STOPPED;
    }
    else if(STATE == PAUSED)
    {
      synchronized(thread)
      {
  STATE = STOPPED;
  thread.notify();
      }
    }
  }

  public void pausePlayback()
  {
    if(STATE == PLAYING)
      STATE = PAUSED;
  }

  public void resumePlayback()
  {
    if(STATE == PAUSED)
    {
      synchronized(thread)
      {
  STATE = PLAYING;
  thread.notify();
      }
    }
  }

  public void next()
  {
    STATE = NEXT;
  }

  public void back()
  {
    STATE = BACK;
  }

  public int mute()
  {
    if(STATE == PLAYING)
    {
      return line.mute();
    }
    return 0;
  }

  public int getGain()
  {
    if(line == null)
      return 80;
    else
      return line.gainPrecentage();
  }

  public int increaseGain()
  {
    return line.increaseGain();
  }

  public int decreaseGain()
  {
    return line.decreaseGain();
  }

  public boolean isPlaying()
  {
    return (STATE == PLAYING);
  }

  public boolean isPaused()
  {
    return (STATE == PAUSED);
  }

  public void run()
  {
    this.setPriority(Thread.MAX_PRIORITY);
    try
    {
      while (STATE != STOPPED)
      {
  switch(STATE)
  {
    case PLAYING:
      process_play();
      break;
    case PAUSED:
      process_pause();
      break;
    case FILE_COMPLETE:
      process_complete();
      break;
    case NEXT:
      process_next();
      break;
    case BACK:
      process_back();
      break;
  } // end switch
      } // end while
    }
    catch(IOException e)
    {
      e.printStackTrace();
    }
    catch(InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  /*************************************************************
   *
   * Player State Methods
   *
   *************************************************************/

  private final void process_play() throws IOException
  {
    if(audio_stream == null)
    {
      this.setAudioStream();
    }

    int bytes_read = audio_stream.read(data, 0, data.length);
    if(bytes_read >= 0)
    {
      line.write(data, 0, bytes_read);
    }
    else
    {
      STATE = FILE_COMPLETE;
    }
  }

  private final void process_pause() throws InterruptedException
  {
    synchronized(thread)
    {
      line.stop();
      thread.wait();
      line.start();
    }
  }

  private final void process_complete()
  {
    line.drain();
    this.clearStream();

    if(playlist.next())
    {
      STATE = PLAYING;
    }
    else
    {
      STATE = STOPPED;
    }
  }

  private final void process_next()
  {
    if(playlist.next())
    {
      this.clearStream();
      this.setAudioStream();
    }

    // to get here state = NEXT;
    STATE = PLAYING;
  }

  private final void process_back()
  {
    if(playlist.back())
    {
      this.clearStream();
      this.setAudioStream();
    }

    // to get here state = BACK;
    STATE = PLAYING;
  }

  private final void clearStream()
  {
    line.flush();

    this.audio_stream = null;
    this.line = null;
  }

  private final void setAudioStream()
  {
    while(audio_stream == null)
    {
      File  file     = playlist.getSong();
      data           = new byte[BUFFER];
      int playing_time   = 0;

      try
      {
        AudioFormat target_format = null;
        AudioFormat source_format = null;
        AudioInputStream   stream = null;

        // notify listeners that data is being prebuffered
        if(listeners != null)
          for(Iterator itr = listeners.iterator(); itr.hasNext();)
            ((JPlayerListener)itr.next()).bufferingFile();

        if(file.getName().endsWith(".m3u"))
        {
          BufferedReader in = new BufferedReader(new FileReader(file));
          String str_url = in.readLine();

          stream = AudioSystem.getAudioInputStream(new URL(str_url));
        }
        else if(file.getName().endsWith(".wav"))
        {
          playing_time = this.getTime(file);
          stream = AudioSystem.getAudioInputStream(file);
        }
        else
        {
          playing_time = this.getTime(file);

          // Open the file and read it into the buffer, close and null the file reader
          FileInputStream  in = new FileInputStream(file);
          byte[]  file_buffer = new byte[ (int)file.length() ];
          in.read(file_buffer); in.close(); in = null;

          stream = AudioSystem.getAudioInputStream( new ByteArrayInputStream(file_buffer) );
        }

        source_format = stream.getFormat();
        AudioFormat[] audioformats = AudioSystem.getTargetFormats(AudioFormat.Encoding.PCM_SIGNED, source_format);

        if(audioformats.length > 0)
          target_format = audioformats[0];
        else
          throw new Exception("No supported format!");

        line = new AudioLine(target_format);
        audio_stream = AudioSystem.getAudioInputStream(target_format, stream);

        // notify listener of the loaded file
        if(listeners != null)
        {
          String title = this.getTitle(file);
          for(Iterator itr = listeners.iterator(); itr.hasNext();)
                 ((JPlayerListener)itr.next()).startedPlayback(title, playing_time);
        }

      }
      catch(EOFException e)
      {
        e.printStackTrace();
      }
      catch(NullPointerException e)
      {
        e.printStackTrace();
      }
      catch(Exception e)
      {
        System.out.println("Player Exception: " + e);
        System.out.println("       while attempting to read " + file);
        if(playlist.next())
          continue;
        else
          break;
      }
    }
  }

  private static final int getTime(File file) throws UnsupportedAudioFileException, IOException
  {
    int time = 0;
    try
    {
      MP3File mp3_file = new MP3File(file);
      time = (int)mp3_file.getPlayingTime();
    }
    catch(Exception e)
    {
      AudioFileFormat audio_file    = AudioSystem.getAudioFileFormat(file);
      AudioFormat     audio_format  = audio_file.getFormat();

      time = Math.round(audio_file.getFrameLength() / audio_format.getFrameRate());
    }
    return time;
  }

  private static final String getTitle(File file)
  {
    String title = "";
    try
    {
      MP3File mp3_file = new MP3File(file);

      if(mp3_file.getArtist().length() < 1 || mp3_file.getTitle().length() < 1)
      {
        String[] info = file.getName().split("-");
        info[0] = info[0].trim();
        info[1] = info[1].substring(0, info[1].lastIndexOf(".")).trim();

        mp3_file.setArtist(info[0]);
        mp3_file.setTitle(info[1]);

        title = info[0] + " - " + info[1];
      }
      else
      {
        title = mp3_file.getArtist() + " - " + mp3_file.getTitle();
      }
    }
    catch(Exception e)
    {
      String[] info = file.getName().split("-");
      if(info.length >= 2)
      {
        info[1] = info[1].substring(0, info[1].lastIndexOf("."));
        title = info[0].trim() + " - " + info[1].trim();
      }
      else if( file.getName().matches("[a-zA-Z].+") )
      {
        title = file.getName().substring(0, file.getName().lastIndexOf("."));
        title = (title.length() > 35) ? title.substring(0, 35) : title;
      }
    }

    return title;
  }
}