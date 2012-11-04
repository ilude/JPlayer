package jplayer.ui.components;

public class CounterLabel extends TimeLabel
{
	private CounterLabelTask  task          = null;
	private     HorizonalBar  h_bar         = null;
	private              int  elapsed_time  = 0;
	private              int  total_time    = 0;


	public CounterLabel()
	{
		super();
	}

	public void linkHorizonalBar(HorizonalBar h_bar)
	{
		this.h_bar = h_bar;
	}

	public void start()
	{
		task = new CounterLabelTask(this, elapsed_time, total_time);

		if(h_bar != null)
			task.linkHorizonalBar(h_bar);

		task.startCounter();
	}

	public void pause()
	{
		task.cancel();
		elapsed_time = task.getElapsedTime();
	}

	public void reset()
	{
		if(task != null) task.cancel();

		task          = null;
		total_time    = 0;
		elapsed_time  = 0;
	}

	public void reset(int total_time)
	{
		reset();
		this.total_time = total_time;
		this.h_bar.setValue(0);
	}
}