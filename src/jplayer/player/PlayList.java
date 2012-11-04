package jplayer.player;

import java.io.*;
import java.util.*;
import javax.sound.sampled.*;

public class PlayList
{
	private Object      current_song  = null;
	private LinkedList  working_list  = null;
	private LinkedList  song_list     = new LinkedList();
	private LinkedList  played_list   = new LinkedList();

	private boolean     repeat        = false;
	private boolean     shuffle       = false;

	public PlayList()
	{
		working_list = cloneSongList();
	}

	public void loadDirectory(Object obj)
	{
		File dir = null;
		if(obj instanceof String)
			dir = new File((String)obj);
		else if( obj instanceof File)
			dir = (File)obj;

		File[] mp3_files = dir.listFiles(new FileFilter() {
			public boolean accept(File file)
			{
				boolean accept = false;
				if(file.isFile())
				{
					try
					{
						AudioSystem.getAudioFileFormat(file);
						accept = true;
					}
					catch(Exception ex)
					{
						System.out.println("Playlist.loadDirectory() " + ex);
					} // return false
				}

				return accept;
			}
		});
		song_list.addAll( Arrays.asList(mp3_files) );
		working_list = cloneSongList();

		if(shuffle) Collections.shuffle(working_list);
	}

	public int totalTracks()
	{
		return song_list.size();
	}

	public final int remainingTracks()
	{
		return working_list.size();
	}

	public final boolean isRepeating()
	{
		return repeat;
	}

	public final boolean isShuffled()
	{
		return shuffle;
	}

	public final void reset()
	{
		working_list = cloneSongList();

		if(shuffle) Collections.shuffle(working_list);
	}

	public final void setRepeat(boolean repeat)
	{
		this.repeat = repeat;
	}

	public final void setShuffle(boolean shuffle)
	{
		this.shuffle = shuffle;
		if(shuffle)
		{
			Collections.shuffle(working_list);
		}
		else
		{
			working_list = cloneSongList();
			working_list.removeAll(played_list);
		}
	}

	public boolean isEmpty()
	{
		return song_list.isEmpty();
	}

	public void clear()
	{
		song_list.clear();
		working_list.clear();
		played_list.clear();
	}

	public boolean hasNext()
	{
		boolean has_next = true;
		if(repeat)
		{
			if(working_list.isEmpty() && shuffle)
			{
				working_list = cloneSongList();
				Collections.shuffle(working_list);
			}
			else if(working_list.isEmpty())
			{
				working_list = cloneSongList();
			}
		}
		else
		{
			has_next = !working_list.isEmpty();
		}

		return has_next;
	}

	public boolean next()
	{
		if(this.hasNext())
		{
			played_list.addLast( current_song );
			current_song = working_list.removeFirst();
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean back()
	{
		if(!played_list.isEmpty())
		{
			working_list.addFirst( current_song );
			current_song = played_list.removeLast();
			return true;
		}
		else
		{
			return false;
		}
	}

	public File getSong()
	{
		if(current_song == null && !working_list.isEmpty())
		{
			current_song = working_list.removeFirst();
		}
		else if(current_song == null && !played_list.isEmpty())
		{
			current_song = played_list.getLast();
		}

		return (File)current_song;
	}

	/**
	 *  Private utility methods
	 */

	private final LinkedList cloneSongList()
	{
		return (LinkedList)song_list.clone();
	}
}