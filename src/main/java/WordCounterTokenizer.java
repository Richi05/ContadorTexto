import java.io.*;
import java.util.StringTokenizer;


public class WordCounterTokenizer {
    public static void main(String args[]) {

        if (args.length == 0) {
            System.out.println("Falta el nombre del archivo");
            System.exit(1);
        }

        String fileName = args[0];

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("El nombre del archivo no se encuentra");
            System.exit(2);
        }

        BufferedReader in = new BufferedReader(fileReader);

        StringTokenizer st = new StringTokenizer(fileName);

        String textLine = null;
        String palabras = null;
        int contador = 0;
        int counter = 0;

        // tiempo al inicio
        long start = System.currentTimeMillis();

        try {
            while ((textLine = in.readLine()) != null) {
                StringTokenizer words = new StringTokenizer(textLine);
                while(words.hasMoreTokens()) {
                    counter++;
                    words.nextToken();
                }
                contador++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de entrada");
            System.exit(3);
        }



        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // tiempo de procesamiento
        long time = System.currentTimeMillis() - start;

        System.out.println("El archivo " + fileName + " tiene " + contador + " lineas"+ " y tiene "+counter+" palabras.");
        System.out.printf("Tiempo procesamiento (milisegundos): %d %n" , time);
    }
}
