package jplayer.ui.lcd;

import java.awt.*;
import javax.swing.*;

public class LCDBorder extends JPanel
{
  private Dimension size;

  public LCDBorder(int width, int height)
  {
    size = super.getSize();
    size.setSize(width, height);

    super.setBackground(Color.BLACK);
  }

  public Dimension getPreferredSize()
  {
    return size;
  }
}