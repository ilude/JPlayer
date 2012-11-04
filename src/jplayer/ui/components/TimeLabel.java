package jplayer.ui.components;

import java.text.*;
import java.util.*;

import jplayer.ui.*;

public class TimeLabel extends Component
{
	private static final int    MAX_LENGTH  = 5;

	private NumberFormat formatter = new DecimalFormat("00");
	private StringBuffer str       = new StringBuffer("00:00");

	public TimeLabel()
	{
		super();
		super.setWidth(MAX_LENGTH);
	}

	public void setValue(Object obj)
	{
		try
		{
			int seconds = ((Number)obj).intValue();

			str.replace(0,2, formatter.format( seconds / 60 ));
			str.replace(3,5, formatter.format( seconds % 60 ));

			super.setOutput(str.toString());
		}
		catch(ClassCastException e) {}
	}
}