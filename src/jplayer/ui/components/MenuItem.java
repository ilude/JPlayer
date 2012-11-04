package jplayer.ui.components;

public class MenuItem
{
	private final static String ARROW = new String(new char[] {127});

	private OnOffLabel  select    = new OnOffLabel(ARROW, null);
	private Label       label     = new Label("");
	private String      text      = "";
	private Menu        sub_menu  = null;

	public MenuItem(String label_text)
	{
		this.label.setValue(label_text);
		this.text = label_text;
	}

	public void setSubMenu(Menu menu)
	{
		this.sub_menu = menu;
	}

	public Menu getSubMenu()
	{
		return sub_menu;
	}

	public boolean hasSubMenu()
	{
		return (sub_menu != null);
	}

	public void setSelected()
	{
		if(select.isDisplaying())
		{
			select.display(false);
		}
		else
		{
			select.display(true);
		}
	}

	public boolean isSelected()
	{
		return select.isDisplaying();
	}

	public Component getSelector()
	{
		return select;
	}

	public Component getLabel()
	{
		return label;
	}
	public String toString()
	{
		return text;
	}
}