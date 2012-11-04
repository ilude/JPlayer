package jplayer.ui.components;

public class OnOffLabel extends Label
{
	private static final String SPACE = " ";

	private  Object on_value  = SPACE;
	private  Object off_value = SPACE;

	private  boolean state    = false;

	public OnOffLabel(Object on_value, Object off_value)
	{
		if( on_value == null ||  on_value.equals(""))  on_value = SPACE;
		if(off_value == null || off_value.equals("")) off_value = SPACE;

		this.on_value   = on_value;
		this.off_value  = off_value;

		int length = 1;
		if(on_value.toString().length() > off_value.toString().length())
			length = on_value.toString().length();
		else
			length = off_value.toString().length();

		super.setWidth(length);
		super.setValue(off_value);
	}

	public boolean isDisplaying()
	{
		return state;
	}

	public void display(boolean display)
	{
		if(display == true)
		{
			super.setValue(on_value);
		}
		else
		{
			super.setValue(off_value);
		}

		state = display;
	}
}