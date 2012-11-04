package jplayer.ui.lcd;

import java.awt.*;
import java.awt.image.*;

public class Cell extends Canvas
{
  private static final int WIDTH  = 7;
  private static final int HEIGHT = 9;

  private static final Dimension    size = new Dimension(WIDTH, HEIGHT);
  private static final CellFactory  fact = new CellFactory();

  private static int last_displayed = 0;

  BufferedImage image;

  public Cell(int i)
  {
    this.display(i);
  }

  public Cell()
  {
    this.display( Char.SPACE );
  }

  public final void clear()
  {
    this.display( Char.SPACE );
  }

  public final void display(int i)
  {
    if(i != last_displayed)
    {
      image = fact.getImage(i);
      this.repaint();
    }
  }

  public void paint(Graphics g)
  {
    g.drawImage(image, 0,0, this);
  }

  public Dimension getSize()          { return size; }
  public Dimension getMinimumSize()   { return size; }
  public Dimension getMaximumSize()   { return size; }
  public Dimension getPreferredSize() { return size; }
}