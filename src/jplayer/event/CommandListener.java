package jplayer.event;

import jplayer.player.*;
import jplayer.ui.*;
import jplayer.ui.components.*;

public abstract class CommandListener implements ButtonListener
{
	private JPlayer       player        = null;
	private PlayerScreen  player_screen = null;
	private Display       display       = null;

	public CommandListener() {}

	protected void init(JPlayer player, PlayerScreen player_screen, Display display)
	{
		this.player         = player;
		this.player_screen  = player_screen;
		this.display        = display;
	}

	protected JPlayer getPlayer()
	{
		return player;
	}

	protected PlayerScreen getPlayerScreen()
	{
		return player_screen;
	}

	protected Display getDisplay()
	{
		return display;
	}

	public abstract void upButtonPressed();
	public abstract void downButtonPressed();
	public abstract void nextButtonPressed();
	public abstract void lastButtonPressed();
	public abstract void playButtonPressed();
	public abstract void muteButtonPressed();
	public abstract void selectButtonPressed();
	public abstract void menuButtonPressed();
}