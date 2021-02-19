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

public class EPruebaArchivoRandom {

    public static void main(String[] args) {
        BufferedReader teclado;
        InputStreamReader inStream;
        PrintWriter pantalla;
        String nombreFichero, posición, b;
        RandomAccessFile fichero;
        inStream = new InputStreamReader(System.in);
        teclado = new BufferedReader(inStream);
        File f;
        long punteroF;
        try {
            // PrintWriter con autoflush a true
            pantalla = new PrintWriter(System.out, true);
            pantalla.println("Nombre de fichero:");
            nombreFichero = teclado.readLine();
            f = new File(nombreFichero);
            // apertura del fichero en modo lectura/escrit.
            fichero = new RandomAccessFile(f, "rw");
            pantalla.println("Para terminar CTRL+d en Linux o CTRL+z en MS Windows");
            pantalla.println("byte a examinar:");
            while ((posición = teclado.readLine()) != null) {
                try {
                    // buscar la posición en el fichero.
                    // Integer.parseInt() obtiene int a partir
                    // de un String
                    fichero.seek(Integer.parseInt(posición));
                    // obtener el puntero del fichero
                    punteroF = fichero.getFilePointer();
                    // leer y mostrar el byte en la posición
                    pantalla.println("Valor del byte = " + fichero.readByte());
                    pantalla.println("Nuevo valor del byte:");
                    b = teclado.readLine();
                    // posicionar el puntero del fichero en
                    // el lugar guardado anteriormente
                    fichero.seek(punteroF);
                    // escribir el nuevo valor del byte
                    fichero.writeByte(Integer.parseInt(b));
                } catch (IOException e) {
                    System.err.println("No existe ese byte.");
                } catch (NumberFormatException e) {
                    System.err.println("error num.");
                }
                pantalla.println("byte a examinar:");
            }
            teclado.close();
            pantalla.close();
            fichero.close();
        } catch (IOException e) {
            System.err.println("Error de E/S");
        }

    }

}
