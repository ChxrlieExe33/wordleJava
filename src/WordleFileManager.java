import java.io.BufferedReader;
import java.io.*;
import java.util.*;


/**
 * Clase encargado de leer y escribir al fichero de palabras y de juegos hechos
 * @author Charles Crane
 * @version 1.0
 */
public class WordleFileManager {

    /**
     * Lee un fichero de palabras, los convierte a mayusculas y las almacena en un array
     * @return Un array de palabras
     */
    public static String[] readFileWords(){

        // Utilizando un arraylist porque no sabemos cuantas palabras hay en el fichero
        List<String> wordsList = new ArrayList<String>();

        try
        {
            File file = new File("C:\\Users\\charl\\wordle\\src\\palabras.txt");
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

        // Hacer todas palabras mayusculas
        for(int i = 0; i < palabras.length; i++){
            palabras[i] = palabras[i].toUpperCase();
        }

        return palabras;


    }

}
