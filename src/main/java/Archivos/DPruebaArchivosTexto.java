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

public class DPruebaArchivosTexto {

    public static void main(String args[]) {
        File f = new File("src/main/resources/archivoTXT.txt");
        int x = 77;
        int y = 0;
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(x);
            fw.close();
        } catch (IOException e) {
            System.out.println("error");
            return;
        }
        // Lectura de los datos
        try {
            FileReader fr = new FileReader(f);
            y = fr.read();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo");
        } catch (IOException e) {
            System.out.println("Error al leer");
        }
        System.out.println(y);

    }
}
