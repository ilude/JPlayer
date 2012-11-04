package jplayer.ui.lcd.io;


import jplayer.ui.lcd.LCDPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;

public class InputHandler extends InputStream implements MouseListener
{
	private ByteQueue byte_queue = new ByteQueue();

	public InputHandler()
	{
	}

	public int read(byte[] buf) throws java.io.IOException
	{
		buf[0] = byte_queue.remove();
		buf[1] = byte_queue.remove();

		return 2;
	}

	public void mouseReleased(MouseEvent e)
	{
		int command = e.getComponent().hashCode();
		switch(command)
		{
			case LCDPanel.UP_COMMAND:
				byte_queue.add(new byte[] {0, 8});
				break;
			case LCDPanel.DW_COMMAND:
				byte_queue.add(new byte[] {0, 9});
				break;
			case LCDPanel.PLAY_COMMAND:
				byte_queue.add(new byte[] {0, 10});
				break;
			case LCDPanel.MUTE_COMMAND:
				byte_queue.add(new byte[] {0, 11});
				break;
			case LCDPanel.MENU_COMMAND:
				byte_queue.add(new byte[] {0, 12});
				break;
			case LCDPanel.SELECT_COMMAND:
				byte_queue.add(new byte[] {0, 13});
				break;
			case LCDPanel.LAST_COMMAND:
				byte_queue.add(new byte[] {0, 14});
				break;
			case LCDPanel.NEXT_COMMAND:
				byte_queue.add(new byte[] {0, 15});
				break;
		}
	}

	public void mousePressed(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

	public int read() throws java.io.IOException
	{
		return -1;
	}
}