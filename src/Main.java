
/**
 * @author Charles Crane
 * @version 1.0
 */
public class Main {

    /**
     * Punto de entrada para la aplicación donde se invoca al juego
     * @param args Argumentos de linea de comandos
     */
    public static void main(String[] args) {

        // Obtener array de palabras
        String[] listaPalabras = WordleFileManager.readFileWords();

        // Declarar e inicializar el juego
        WordleGame game = new WordleGame(listaPalabras);

        // Empezar el juego
        game.start();


    }

}