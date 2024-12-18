import java.io.BufferedReader;
import java.io.*;
import java.util.*;


/**
 * Clase encargada de leer y escribir al fichero de palabras y de juegos hechos
 * @author Charles Crane
 * @version 1.0
 */
public class WordleFileManager {

    private static final String gameFile = "src\\juegos.txt";

    /**
     * Lee un fichero de palabras, los convierte a mayúsculas y las almacena en un array
     * @return Un array de palabras
     */
    public static String[] readFileWords(){

        // Utilizando un arraylist porque no sabemos cuantas palabras hay en el fichero
        List<String> wordsList = new ArrayList<String>();

        try
        {
            File file = new File("src\\palabras.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                wordsList.add(line);
            }
        }
        catch (Exception e)
        {

            e.printStackTrace();

        }

        // Convertir ArrayList a un array ya que sabemos el numero de palabras
        String[] palabras = wordsList.toArray(new String[wordsList.size()]);

        // Hacer todas palabras mayúsculas
        for(int i = 0; i < palabras.length; i++){
            palabras[i] = palabras[i].toUpperCase();
        }

        return palabras;


    }

    /**
     * Inserta el texto dentro del fichero de juego
     * @param content El contenido para escribir en cada línea
     */
    public static void writeGameHistory(String content){

        try {
            FileWriter fw = new FileWriter(gameFile, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
