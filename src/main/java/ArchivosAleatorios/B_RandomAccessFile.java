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

public class B_RandomAccessFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile fichero = null;
        int pos, numero;
        long size, cant;
        try {
            fichero = new RandomAccessFile("src/main/resources/enteros.dat", "rw");

            //calcular cuántos enteros tiene el fichero
            size = fichero.length();
            cant = size / 4;
            System.out.println("El fichero tiene " + cant + " enteros");

            //Modificar el entero que se encuentra en una posición determinada
            do {
                System.out.println("Introduce una posición (>=1 y <= " + cant + "): ");
                pos = sc.nextInt();
            } while (pos < 1 || pos > cant);

            pos--;  //la posición 1 realmente es la 0

            //nos situamos en la posición (byte de inicio) del entero a modificar
            //en Java un entero ocupa 4 bytes
            fichero.seek(pos * 4);

            //leemos y mostramos el valor actual
            System.out.println("Valor actual: " + fichero.readInt());

            //pedimos que se introduzca el nuevo valor
            System.out.println("Introduce nuevo valor: ");
            numero = sc.nextInt();

            //nos situamos de nuevo en la posición del entero a modificar
            //esto es necesario porque después de la lectura que hemos realizado para mostrar
            //el valor el puntero de lectura/escritura ha avanzado al siguiente entero del fichero.
            //si no hacemos esto escribiremos sobre el siguiente entero
            fichero.seek(pos * 4);

            //escribimos el entero
            fichero.writeInt(numero);

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
