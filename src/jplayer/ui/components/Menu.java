package jplayer.ui.components;

import java.util.*;
import jplayer.event.*;
import jplayer.ui.components.menu.*;

public class Menu extends CommandListener
{
	private List         pages = new ArrayList(3);
	private int     page_index = -1;
	private int  display_index =  0;

	private Menu     parent = null;

	public Menu()
	{
	}

	public void addMenuItem(MenuItem menu_item)
	{
		if(pages.isEmpty())
		{
			this.addPage(menu_item);
		}
		else
		{
			Page page = (Page)pages.get(page_index);
			if(!page.addMenuItem(menu_item))
			{
				this.addPage(menu_item);
			}
		}
	}

	private void addPage(MenuItem menu_item)
	{
		page_index++;

		Page page = new Page();
		page.addMenuItem(menu_item);

		pages.add(page_index, page);
	}

	public void upButtonPressed()
	{
		Page page = (Page)pages.get(display_index);
		if(!page.back() && display_index > 0)
		{
			display_index--;

			page.setVisible(false);

			((Page)pages.get(display_index)).setVisible(true);
		}
	}

	public void downButtonPressed()
	{
		Page page = (Page)pages.get(display_index);
		if(!page.next() && display_index < page_index)
		{
			display_index++;

			page.setVisible(false);

			((Page)pages.get(display_index)).setVisible(true);
		}
	}

	public void selectButtonPressed()
	{
		Page page = (Page)pages.get(display_index);
		MenuItem menu_item = page.getSelected();

		System.out.println(menu_item + " selected!");
	}

	public void menuButtonPressed()
	{
	 /**@todo Implement this jplayer.event.ButtonListener abstract method*/
	}

	public void playButtonPressed()	{}
	public void muteButtonPressed() {}
	public void lastButtonPressed()	{}
	public void nextButtonPressed() {}
}