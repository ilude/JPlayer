package jplayer.ui.lcd;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;


public class PushButton extends JComponent
{
  private static final int  HEIGHT        = 12;
  private static final int  WIDTH         = 12;
  private static Color      COLOR         = Color.RED;
  private static Color      COLOR_PRESSED = Color.MAGENTA;
  private static Dimension  size          = new Dimension(HEIGHT, WIDTH);

  private boolean pressed   = false;
  private int     x_center  = WIDTH / 2;
  private int     y_center  = HEIGHT / 2;
  private int     command   = 0;

  public PushButton(int command)
  {
    this.command = command;
    this.setSize(size);
    this.enableEvents(AWTEvent.MOUSE_EVENT_MASK);
  }

  public Dimension getMinimumSize()
  {
    return size;
  }

  public Dimension getPreferredSize()
  {
    return size;
  }

  public Dimension getMaximumSize()
  {
    return size;
  }

  public Dimension getSize()
  {
    return size;
  }

  public void paint(Graphics g)
  {
    g.setColor(COLOR);
    g.fillOval(0, 0, 10, 10);

    if(pressed)
    {
      g.setColor(COLOR.WHITE.darker().darker());
      g.drawArc(0, 0, 10, 10, 40, 180 );
      g.setColor(COLOR.WHITE.darker());
      g.drawArc(0, 0, 10, 10, 220, 180 );
    }
    else
    {
      g.setColor(COLOR.WHITE.darker());
      g.drawArc(0, 0, 10, 10, 40, 180 );
      g.setColor(COLOR.WHITE.darker().darker());
      g.drawArc(0, 0, 10, 10, 220, 180 );
    }
  }

  protected void processMouseEvent(MouseEvent e)
  {
    switch(e.getID())
    {
      case MouseEvent.MOUSE_PRESSED:
	if(!pressed)
	{
	  this.pressed = true;
	  this.repaint();
	}
	break;
      case MouseEvent.MOUSE_RELEASED:
	if(pressed)
	{
	  this.pressed = false;
	  this.repaint();
	}
	break;

      case MouseEvent.MOUSE_EXITED:
	if(pressed)
	{
	  this.pressed = false;
	  this.repaint();
	}
	break;
    }

    super.processMouseEvent(e);
  }

  public int hashCode()
  {
    return command;
  }
}