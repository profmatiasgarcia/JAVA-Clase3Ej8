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

public class CFicheroTexto {

    public static void main(String[] args) {
        // Validamos si existe el fichero
        String sFichero = "fichero.txt";
        File fichero = new File(sFichero);

        if (fichero.exists()) {
            System.out.println("El fichero " + sFichero + " ya existe");
        } else {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));

                // Escribimos 10 filas
                for (int x = 0; x < 10; x++) {
                    bw.write("Fila numero " + x + "\n");
                }

                // Hay que cerrar el fichero
                bw.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        System.out.println("Se ha creado el fichero\n");
    
        //----LECTURA----
    try {

            FileReader fr = new FileReader("fichero.txt");
            BufferedReader bf = new BufferedReader(fr);
            String sCadena;
            System.out.println("\nLectura de Fichero\n");
            while ((sCadena = bf.readLine()) != null) {
                System.out.println(sCadena);
            }

            bf.close();

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    
    }

}
