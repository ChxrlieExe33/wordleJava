import java.util.Random;
import java.util.Scanner;

/**
 * Clase principal del juego, contiene la lógica principal
 * @author Charles Crane
 * @version 1.0
 */
public class WordleGame {

    private int MAX_TRIES;
    private int WORD_LENGTH;

    private String[] fileWords;
    private String secretWord;

    private int remainingAttempts;
    private String[] triesHistory;

    /**
     * Constructor del juego
     * @param fileWords Array de palabras extraídas de un fichero
     */
    public WordleGame(String[] fileWords) {

        this.WORD_LENGTH = 5;
        this.fileWords = fileWords;
        this.MAX_TRIES = 6;
        this.remainingAttempts = MAX_TRIES;
        this.triesHistory = new String[remainingAttempts];
        this.secretWord = selectRandomWord(fileWords);

    }

    /**
     * Función principal del juego, controla el flujo
     * Entra en un bucle hasta que acaben los intentos restantes
     * @see WordleFeedBack
     */
    public void start(){

        System.out.println("Bienvenido a Wordle\n");

        Scanner sc = new Scanner(System.in);
        String input;
        String resultado;
        boolean juegoGanado = false;
        int intento = 0;

        System.out.println("Palabra secreta para mostrar funcionamiento: " + secretWord);

        // Continuar juego hasta que se agoten los intentos
        while(remainingAttempts > 0){

            // No mostrar la historia si es el primer intento, ya que estará vació
            if(intento > 0){
                showTriesHistory();
            }

            System.out.println("Tienes " + remainingAttempts + " intentos");
            input = getUserInput(sc);

            // Guardar palabra sin colores al fichero de juegos
            WordleFileManager.writeGameHistory(input);
            resultado = WordleFeedBack.feedBackString(input, secretWord);
            triesHistory[intento] = resultado;

            // Terminar bucle si palabra es correcta
            if(input.equals(secretWord)){
                juegoGanado = true;
                break;
            }
            intento++;
            remainingAttempts--;
        }

        WordleFileManager.writeGameHistory("Palabra secreta: " + secretWord);
        WordleFileManager.writeGameHistory("-----");

        // Mostrar mensaje adecuado del resultado del juego
        if(juegoGanado){
            showTriesHistory();
            System.out.println("Enhorabuena, has ganado!");
        } else {
            showTriesHistory();
            System.out.println("Has perdido, La palabra secreta era: " + secretWord);
        }

    }

    /**
     * Muestra el historial de intentos formateado
     */
    private void showTriesHistory(){

        System.out.println("--------------------");
        System.out.println("Intentos:");

        for(int i=0; i<triesHistory.length; i++){

            if(triesHistory[i] != null){
                System.out.println(triesHistory[i]);
            }

        }

        System.out.println("--------------------");


    }

    /**
     * Elige una palabra al azar del array proporcionado
     * @param words Array de palabras
     * @return Una palabra al azar
     */
    private String selectRandomWord(String[] words){

        // Obtener numero al azar para elegir palabra secreta
        Random r = new Random();
        int randomIndex = r.nextInt(words.length);

        return words[randomIndex];
    }

    /**
     * Recibe palabra del usuario, comprueba la longitud, si es incorrecto, lo pide de nuevo hasta que sea correcto
     * @param sc Objeto Scanner para tomar input
     * @return La palabra de longitud correcta
     */
    private String getUserInput(Scanner sc){

        System.out.println("Introduce una palabra de " + WORD_LENGTH + " letras:");
        System.out.print("-> ");
        String palabra = sc.nextLine();

        palabra = palabra.toUpperCase();

        while (true){

            // Mantenerse en el bucle hasta que la palabra introducida tiene la longitud correcta
            if (palabra.length() == WORD_LENGTH){
                break;
            } else {
                System.out.println("\u001B[31m" + "La palabra tiene que ser de " + WORD_LENGTH + " letras, intentalo otra vez" + "\u001B[0m");
                System.out.print("-> ");
                palabra = sc.nextLine();
                palabra = palabra.toUpperCase();
            }

        }

        return palabra;

    }

}
