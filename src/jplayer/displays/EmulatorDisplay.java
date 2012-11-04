package jplayer.displays;

import javax.swing.JFrame;



import jplayer.ui.lcd.*;
import jplayer.ui.*;
import jplayer.ui.components.*;

public class EmulatorDisplay extends Display
{
  private Screen screen;

  public EmulatorDisplay()
  {
    super();

    JFrame frame = new JFrame("LCDPanel");
    frame.setLocation(50, 50);
    LCDPanel lcd = new LCDPanel();

    frame.getContentPane().add(lcd);
    frame.setResizable(false);
    frame.pack();
    frame.setVisible(true);

    super.setOutputStream( lcd.getOutputStream() );
    super.setInputStream(  lcd.getInputStream() );
  }
}