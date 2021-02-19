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
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class A_RandomAccess {

    static Scanner sc = new Scanner(System.in);
    static RandomAccessFile fichero = null;

    public static void main(String[] args) {
        int numero;
        try {
            //se abre el fichero para lectura y escritura
            fichero = new RandomAccessFile("src/main/resources/enteros.dat", "rw");
            mostrarFichero(); //muestra el contenido original del fichero
            System.out.println("Introduce un número entero para añadir al final del fichero: ");
            numero = sc.nextInt(); //se lee el entero a añadir en el fichero
            fichero.seek(fichero.length()); //nos situamos al final del fichero
            fichero.writeInt(numero);       //se escribe el entero
            mostrarFichero();//muestra el contenido del fichero después de añadir el número

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

    public static void mostrarFichero() {
        int n;
        try {
            fichero.seek(0); //nos situamos al principio
            while (true) {
                n = fichero.readInt();  //se lee  un entero del fichero
                System.out.println(n);  //se muestra en pantalla
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
