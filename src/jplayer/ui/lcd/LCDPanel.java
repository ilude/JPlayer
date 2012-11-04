package jplayer.ui.lcd;

import java.io.*;
import java.awt.*;
import javax.swing.*;

import jplayer.ui.*;
import jplayer.ui.lcd.io.*;

public class LCDPanel extends JPanel implements Runnable
{
  public static final int    PLAY_COMMAND   = 1;
  public static final int    MUTE_COMMAND   = 2;
  public static final int    MENU_COMMAND   = 3;
  public static final int    SELECT_COMMAND = 4;
  public static final int    UP_COMMAND     = 10;
  public static final int    DW_COMMAND     = 20;
  public static final int    NEXT_COMMAND   = 30;
  public static final int    LAST_COMMAND   = 40;

  protected static final int ROWS           = 4;
  protected static final int COLUMNS        = 40;

  protected static final int SIDE_WIDTH     = 18;
  protected static final int SIDE_HEIGHT    = 36;

  // Display vars
  private Cell[][]            cell          = new Cell[ROWS][COLUMNS];
  private JPanel              display       = null;
  private DisplayCursor       cursor        = null;

  private PushButton          up_button     = new PushButton(UP_COMMAND);
  private PushButton          dw_button     = new PushButton(DW_COMMAND);
  private PushButton          play_button   = new PushButton(PLAY_COMMAND);
  private PushButton          mute_button   = new PushButton(MUTE_COMMAND);
  private PushButton          menu_button   = new PushButton(MENU_COMMAND);
  private PushButton          select_button = new PushButton(SELECT_COMMAND);
  private PushButton          next_button   = new PushButton(NEXT_COMMAND);
  private PushButton          last_button   = new PushButton(LAST_COMMAND);


  // IO Stream vars
  private QueuedOutputStream  outputstream  = null;
  private InputHandler        input         = null;
  private Thread              this_thread   = null;

  public LCDPanel()
  {
    display = new JPanel();
    display.setLayout(new GridLayout(ROWS, COLUMNS, 0 ,0));

    this.setLayout(new BorderLayout(0,0));

    // Button Handler
    input = new InputHandler();

    play_button.addMouseListener(input);
    mute_button.addMouseListener(input);

    menu_button.addMouseListener(input);
    select_button.addMouseListener(input);

    up_button.addMouseListener(input);
    dw_button.addMouseListener(input);

    next_button.addMouseListener(input);
    last_button.addMouseListener(input);

    // Corner Panels
    JPanel north_panel  = createPanel();
    JPanel south_panel  = createPanel();
    JPanel east_panel   = new LCDBorder(SIDE_WIDTH, SIDE_HEIGHT);
    JPanel west_panel   = new LCDBorder(SIDE_WIDTH, SIDE_HEIGHT);


    JPanel north_border = createPanel();
    north_border.add(new LCDBorder(SIDE_WIDTH, SIDE_WIDTH), "West");
    north_border.add(north_panel,  "Center");
    north_border.add(new LCDBorder(SIDE_WIDTH, SIDE_WIDTH), "East");

    JPanel south_border = createPanel();
    south_border.add(new LCDBorder(SIDE_WIDTH, SIDE_WIDTH), "West");
    south_border.add(south_panel,  "Center");
    south_border.add(new LCDBorder(SIDE_WIDTH, SIDE_WIDTH), "East");

    JPanel a_panel = new JPanel(new FlowLayout());
    a_panel.setBackground(Color.BLACK);
    a_panel.add(menu_button);
    a_panel.add(select_button);

    north_panel.add(a_panel, "West");

    JPanel b_panel = new JPanel(new FlowLayout());
    b_panel.setBackground(Color.BLACK);
    b_panel.add(play_button);
    b_panel.add(mute_button);

    JPanel c_panel = new JPanel(new FlowLayout());
    c_panel.setBackground(Color.BLACK);
    c_panel.add(last_button);
    c_panel.add(next_button);

    south_panel.add(b_panel, "West");
    south_panel.add(c_panel, "East");

    JPanel top_side = createSidePanel();
    JPanel bot_side = createSidePanel();

    top_side.add(up_button);
    bot_side.add(dw_button);

    west_panel.add(top_side, "North");
    west_panel.add(bot_side, "South");

    this.add(north_border,  "North");
    this.add(south_border,  "South");
    this.add(west_panel,   "West");
    this.add(east_panel,    "East");
    this.add(display,       "Center");

    for(int x=0; x<ROWS; x++)
    {
      for(int y=0; y<COLUMNS; y++)
      {
        cell[x][y] = new Cell();
        display.add(cell[x][y]);
      }
    }

    this_thread = new Thread(this);
    this_thread.setName("LCD Panel");
    cursor      = new DisplayCursor();
  }

  public OutputStream getOutputStream()
  {
    if(outputstream == null)
    {
      outputstream = new QueuedOutputStream();
      if(!this_thread.isAlive())
      {
        this_thread.start();
      }
    }

    return outputstream;
  }

  public InputStream getInputStream()
  {
    return input;
  }

  public void run()
  {
    while(true)
    {
      int c = outputstream.readInt();

      switch(c)
      {
        case 254:
          processCommand();
          break;
        default:
          displayChar(c);
          break;
      }
    }
  }

  private void displayChar(int c)
  {
    cell[cursor.getX()][cursor.getY()].display(c);
    cursor.increment();
  }

  private void clear()
  {
    for(int x=0; x<ROWS; x++)
    {
      for(int y=0; y<COLUMNS; y++)
      {
        cell[x][y].clear();
      }
    }
  }

  private void processCommand()
  {
    int c = outputstream.readInt();

    switch(c)
    {
      case 71:
      // move cursor to (x,y)
      int x = outputstream.readInt();
      int y = outputstream.readInt();
      cursor.setLocation( x, y);
      break;
          case 72:
      // move cursor home
      cursor.setLocation( 0, 0);
      break;
          case 74:
      // turn on cursor underline
      break;
          case 75:
      // turn off cursor underline
      break;
          case 76:
      // move cursor right
      cursor.increment();
      break;
          case 77:
      // move cursor left
      cursor.decrement();
      break;
          case 81:
      // auto scroll on
      break;
          case 82:
      // auto scroll off
      break;
          case 83:
      // turn on blinking block cursor
      break;
          case 84:
      // turn off blinking block cursor
      break;
          case 88:
      clear();
      break;
    }
  }

  private static final JPanel createPanel()
  {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBackground(Color.BLACK);

    return panel;
  }

  private static final JPanel createSidePanel()
  {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBackground(Color.BLACK);

    return panel;
  }
}