package jplayer.ui.lcd.io;

public class ByteQueue
{
  private static final int INITIAL_QUEUE_SIZE = 160;

  private byte[]  queue         = null;
  private int     write_cursor  = 0;
  private int     read_cursor   = 0;

  public ByteQueue()
  {
    queue   = new byte[INITIAL_QUEUE_SIZE];
  }

  public ByteQueue(int initial_capacity)
  {
    queue   = new byte[initial_capacity];
    write_cursor  = 0;
  }

  public synchronized final void add(byte b)
  {
    ensure_capacity(1);

    queue[write_cursor++] = b;

    // notifies remove method that the queue has data
    this.notify();
  }

  public synchronized final void add(byte[] b)
  {
    ensure_capacity(b.length);

    System.arraycopy( b, 0, queue, write_cursor, b.length);
    write_cursor += b.length;

    // notifies remove method that the queue has data
    this.notify();
  }

  public synchronized final byte remove()
  {
    try
    {
      while(read_cursor == write_cursor)
      {
        read_cursor   = 0;
        write_cursor  = 0;
        this.wait();
      }
    }
    catch(Exception e) {}

    return queue[read_cursor++];
  }

  private final void ensure_capacity(int length)
  {
    if(queue.length - write_cursor < length && read_cursor > length)
    {
      System.arraycopy(queue, read_cursor, queue, 0, write_cursor - read_cursor);
      write_cursor  = write_cursor - read_cursor;
      read_cursor   = 0;
    }
    else if(queue.length - write_cursor < length)
    {
      byte[] new_queue = new byte[queue.length * 2];
      System.arraycopy( queue, read_cursor, new_queue, 0, write_cursor - read_cursor);
      queue = new_queue;
    }
  }
}