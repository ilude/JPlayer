package jplayer.ui.components;

public class VolatileInteger extends Number
{
  private int value = 0;

  public VolatileInteger()
  {
  }

  public final void setInt(int i)   { this.value = i; }
  public final double doubleValue() { return (double)value; }
  public final float floatValue()   { return (float)value; }
  public final long longValue()     { return (long)value; }
  public final int intValue()       { return value; }
  public final String toString()    { return Integer.toString(value); }
}