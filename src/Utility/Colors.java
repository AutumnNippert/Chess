package Utility;

public class Colors {
    //COLORS
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    //BACKGROUND COLORS
    public static final String BLACK_BACKGROUND = "\u001B[40m";
    public static final String RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m";
    public static final String YELLOW_BACKGROUND = "\u001B[43m";
    public static final String BLUE_BACKGROUND = "\u001B[44m";
    public static final String PURPLE_BACKGROUND = "\u001B[45m";
    public static final String CYAN_BACKGROUND = "\u001B[46m";
    public static final String WHITE_BACKGROUND = "\u001B[47m";

    /**
     * Returns a string with a color.
     * @param s input string
     * @param c input color
     * @return String with color
     */
    public static String stringColor(String s, String c)
    {
        String colorStr = "";
        for (String string : s.split("\n")) {
            colorStr += c + s + Colors.RESET + "\n";
        }
        return colorStr;
    }

    /**
     * Returns a string with a color.
     * @param s input string
     * @param cFore input color foreground
     * @param cBack input color background
     * @return String with color
     */
    public static String stringColor(String s, String cFore, String cBack)
    {
        String colorStr = "";
        for (String string : s.split("\n")) {
            colorStr += cBack + cFore + s + Colors.RESET + "\n";
        }
        return colorStr;
    }
}