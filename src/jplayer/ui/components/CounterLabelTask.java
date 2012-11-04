package jplayer.ui.components;

import java.util.*;

public class CounterLabelTask extends TimerTask
{
	private static Timer timer = null;

	private CounterLabel counter_label = null;
	private          int elapsed_time  = 0;

	private HorizonalBar h_bar         = null;
	private          int total_time    = 0;

	protected CounterLabelTask(CounterLabel counter_label, int elapsed_time, int total_time)
	{
		this.counter_label = counter_label;
		this.elapsed_time  = elapsed_time;
		this.total_time    = total_time;
	}

	protected void linkHorizonalBar(HorizonalBar h_bar)
	{
		this.h_bar  = h_bar;
	}

	protected int getElapsedTime()
	{
		return elapsed_time;
	}

	protected void startCounter()
	{
		this.getTimer().scheduleAtFixedRate(this, 0, 1000);
	}

	public void run()
	{
		if(total_time > 10)
		{
			elapsed_time++;
			counter_label.setValue(elapsed_time);

			if(h_bar != null)
			{
				h_bar.setValue( Math.round( (float)elapsed_time/total_time * 100 ) );
			}
		}
	}

	private static final Timer getTimer()
	{
		if(timer == null) timer = new Timer(true);
		return timer;
	}
}