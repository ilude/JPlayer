package jplayer.ui;

import java.io.*;
import java.util.*;

import jplayer.protocol.*;
import jplayer.ui.lcd.Char;
import jplayer.ui.components.*;
import jplayer.event.ButtonListener;

public abstract class Display extends Thread
{
	public static final int UP_COMMAND    = 8;
	public static final int DW_COMMAND    = 9;
	public static final int A1_COMMAND    = 10;
	public static final int A2_COMMAND    = 11;
	public static final int A3_COMMAND    = 12;
	public static final int A4_COMMAND    = 13;
	public static final int LAST_COMMAND  = 14;
	public static final int NEXT_COMMAND  = 15;

	private byte[] move_command = new byte[4];
	private byte[] command      = new byte[2];

	private OutputStream out    = null;
	private InputStream  input  = null;
	private Screen       active_screen;
	private List         button_listeners;


	public Display()
	{
		super.setName("Input Thread");
		move_command[0] = Char.COMMAND;
		move_command[1] = Char.CURSOR_MOVE;

		command[0] = Char.COMMAND;
	}

	public void addButtonListener(ButtonListener listener)
	{
		if(button_listeners == null)
			button_listeners = new ArrayList(3);

		button_listeners.add(listener);
		this.start();
	}

	public void setScreenActive(Screen screen)
	{
		active_screen = screen;
		active_screen.setDisplay(this);
		active_screen.setVisible(true);
	}

	public void setCursor(int x, int y)
	{
		if((x < 41 && y < 5) && (x > -1 && y > -1))
		{
			move_command[2] = (byte)y;
			move_command[3] = (byte)x;

			write(move_command, out);
		}
	}

	public void write(byte[] text)
	{
		write(text, out);
	}

	public void setHome()
	{
		command( Char.CURSOR_HOME );
	}

	public void moveRight()
	{
		command( Char.CURSOR_RIGHT );
	}

	public void moveLeft()
	{
		command( Char.CURSOR_LEFT );
	}

	public void clear()
	{

		command( Char.CLEAR_DISPLAY );
	}

	public void run()
	{
		byte[] buf = new byte[2];
		while(true)
		{
			try
			{
				input.read(buf);

				int command = (int) buf[0] + buf[1];

				switch (command) {
					case UP_COMMAND:
						for (Iterator itr = button_listeners.iterator(); itr.hasNext(); )
							( (ButtonListener) itr.next()).upButtonPressed();
						break;
					case DW_COMMAND:
						for (Iterator itr = button_listeners.iterator(); itr.hasNext(); )
							( (ButtonListener) itr.next()).downButtonPressed();
						break;
					case A1_COMMAND:
						for (Iterator itr = button_listeners.iterator(); itr.hasNext(); )
							( (ButtonListener) itr.next()).playButtonPressed();
						break;
					case A2_COMMAND:
						for (Iterator itr = button_listeners.iterator(); itr.hasNext(); )
							( (ButtonListener) itr.next()).muteButtonPressed();
						break;
					case A3_COMMAND:
						for (Iterator itr = button_listeners.iterator(); itr.hasNext(); )
							( (ButtonListener) itr.next()).menuButtonPressed();
						break;
					case A4_COMMAND:
						for (Iterator itr = button_listeners.iterator(); itr.hasNext(); )
							( (ButtonListener) itr.next()).selectButtonPressed();
						break;
					case LAST_COMMAND:
						for (Iterator itr = button_listeners.iterator(); itr.hasNext(); )
							( (ButtonListener) itr.next()).lastButtonPressed();
						break;
					case NEXT_COMMAND:
						for (Iterator itr = button_listeners.iterator(); itr.hasNext(); )
							( (ButtonListener) itr.next()).nextButtonPressed();
						break;
				}
			}
			catch(IOException ex)
			{
				System.out.println("Error reading from display!");
				System.out.println(ex);
			}
		}
	}

	protected void setOutputStream(OutputStream out)
	{
		this.out = out;
	}

	protected void setInputStream(InputStream input)
	{
		this.input = input;
		if(!this.isAlive() && active_screen != null)
		{
			this.start();
		}
	}

	private final void command(byte b)
	{
		command[1] = b;
		write(command, out);
	}

	private final static void write(byte[] command, OutputStream out)
	{
		try
		{
			out.write(command);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}