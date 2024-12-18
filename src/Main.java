import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 1. Get the list of words
        String[] listaPalabras = WordleFileManager.readFileWords();

        // 2. Initialize the WordleGame class and start the game
        WordleGame game = new WordleGame(listaPalabras);
        game.start();


    }

}