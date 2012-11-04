package jplayer.event;

import jplayer.player.*;

public class JPlayerHandler extends CommandListener
{
	/**
	 * Alternetly pauses of resumes playback of the player.
	 *
	 */
	public void playButtonPressed()
	{
		JPlayer       player        = this.getPlayer();
		PlayerScreen  player_screen = this.getPlayerScreen();

		if(player.isPaused())
		{
			player.resumePlayback();
			player_screen.unpause(player.getGain());
		}
		else if(player.isPlaying())
		{
			player.pausePlayback();
			player_screen.pause();
		}
	}

	/**
	 * Mutes the player.
	 *
	 */
	public void muteButtonPressed()
	{
		int volume = this.getPlayer().mute();

		if(volume <= 0)
			this.getPlayerScreen().volume.setValue("Mute");
		else
			this.getPlayerScreen().volume.setValue(volume);
	}

	/**
	 * Forces the player to begin playing the previous song in the current
	 * playlist.
	 *
	 */
	public void lastButtonPressed()
	{
		this.getPlayer().back();
	}

	/**
	 * Forces the player to begin playing the next song in the current playlist.
	 *
	 */
	public void nextButtonPressed()
	{
		this.getPlayer().next();
	}

	/**
	 * Increases the gain on the audio line by one percent.
	 *
	 */
	public void upButtonPressed()
	{
		int volume = this.getPlayer().increaseGain();
		this.getPlayerScreen().volume.setValue(volume);
	}

	/**
	 * Decreases the gain on the audio line by one percent.
	 *
	 */
	public void downButtonPressed()
	{
		int volume = this.getPlayer().decreaseGain();
		this.getPlayerScreen().volume.setValue(volume);
	}

	/**
	 * Displays the Main Menu.
	 *
	 */
	public void menuButtonPressed()
	{
		/**@todo diplay main menu*/
	}

	/**
	 * Cycles through the repeat and shuffle options of the playlist.
	 *
	 */
	public void selectButtonPressed()
	{
		PlayList      playlist      = this.getPlayer().getPlayList();
		PlayerScreen  player_screen = this.getPlayerScreen();

		if(!playlist.isShuffled() && !playlist.isRepeating())
		{
			playlist.setRepeat(true);
			player_screen.repeat.display(true);
		}
		else if(!playlist.isShuffled() && playlist.isRepeating())
		{
			playlist.setRepeat(false);
			player_screen.repeat.display(false);

			playlist.setShuffle(true);
			player_screen.shuffle.display(true);
		}
		else if(playlist.isShuffled() && !playlist.isRepeating())
		{
			playlist.setRepeat(true);
			player_screen.repeat.display(true);
		}
		else if(playlist.isShuffled() && playlist.isRepeating())
		{
			playlist.setRepeat(false);
			player_screen.repeat.display(false);

			playlist.setShuffle(false);
			player_screen.shuffle.display(false);
		}
	}
}