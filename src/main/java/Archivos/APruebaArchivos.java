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
import java.util.Random;

public class APruebaArchivos {

    public static void main(String args[]) {
        File f = new File("/home/profmatias/Documentos/prueba.out");
        Random r = new Random();
        boolean finArchivo = false;// Para bucle infinito
        double d = 1.00;

        //Escritura
        try {
            FileOutputStream fos = new FileOutputStream(f);
            DataOutputStream dos = new DataOutputStream(fos);
            for (int i = 0; i < 256; i++) { // Se repite 256 veces
                dos.writeDouble(r.nextDouble() * 10);// Aleatorios entre 0 y 10
            }
            dos.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
            System.out.println("Error al escribir");
        }
        System.out.println("<< Se escribio en el archivo >> \n");

        //Lectura del archivo
        try {
            FileInputStream fis = new FileInputStream(f);
            DataInputStream dis = new DataInputStream(fis);
            while (!finArchivo) {
                d = dis.readDouble();
                System.out.println(d);
            }
            dis.close();
        } catch (EOFException e) {
            finArchivo = true; //la excepcion corta el bucle
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        } catch (IOException e) {
            System.out.println("Error al leer");
        }
    }
}
