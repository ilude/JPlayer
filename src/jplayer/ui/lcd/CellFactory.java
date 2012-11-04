package jplayer.ui.lcd;

import java.awt.*;
import java.awt.image.*;

public class CellFactory
{
  private static final int WIDTH     = 7;
  private static final int HEIGHT    = 9;
  private static final int RGB_BLACK = Color.black.getRGB();
  private static final int RGB_GREEN = new Color(156, 203, 33).getRGB();

  private BufferedImage[] image_array = new BufferedImage[256];

  public CellFactory()
  {
  }

  public BufferedImage getImage(int index)
  {
    BufferedImage image = null;

    if(image_array[index] == null)
    {
      // image has not been generated yet
      image = _generateImage(index);

      // store the image
      image_array[index] = image;
    }
    else
    {
      // use the stored image
      image = image_array[index];
    }

    return image;
  }

  private static BufferedImage _generateImage(int i)
  {
    BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    boolean[][] map = Char.getMap(i);

    for(int y=0; y<HEIGHT; y++)
    {
      for(int x=0; x<WIDTH; x++)
      {
        image.setRGB(x, y, (map[y][x]) ? RGB_BLACK : RGB_GREEN);
      }
    }

    return image;
  }
}