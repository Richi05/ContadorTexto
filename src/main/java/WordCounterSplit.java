import java.io.*;
public class WordCounterSplit {
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

        String textLine = null;
        int contador = 0;
        int counter1 = 0;

        // tiempo al inicio
        long start = System.currentTimeMillis();
        try {
            while ((textLine = in.readLine()) != null) {
                String[] wordList = textLine.split("\\s+");
                counter1 += wordList.length;

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

        System.out.println("El archivo " + fileName + " tiene " + contador + " lineas y " + counter1 + " palabras.");
        System.out.printf("Tiempo procesamiento (milisegundos): %d %n" , time);
    }
}
