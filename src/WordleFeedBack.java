/**
 * Clase encargada de colorear los intentos de palabras basados en como de correcto era
 * @author Charles Crane
 * @version 1.0
 */
public class WordleFeedBack {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    /**
     * Colorea la letra pasada con el color especificado.
     * @param letter Letra para ser coloreada
     * @param color Codio de color ANSI
     * @return String con la letra coloreada
     */
    private static String applyColor(String letter, String color) {

        return color + letter;

    }

    /**
     * Hace un bucle donde revisa cada letra de la palabra intentada comparándolo con la
     * palabra secreta y especificando que color hay que aplicar
     *
     * @param guess Intento de palabra
     * @param secretWord Palabra secreta
     * @return String coloreado de la palabra intentada
     */
    public static String feedBackString(String guess, String secretWord){

        // Utilizando un StringBuilder para construir el string final
        StringBuilder sb = new StringBuilder();

        // Empezar con un reset por si el ultimo string lleva color
        sb.append(ANSI_RESET);

        // Comparar todas las letras del intento
        for (int i = 0; i < guess.length(); i++) {

            char c = guess.charAt(i);

            if(c == secretWord.charAt(i)){

                // Si la letra esta en la posición correcta
                sb.append(applyColor(String.valueOf(c), ANSI_GREEN));

            } else if (secretWord.contains(String.valueOf(c))) {

                // Si la letra existe en la palabra, pero está en la posición incorrecta
                sb.append(applyColor(String.valueOf(c), ANSI_YELLOW));

            } else {

                // Si la letra no existe en la palabra
                sb.append(applyColor(String.valueOf(c), ANSI_RESET));

            }
        }

        // Añadir reset al final porque a veces colorea el siguiente string también si no lo aplicas
        sb.append(ANSI_RESET);

        return sb.toString();

    }

}
