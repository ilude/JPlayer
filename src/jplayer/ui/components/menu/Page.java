package jplayer.ui.components.menu;

import jplayer.ui.*;
import jplayer.ui.components.*;

public class Page extends Screen
{
	private MenuItem[] items  = new MenuItem[4];
	private int  items_index  = 0;
	private int  select_index = 0;

	public Page()
	{
		super("Menu Page");
		for(int i = 0; i < items.length; i++)
			items[i] = null;
	}

	public boolean addMenuItem(MenuItem item)
	{
		if(items_index < items.length - 1)
		{
			items[items_index] = item;

			Component select = item.getSelector();
			Component label  = item.getLabel();

			select.setLocation(0, items_index);
			super.addComponent(select);

			label.setLocation(1, items_index);
			super.addComponent(label);

			items_index++;
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean next()
	{
		if(select_index < items.length - 1)
		{
			((MenuItem)items[select_index]).setSelected();

			select_index++;

			((MenuItem)items[select_index]).setSelected();

			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean back()
	 {
		 if(select_index > 0)
		 {
			 ((MenuItem)items[select_index]).setSelected();

			 select_index--;

			 ((MenuItem)items[select_index]).setSelected();

			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }

	public MenuItem getSelected()
	{
		for(int i = 0; i < items.length; i++)
			if (items[i] != null && ((MenuItem)items[i]).isSelected())
				return (MenuItem)items[i];

		return null;
	}

}