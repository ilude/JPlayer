package jplayer.ui.lcd;

import jplayer.ui.lcd.*;

public class DisplayCursor
{
  private int x = 0;
  private int y = 0;

  protected DisplayCursor() {}

  protected int getX()
  {
    return x;
  }

  protected int getY()
  {
    return y;
  }

  protected void setLocation(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  protected void increment()
  {
    if(++y == LCDPanel.COLUMNS && x < LCDPanel.ROWS - 1)
    {
      x++;
      y = 0;
    }
    else if( y == LCDPanel.COLUMNS)
    {
      y = 0;
      x = 0;
    }
  }

  protected void decrement()
  {
    if(--y < 0 && x > 0)
    {
      x--;
      y = LCDPanel.COLUMNS - 1;
    }
    else if( x < 0 )
    {
      x = 0;
      y = 0;
    }
  }
}