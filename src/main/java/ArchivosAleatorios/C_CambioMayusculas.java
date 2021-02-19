package ArchivosAleatorios;
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class C_CambioMayusculas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile fichero = null;
        String palabra, cadena;
        StringBuilder auxBuilder;
        long pos = 0;
        int indice;
        try {
            //se abre el fichero para lectura/escritura
            fichero = new RandomAccessFile("src/main/resources/textos.txt", "rw");

            //Se pide la palabra a buscar
            System.out.println("Introduce palabra: ");
            palabra = sc.nextLine();

            //lectura del fichero
            cadena = fichero.readLine(); //leemos la primera línea
            while (cadena != null) {         //mientras no lleguemos al final del fichero
                indice = cadena.indexOf(palabra); //buscamos la palabra en la línea leída
                while (indice != -1) { //mientras la línea contenga esa palabra (por si está repetida)

                    //paso la línea a un StringBuilder para modificarlo
                    auxBuilder = new StringBuilder(cadena);
                    auxBuilder.replace(indice, indice + palabra.length(), palabra.toUpperCase());
                    cadena = auxBuilder.toString();

                    //nos posicionamos al principio de la línea actual y se sobrescribe la
                    //línea completa
                    //La posición donde empieza la línea actual la estoy guardando
                    //en la variable pos
                    fichero.seek(pos);
                    fichero.writeBytes(cadena);

                    //compruebo si se repite la misma palabra en la línea
                    indice = cadena.indexOf(palabra);
                }
                pos = fichero.getFilePointer(); //posición de la línea actual que voy a leer
                cadena = fichero.readLine();    //lectura de la línea
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
