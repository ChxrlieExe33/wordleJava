import java.util.Scanner;

public class WordleGame {

    private int MAX_TRIES;
    private int WORD_LENGTH;

    private String fileWords;
    private String secretWord;

    private int remainingAttempts;
    private String[] triesHistory;

    // Constructor
    public WordleGame(String fileWords) {

        this.fileWords = fileWords;
        this.remainingAttempts = 6;
        this.triesHistory = new String[remainingAttempts];


    }

    /**
     * This method starts the game
     * Calls showTriesHistory to show list of attempts
     * Uses getUserInput to get word off user
     * Repeats everything in a while loop based off the tries left
     * If word is correct, show congratulations message
     * If user fails, reduce tries by 1 and use feedBackString to give user feedback on the try
     */
    public void start(){

    }

    /**
     * Loops through the triesHistory array and prints the history
     */
    private void showTriesHistory(){

    }

    /**
     * Returns random word from array
     * @param words
     * @return
     */
    private String selectRandomWord(String[] words){
        return "Hello";
    }

    /**
     * Uses the scanner to get user word input
     * Validates its 5 letters long and returns it
     * If length is wrong, display error message and try input again
     * @param sc
     * @return
     */
    private String getUserInput(Scanner sc){
        return "Hello";
    }

}
