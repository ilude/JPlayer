package jplayer.player;

import jplayer.ui.*;

import jplayer.ui.components.*;

public class PlayerScreen extends Screen
{
	// screen objects
	public OnOffLabel    repeat     = new OnOffLabel("R", null);
	public OnOffLabel    shuffle    = new OnOffLabel("S", null);
	public Label         volume     = new Label();
	public Label         title      = new Label();

	private TimeLabel    time       = new TimeLabel();
	private CounterLabel elapsed    = new CounterLabel();

	public PlayerScreen() throws Exception
	{
		super("PlayerScreen");

		HorizonalBar progress = new HorizonalBar();
		progress.setLocation(5, 1);
		progress.setWidth(30);

		this.elapsed.setLocation(0, 1);
		this.elapsed.linkHorizonalBar( progress );

		this.title.setLocation(0, 0);
		this.shuffle.setLocation(38, 3);
		this.repeat.setLocation(39, 3);
		this.time.setLocation(35, 1);
		this.volume.setLocation(2, 3);

		super.addComponent(title);
		super.addComponent(time);
		super.addComponent(elapsed);
		super.addComponent(progress);
		super.addComponent(repeat);
		super.addComponent(shuffle);
		super.addComponent(volume);
		super.addComponent( new Label("V:", 0, 3) );
	}

	public void setNewSong(String title, int total_time, int gain)
	{
		this.title.setValue(title);

		time.setValue(total_time);
		volume.setValue(gain);
		elapsed.reset(total_time);
		elapsed.start();
	}

	public void pause()
	{
		volume.setValue("Pause");
		elapsed.pause();
	}

	public void unpause(int volume_value)
	{
		volume.setValue(volume_value);
		elapsed.start();
	}
}