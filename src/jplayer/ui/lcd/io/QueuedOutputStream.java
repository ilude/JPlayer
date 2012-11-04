package jplayer.ui.lcd.io;

import java.io.*;



public class QueuedOutputStream extends OutputStream
{
  private ByteQueue queue = null;

  public QueuedOutputStream()
  {
    queue = new ByteQueue();
  }

  public void write(int b) throws java.io.IOException
  {
    queue.add( (byte)Math.abs(b) );
  }

  public void write(byte[] b) throws java.io.IOException
  {
    queue.add(b);
  }

  public void write(byte[] b, int offset, int length) throws java.io.IOException
  {
    byte[] new_array = new byte[length];
    System.arraycopy( b, offset, new_array, 0, length);
    queue.add(new_array);
  }

  public int readInt()
  {
    int i = (int)queue.remove();

    // integers are signed. This converts them to unsigned.
    if( i < 0 ) i += 256;

    return i;
  }
}