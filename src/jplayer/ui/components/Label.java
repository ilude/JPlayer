package jplayer.ui.components;


import jplayer.ui.*;



public class Label extends Component
{
	public Label()
	{
		super();
	}

	public Label(Object obj)
	{
		super();
		this.setValue(obj);
	}

	public Label(Object obj, int x, int y)
	{
		super();
		super.setLocation(x, y);

		this.setValue(obj);
	}

	public void setValue(Object obj)
	{
		if(obj == null) obj = "";

		super.setWidth(obj.toString().length());
		super.setOutput(obj.toString());
	}
}