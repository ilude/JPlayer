package jplayer.ui.components;

import java.util.*;

import jplayer.ui.lcd.Char;
import jplayer.util.*;
import jplayer.ui.*;
import jplayer.components.*;

public abstract class Component
{
	protected static final int DEFAULT_WIDTH = 40;

	private int     max_length  = DEFAULT_WIDTH;
	private boolean invalid     = false;
	private boolean erase       = false;

	private Position        position  = new Position();
	private Display         display   = null;
	private byte[]          output    = null;
	private VolatileInteger integer   = null;
	private VolatileLong    long_val  = null;
	private Object          lock      = null;

	public Component()
	{
	}

	abstract public void setValue(Object obj);

	public void setValue(int i)
	{
		if(integer == null) integer = new VolatileInteger();

		integer.setInt(i);

		this.setValue(integer);
	}

	public void setValue(long i)
	{
		if(long_val == null) long_val = new VolatileLong();

		long_val.setLong(i);

		this.setValue(long_val);
	}

	protected void setOutput(String text)
	{
		this.setOutput(text.getBytes());
	}

	protected synchronized void setOutput(byte[] b)
	{
		if(b != null && (output == null || !Arrays.equals(output, b)) )
		{
			if(output == null)
			{
				if(b.length > max_length)
				{
					output = new byte[max_length];
				}
				else
				{
					output = new byte[b.length];
				}
				System.arraycopy(b, 0, output, 0, output.length);
			}
			else
			{
				try
				{
					// if new value(b) is greater than max_width, create largest output
					if(b.length > max_length) output = new byte[max_length];

					// if new value(b) is greater than output, create larger output
					else if(b.length > output.length) output = new byte[b.length];

					// if new value(b) is less than output, fill output with spaces
					else if(b.length < output.length) Arrays.fill(output, Char.SPACE);

					System.arraycopy(b, 0, output, 0, (b.length >= output.length) ? output.length : b.length);
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("BoundException: " + b.length + " - " + output.length);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			// invalidate this component so that it updates
			this.setInvalid();
		}
	}

	public final void setLocation(int x, int y)
	{
		if(position.x != x || position.y != y)
		{
			position.x = x;
			position.y = y;

			if(!this.isInvalid()) this.setInvalid();
		}
	}

	public int getWidth()
	{
		return max_length;
	}

	public void setWidth(int max_length)
	{
		this.max_length = max_length;
	}

	public void reset()
	{
		if(output != null)
		{
			erase = true;
			this.setInvalid();
		}
	}

	public void setInvalid()
	{
		invalid = true;
	}

	public boolean isInvalid()
	{
		return invalid;
	}

	public void setDisplay(Display display)
	{
		this.display = display;
	}

	protected void setValid()
	{
		invalid = false;
	}

	public final void validate()
	{
		if(invalid && output != null)
		{
			if(erase)
			{
	Arrays.fill(output, Char.SPACE);
	display.setCursor(position.x, position.y);
	display.write(output);
	erase = false;
			}
			display.setCursor(position.x, position.y);
			display.write(output);
			this.setValid();
		}
	}
}