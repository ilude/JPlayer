package jplayer.ui.components;

import java.util.*;

import jplayer.ui.lcd.Char;

import jplayer.ui.*;

public class HorizonalBar extends Component
{
  private byte[]  bar     = null;
  private int     cursor  = 0;
  private float   percent_threshold = 0;

  public HorizonalBar()
  {
    this.setWidth(DEFAULT_WIDTH);
  }

  public void setWidth(int width)
  {
    bar = new byte[width];
    percent_threshold = (float)width / 100;

    super.setWidth(width);
  }

  public void setValue(Object obj)
  {
    try
    {
      int val = ((Number)obj).intValue();
      if( val > 100 ) return;
      if( val == 0 )  cursor = 0;

      int new_cursor = Math.round(val * percent_threshold);
      if(new_cursor > cursor || cursor == 0)
      {
        cursor = new_cursor;
        Arrays.fill(bar, 0, cursor, Char.BLOCK);
        Arrays.fill(bar, cursor, bar.length, Char.SPACE);

        super.setOutput(bar);
      }
    }
    catch(ClassCastException e)
    {
      //ignore it
    }
  }
}
