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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ResourcesArchivos {

    public static void main(String[] args) {
        URL archivo = ClassLoader.getSystemClassLoader().getResource("profmatias.txt");
        if (archivo == null){
            System.out.println("Archivo no encontrado ");
            System.exit(0);
        }
        
        File f = new File(archivo.getPath());
        
        FileWriter fw = null;
        BufferedWriter bw = null;
        FileReader fr = null;
        BufferedReader br = null;

        // Escribir en el archivo
        try {
            fw = new FileWriter(f);
            bw = new BufferedWriter(fw);
            String s = "Prof Matias Garcia";
            for (int i = 0; i < 10; i++) {
                bw.write(s);
                bw.write("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo");
        } catch (IOException e) {
            System.out.println("Error al escribir");
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // Lee el archivo
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String s;
            do {
                s = br.readLine();
                System.out.println(s);
            } while (s != null);
        } catch (FileNotFoundException e) {
            System.out.println("Error al abrir el archivo");
        } catch (IOException e) {
            System.out.println("Error al leer");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }

                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
