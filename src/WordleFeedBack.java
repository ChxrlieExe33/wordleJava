public class WordleFeedBack {

    private static final int WORD_LENGTH = 5;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    /**
     * Will color each letter sent to it
     * @param letter
     * @param color
     * @return
     */
    private static String applyColor(String letter, String color) {
        return "";
    }

    /**
     * This will loop through the letters of each word at the same index, check if they are the same,
     * and call applyColor to color each one appropriately
     *
     * @param guess
     * @param secretWord
     * @return
     */
    public static String feedBackString(String guess, String secretWord){
        return "";
    }

}
