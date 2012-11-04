package jplayer.audio;

import javax.sound.sampled.*;

public class AudioLine
{
  private SourceDataLine  line        = null;
  private FloatControl    gain        = null;
  private float           gain_value  = 0;
  private boolean         mute        = false;
  private boolean         stopped     = false;

  private final float     MAX_GAIN;
  private final float     MIN_GAIN;
  private final double    DELTA_GAIN;

  public AudioLine(AudioFormat target_format) throws LineUnavailableException
  {
    // initialize an audio line
    line = (SourceDataLine)AudioSystem.getLine( new DataLine.Info(SourceDataLine.class, target_format) );

    // Make sure the line is open and clear
    if( line.isActive() )
    {
      line.flush();
    }
    else
    {
      line.open(target_format);
      line.start();
    }

    // Get the gain control
    gain = (FloatControl)line.getControl(FloatControl.Type.MASTER_GAIN);
    gain_value = gain.getValue();
    MAX_GAIN   = gain.getMaximum();
    MIN_GAIN   = gain.getMinimum();
    DELTA_GAIN = (MAX_GAIN - MIN_GAIN) / 100;
  }

  public final int write(byte[] b, int src_index, int length)
  {
    return line.write(b, src_index, length);
  }

  public final int mute()
  {
    if(mute)
    {
      gain.setValue(gain_value);
      mute = false;
    }
    else
    {
      gain.setValue(MIN_GAIN);
      mute = true;
    }

    return this.gainPrecentage();
  }

  public final void flush()
  {
    line.stop();
    line.flush();
    line.start();
  }

  public final void stop()
  {
    stopped = true;
    gain.setValue(MIN_GAIN);
    line.stop();
  }

  public final void drain()
  {
    line.drain();
    line.stop();
    line.start();
  }

  public final void start()
  {
    line.start();
    gain.setValue(gain_value);
    stopped = false;
  }

  public final int increaseGain()
  {
    if(mute)
      this.mute();
    else if(gain_value + DELTA_GAIN >= MAX_GAIN)
      gain_value = MAX_GAIN;
    else
      gain_value += DELTA_GAIN;

    gain.setValue(gain_value);

    return gainPrecentage();
  }

  public final int decreaseGain()
  {
    if(mute)
      this.mute();
    else if(gain_value - DELTA_GAIN <= MIN_GAIN)
      gain_value = MIN_GAIN;
    else
      gain_value -= DELTA_GAIN;

    gain.setValue(gain_value);

    return gainPrecentage();
  }

  public int gainPrecentage()
  {
    float current = (stopped) ? gain_value : gain.getValue();
    return (int)Math.round( Math.abs(MIN_GAIN) + current / DELTA_GAIN );
  }
}