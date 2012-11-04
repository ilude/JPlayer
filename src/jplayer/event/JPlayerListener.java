package jplayer.event;

public interface JPlayerListener
{
	public void bufferingFile();
	public void startedPlayback( String title, int playing_time);
}