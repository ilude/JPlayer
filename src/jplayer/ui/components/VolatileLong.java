package jplayer.ui.components;

public class VolatileLong extends Number
{
  private long value = 0;

  public VolatileLong() {}

  public final void setLong(long l)
  {
    this.value = l;
  }

  public final double doubleValue() { return (double)value; }
  public final float floatValue()   { return (float)value;}
  public final long longValue()     { return value; }
  public final int intValue()       { return (int)value; }
  public final String toString()    { return Long.toString(value); }
}