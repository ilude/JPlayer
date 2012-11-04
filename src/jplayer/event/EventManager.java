package jplayer.event;

import bsh.*;
import jplayer.ui.*;
import jplayer.player.*;

public class EventManager implements ButtonListener, JPlayerListener
{
	private Interpreter               i  = new Interpreter();
	private JPlayer              player  = null;
	private PlayerScreen  player_screen  = null;
	private Display             display  = null;
	private CommandListener     command  = null;

	public EventManager(Display display)
	{
		this.display = display;
		this.display.addButtonListener(this);

		this.addContext("display", display);
	}

	public void addContext(String name, Object obj)
	{
		try
		{
			i.set(name, obj);
		}
		catch (EvalError ex)
		{
			throw new RuntimeException(ex);
		}
	}

	public void setPlayer(JPlayer player, PlayerScreen player_screen)
	{
		this.player         = player;
		this.player_screen  = player_screen;

		this.player.addJPlayerListener(this);
		this.display.setScreenActive(player_screen);

		this.addContext("player", player);
		this.addContext("player_screen", player_screen);

		command = new JPlayerHandler();
		command.init(player, player_screen, display);
	}

	public void upButtonPressed()
	{
		command.upButtonPressed();
	}
	public void downButtonPressed()
	{
		command.downButtonPressed();
	}
	public void nextButtonPressed()
	{
		command.nextButtonPressed();
	}
	public void lastButtonPressed()
	{
		command.lastButtonPressed();
	}
	public void playButtonPressed()
	{
		command.playButtonPressed();
	}
	public void muteButtonPressed()
	{
		command.muteButtonPressed();
	}
	public void menuButtonPressed()
	{
		command.menuButtonPressed();
	}
	public void selectButtonPressed()
	{
		command.selectButtonPressed();
	}

	public void bufferingFile()
	{
		player_screen.title.setValue("Prebuffering Data...");
		if(player.getPlayList() != null)
		{
			PlayList playlist = player.getPlayList();
			player_screen.repeat.display(  playlist.isRepeating() );
			player_screen.shuffle.display( playlist.isShuffled() );
		}
	}

	public void startedPlayback(String title, int playing_time)
	{
		player_screen.setNewSong(title, playing_time, player.getGain());
	}
}