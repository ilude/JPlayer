package jplayer.ui;

import java.util.*;
import jplayer.ui.components.*;

public class Screen extends Thread
{
	private boolean visible = false;
	private boolean invalid = true;

	private List  component_list = new ArrayList();
	private Display display;

	public Screen(String screen_name)
	{
		super.setName(screen_name);
	}

	public void addComponent(Component component)
	{
		component_list.add(component);

		if(display != null)
			component.setDisplay(display);
	}

	public void setVisible(boolean visible)
	{
		if(visible && !this.visible && display != null)
		{
			this.visible = visible;
			if(!this.isAlive())
				this.start();
			else
				this.notify();
		}
	}

	public boolean isVisible()
	{
		return visible;
	}

	public synchronized boolean isInvalid()
	{
		return invalid;
	}

	public void setDisplay(Display display)
	{
		this.display = display;
		for(Iterator itr = component_list.iterator(); itr.hasNext();)
		{
			Component component = (Component)itr.next();
			component.setDisplay(display);
		}
	}

	public void run()
	{
		while(true)
		{
			if(this.isVisible())
			{
				long wait_time = System.currentTimeMillis();

				for(Iterator itr = component_list.iterator(); itr.hasNext();)
				{
					Component component = (Component)itr.next();
					synchronized(component)
					{
						if(component.isInvalid())
							component.validate();
					} // end synchronized
				} // end for

				try
				{
					// slow down and only update the display every second
					long time_taken = System.currentTimeMillis() - wait_time;
					sleep(500 - time_taken);
				}
				catch(InterruptedException ex)
				{
					System.out.println(this.getName() + " Woke Up Early!");
					System.out.println(ex);
				}
			}
			else
			{
				try
				{
					this.wait();
				}
				catch (InterruptedException ex)
				{
					System.out.println(this.getName() + " Woke Up Early!");
					System.out.println(ex);
				}
			}
		}
	}
}