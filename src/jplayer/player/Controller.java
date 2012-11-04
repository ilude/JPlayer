package jplayer.player;


import jplayer.ui.*;

import jplayer.screens.*;
import jplayer.displays.*;
import jplayer.event.*;

public class Controller
{
  private static final String[] paths = {"C:/Documents and Settings/MGLENN/My Documents/Desktop Folders/Music"};

  public static void main(String[] args)
  {
    try
    {
      Thread current_thread = Thread.currentThread();
      current_thread.setName("Main Thread");

      Display            display = new EmulatorDisplay();

      JPlayer             player = new JPlayer();
      PlayerScreen player_screen = new PlayerScreen();

      EventManager event_manager = new EventManager(display);
      event_manager.setPlayer(player, player_screen);

      try
      {
        Thread.sleep(1000);
      }
      catch(InterruptedException e)
      {
        System.out.println("Main Thread woke up early");
      }

      PlayList        playlist      = Controller.getPlayList();
      if(playlist == null)
      {
        System.out.println("Playlist is null!");
        System.exit(-1);
      }

      player.setPlayList(playlist);
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }

  private static PlayList getPlayList()
  {
    PlayList playlist = new PlayList();
    for(int i=0; i<paths.length; i++)
    {
      try
      {
        playlist.loadDirectory(paths[i]);
        if(playlist.totalTracks() > 0)
        break;
      }
      catch(Exception e)
      {
        e.printStackTrace();
        if( i == paths.length - 1)
        {
          e.printStackTrace();
          System.exit(-1);
        }
        else
        {
          continue;
        }
      }
    }

    return playlist;
  }
}