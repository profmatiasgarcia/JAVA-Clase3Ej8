package Archivos;
/**
 * @author Prof Matias Garcia.
 * <p> Copyright (C) 2017 para <a href = "https://www.profmatiasgarcia.com.ar/"> www.profmatiasgarcia.com.ar </a>
 * - con licencia GNU GPL3.
 * <p> Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de la
 * Licencia Pública General de GNU según es publicada por la Free Software Foundation, 
 * bien con la versión 3 de dicha Licencia o bien (según su elección) con cualquier versión posterior. 
 * Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, 
 * incluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN PROPÓSITO
 * PARTICULAR. Véase la Licencia Pública General de GNU para más detalles.
 * Debería haber recibido una copia de la Licencia Pública General junto con este programa. 
 * Si no ha sido así ingrese a <a href = "http://www.gnu.org/licenses/"> GNU org </a>
 */
import java.io.*;

public class DPruebaArchivosTexto3 {

    public static void main(String[] args) {
        String fileName = "src/main/resources/Texto.txt";
        PrintWriter fileOut = null;
        try {
            fileOut = new PrintWriter(new FileWriter(fileName));

            String s = "Una linea de texto";
            fileOut.println(s);
            fileOut.flush();

        } catch (FileNotFoundException fnfe) {
            System.out.println("Error, no se encuentra el archivo");
        } catch (IOException ioe) {
            System.out.println("Error, disco protegido contra lectura");
        } finally {
            fileOut.close();
        }
        
        //Lectura

        BufferedReader fileIn = null;
        try {
            fileIn = new BufferedReader(new FileReader(fileName));

            String s = fileIn.readLine();
            System.out.println("La primera linea es: " + s);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error, no se encuentra el archivo");
        } catch (IOException ioe) {
            System.out.println("Error, disco protegido contra lectura");
        } finally {
            if (fileIn != null) {
                try {
                    fileIn.close(); // Es importante cerrar el archivo
                } catch (IOException ioe) {
                    System.out.println("Error, el archivo sigue en uso");
                }
            }
        }
    }
}
