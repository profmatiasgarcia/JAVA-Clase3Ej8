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
import java.util.Scanner;

public class BArchivoBinario {

    public static void main(String args[]) throws IOException {
        Scanner leer = new Scanner(System.in);
        DataOutputStream Archi = null;
        int i;
        int legajo = 0;
        String nombre = new String("");
        int calif1;
        int calif2;
        int calif3;
        double promedio;
        try {
            for (i = 0; i < 5; i++) {
                Archi = new DataOutputStream(new FileOutputStream("ARCH", true));
                System.out.println("Escribe legajo del estudiante:");
                legajo = leer.nextInt();
                System.out.println("Escribe Nombre:");
                nombre = leer.next();
                System.out.println("Ingrese Calificacion 1:");
                calif1 = leer.nextInt();
                System.out.println("Ingrese Califiacion 2:");
                calif2 = leer.nextInt();
                System.out.println("Ingrese Calificacion 3:");
                calif3 = leer.nextInt();
                Archi.writeInt(legajo);
                Archi.writeUTF(nombre);
                Archi.writeInt(calif1);
                Archi.writeInt(calif2);
                Archi.writeInt(calif3);
                Archi.close();
            }
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {
        }

        System.out.println("---------------LECTURA-------------");
        
        DataInputStream Archivo = null;
        try {
            Archivo = new DataInputStream(new FileInputStream("ARCH"));
            while (true) {
                legajo = Archivo.readInt();
                System.out.println("Legajo: " + legajo + " ");
                nombre = Archivo.readUTF();
                System.out.println("Nombre: " + nombre + "  ");
                calif1 = Archivo.readInt();
                System.out.println("Calificacion 1: " + calif1 + " ");
                calif2 = Archivo.readInt();
                System.out.println("Calificacion 2: " + calif2 + " ");
                calif3 = Archivo.readInt();
                System.out.println("Calificacion 3: " + calif3 + " ");
                System.out.println("\n");
                int suma = calif1 + calif2 + calif3;
                promedio = suma / 3;
                System.out.println("El promedio es: " + promedio + "\n");
            }
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {
        }
        Archi.close();
    }
}
