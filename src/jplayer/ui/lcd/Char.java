package jplayer.ui.lcd;

public class Char
{
  public static final byte BLOCK          = 6;
  public static final byte SPACE          = 32;
  public static final byte CURSOR_MOVE    = 71;
  public static final byte CURSOR_HOME    = 72;
  public static final byte CURSOR_RIGHT   = 76;
  public static final byte CURSOR_LEFT    = 77;
  public static final byte CLEAR_DISPLAY  = 88;
  public static final byte COMMAND        = (byte)254;

  public static final boolean[][] getMap(int index)
  {
    return (boolean[][])map[index];
  }

  private static final boolean O = false;
  private static final boolean X = true;

  private static final boolean [][] EXCLAMATION_MARK = {
    {O,O,O,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final  boolean [][] DOUBLE_QUOTE = {
    {O,O,O,O,O,O,O},
    {O,O,X,O,X,O,O},
    {O,O,X,O,X,O,O},
    {O,O,X,O,X,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] POUND_SIGN = {
    {O,O,O,O,O,O,O},
    {O,O,X,O,X,O,O},
    {O,O,X,O,X,O,O},
    {O,X,X,X,X,X,O},
    {O,O,X,O,X,O,O},
    {O,X,X,X,X,X,O},
    {O,O,X,O,X,O,O},
    {O,O,X,O,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] DOLLAR_SIGN = {
    {O,O,O,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,X,X,X,O},
    {O,X,O,X,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,X,O,X,O},
    {O,X,X,X,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] PERCENT_SIGN = {
    {O,O,O,O,O,O,O},
    {O,X,X,O,O,O,O},
    {O,X,X,O,O,X,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,X,O,O,X,X,O},
    {O,O,O,O,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] AMPERSAND = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,O,O,O},
    {O,X,O,O,X,O,O},
    {O,X,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,X,O,X,O,X,O},
    {O,X,O,O,X,O,O},
    {O,O,X,X,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] APOSTROPHY = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] LEFT_PARENT = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] RIGHT_PARENT = {
    {O,O,O,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] ASTRICK = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,X,O,X,O,X,O},
    {O,O,X,X,X,O,O},
    {O,X,O,X,O,X,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] PLUS = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] COMMA = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] MINUS = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] PERIOD = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] RIGHT_SLASH = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,X,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] ZERO = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,X,X,O},
    {O,X,O,X,O,X,O},
    {O,X,X,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] ONE = {
    {O,O,O,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] TWO = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,X,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] THREE = {
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] FOUR = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,X,O,O},
    {O,O,X,O,X,O,O},
    {O,X,O,O,X,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] FIVE = {
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,X,O,O,O,O,O},
    {O,X,X,X,X,O,O},
    {O,O,O,O,O,X,O},
    {O,O,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] SIX = {
    {O,O,O,O,O,O,O},
    {O,O,O,X,X,O,O},
    {O,O,X,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] SEVEN = {
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,X,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] EIGHT = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] NINE = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,X,O},
    {O,O,O,O,O,X,O},
    {O,O,O,O,X,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] COLON = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] SEMI_COLON = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] LESS_THAN = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] EQUAL = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] GREATER_THAN = {
    {O,O,O,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,O,X,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] QUESTION_MARK = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] AT_SIGN = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,X,O},
    {O,O,X,X,O,X,O},
    {O,X,O,X,O,X,O},
    {O,X,O,X,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_A = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,X,X,X,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_B = {
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_C = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_D = {
    {O,O,O,O,O,O,O},
    {O,X,X,X,O,O,O},
    {O,X,O,O,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,X,O,O},
    {O,X,X,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_E = {
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,X,X,X,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_F = {
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,X,X,X,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_G = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,O,O},
    {O,X,O,X,X,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_H = {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,X,X,X,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_I= {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_J= {
    {O,O,O,O,O,O,O},
    {O,O,O,X,X,X,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,X,O,O},
    {O,X,O,O,X,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,O,O,O,O}};


  private static final boolean [][] U_K= {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,X,O,O},
    {O,X,O,X,O,O,O},
    {O,X,X,O,O,O,O},
    {O,X,O,X,O,O,O},
    {O,X,O,O,X,O,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_L= {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_M= {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,X,O,X,X,O},
    {O,X,O,X,O,X,O},
    {O,X,O,X,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_N= {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,X,O,O,X,O},
    {O,X,O,X,O,X,O},
    {O,X,O,O,X,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_O= {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_P= {
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,X,X,X,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_Q= {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,X,O,X,O},
    {O,X,O,O,X,O,O},
    {O,O,X,X,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_R= {
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,X,X,X,O,O},
    {O,X,O,X,O,O,O},
    {O,X,O,O,X,O,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_S= {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_T= {
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_U= {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_V= {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_W= {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,X,O,X,O},
    {O,X,O,X,O,X,O},
    {O,X,O,X,O,X,O},
    {O,O,X,O,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_X= {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_Y= {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] U_Z= {
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,X,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] LEFT_BRACKET = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] SYMBOL_X = {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,O,X,O,X,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,X,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] RIGHT_BRACKET = {
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,X,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] CARROT = {
    {O,O,O,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,X,O,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] UNDERSCORE = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] UPPER_SLASH = {
    {O,O,O,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_A= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,X,O},
    {O,O,X,X,X,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_B= {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,X,X,O,O},
    {O,X,X,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_C= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_D= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,X,O},
    {O,O,O,O,O,X,O},
    {O,O,O,O,O,X,O},
    {O,O,X,X,O,X,O},
    {O,X,O,O,X,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_E= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,X,X,X,X,O},
    {O,X,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_F= {
    {O,O,O,O,O,O,O},
    {O,O,O,X,X,O,O},
    {O,O,X,O,O,X,O},
    {O,O,X,O,O,O,O},
    {O,X,X,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_G= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,X,O},
    {O,O,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_H= {
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,X,X,O,O},
    {O,X,X,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_I= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_J= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,X,X,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,X,O,O},
    {O,X,O,O,X,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_K= {
    {O,O,O,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,X,O},
    {O,O,X,O,X,O,O},
    {O,O,X,X,O,O,O},
    {O,O,X,O,X,O,O},
    {O,O,X,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_L= {
    {O,O,O,O,O,O,O},
    {O,O,X,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_M= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,O,X,O,O},
    {O,X,O,X,O,X,O},
    {O,X,O,X,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_N= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,O,X,X,O,O},
    {O,X,X,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_O= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_P= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,O,O},
    {O,X,O,O,O,X,O},
    {O,X,X,X,X,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_Q= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,O,X,O},
    {O,X,O,O,X,X,O},
    {O,O,X,X,X,X,O},
    {O,O,O,O,O,X,O},
    {O,O,O,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_R= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,O,X,X,O,O},
    {O,X,X,O,O,X,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,X,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_S= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,X,O,O,O,O,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,X,O},
    {O,X,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_T= {
    {O,O,O,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,X,X,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,X,O,O,X,O},
    {O,O,O,X,X,O,O},
    {O,O,O,O,O,O,O}};


  private static final boolean [][] L_U= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,X,X,O},
    {O,O,X,X,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_V= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_W= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,X,O,X,O,X,O},
    {O,X,O,X,O,X,O},
    {O,O,X,O,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_X= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,O,X,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,X,O,O},
    {O,X,O,O,O,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_Y= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,O,O,O,X,O},
    {O,X,O,O,O,X,O},
    {O,O,X,X,X,X,O},
    {O,O,O,O,O,X,O},
    {O,O,X,X,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] L_Z= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] LEFT_BRACE= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] PIPE= {
    {O,O,O,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] RIGHT_BRACE= {
    {O,O,O,O,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] LEFT_ARROW= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,X,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,X,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] RIGHT_ARROW= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,X,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,X,O,O,O,O},
    {O,O,O,X,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] BAR_ONE= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] BAR_TWO= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] BAR_THREE= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] BAR_FOUR= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] BAR_FIVE= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] BAR_SIX= {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] BAR_SEVEN= {
    {O,O,O,O,O,O,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,X,X,X,X,X,O},
    {O,O,O,O,O,O,O}};

  private static final boolean [][] SPACE_MAP = {
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O},
    {O,O,O,O,O,O,O}};

  public static final Object[] map       = new Object[256];

  static
  {
    map[0] = BAR_ONE;
    map[1] = BAR_TWO;
    map[2] = BAR_THREE;
    map[3] = BAR_FOUR;
    map[4] = BAR_FIVE;
    map[5] = BAR_SIX;
    map[6] = BAR_SEVEN;
    map[32] = SPACE_MAP;
    map[33] = EXCLAMATION_MARK;
    map[34] = DOUBLE_QUOTE;
    map[35] = POUND_SIGN;
    map[36] = DOLLAR_SIGN;
    map[37] = PERCENT_SIGN;
    map[38] = AMPERSAND;
    map[39] = APOSTROPHY;
    map[40] = LEFT_PARENT;
    map[41] = RIGHT_PARENT;
    map[42] = ASTRICK;
    map[43] = PLUS;
    map[44] = COMMA;
    map[45] = MINUS;
    map[46] = PERIOD;
    map[47] = RIGHT_SLASH;
    map[48] = ZERO;
    map[49] = ONE;
    map[50] = TWO;
    map[51] = THREE;
    map[52] = FOUR;
    map[53] = FIVE;
    map[54] = SIX;
    map[55] = SEVEN;
    map[56] = EIGHT;
    map[57] = NINE;
    map[58] = COLON;
    map[59] = SEMI_COLON;
    map[60] = LESS_THAN;
    map[61] = EQUAL;
    map[62] = GREATER_THAN;
    map[63] = QUESTION_MARK;
    map[64] = AT_SIGN;
    map[65] = U_A;
    map[66] = U_B;
    map[67] = U_C;
    map[68] = U_D;
    map[69] = U_E;
    map[70] = U_F;
    map[71] = U_G;
    map[72] = U_H;
    map[73] = U_I;
    map[74] = U_J;
    map[75] = U_K;
    map[76] = U_L;
    map[77] = U_M;
    map[78] = U_N;
    map[79] = U_O;
    map[80] = U_P;
    map[81] = U_Q;
    map[82] = U_R;
    map[83] = U_S;
    map[84] = U_T;
    map[85] = U_U;
    map[86] = U_V;
    map[87] = U_W;
    map[88] = U_X;
    map[89] = U_Y;
    map[90] = U_Z;
    map[91] = LEFT_BRACKET;
    map[92] = SYMBOL_X;
    map[93] = RIGHT_BRACKET;
    map[94] = CARROT;
    map[95] = UNDERSCORE;
    map[96] = UPPER_SLASH;
    map[97] = L_A;
    map[98] = L_B;
    map[99] = L_C;
    map[100] = L_D;
    map[101] = L_E;
    map[102] = L_F;
    map[103] = L_G;
    map[104] = L_H;
    map[105] = L_I;
    map[106] = L_J;
    map[107] = L_K;
    map[108] = L_L;
    map[109] = L_M;
    map[110] = L_N;
    map[111] = L_O;
    map[112] = L_P;
    map[113] = L_Q;
    map[114] = L_R;
    map[115] = L_S;
    map[116] = L_T;
    map[117] = L_U;
    map[118] = L_V;
    map[119] = L_W;
    map[120] = L_X;
    map[121] = L_Y;
    map[122] = L_Z;
    map[123] = LEFT_BRACE;
    map[124] = PIPE;
    map[125] = RIGHT_BRACE;
    map[126] = LEFT_ARROW;
    map[127] = RIGHT_ARROW;
  }
}