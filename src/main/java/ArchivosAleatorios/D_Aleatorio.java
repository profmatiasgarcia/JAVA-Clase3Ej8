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
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class D_Aleatorio {

    public static String archivo = "src/main/resources/fichero.obj";

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        do {

            System.out.println("1) Agregar numeros de tipo double al principio del fichero");
            System.out.println("2) Agregar numero de tipo double al final del fichero.");
            System.out.println("3) Mostrar el fichero creado.");
            System.out.println("4) Sustituir un numero indicado por el usuario por otro numero.");
            System.out.println("5) Salir del programa");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1 ->
                    agregarPrincipio();
                case 2 ->
                    agregarFinal();
                case 3 ->
                    leerFichero();
                case 4 ->
                    sustituirDoubles();
                case 5 ->
                    System.out.println("Gracias por usar el programa....");
                default ->
                    System.out.println("Opcion no es correcta");
            }
        } while (opcion != 5);

    }

    public static void agregarPrincipio() {
        RandomAccessFile raf = null;
        try {
            File fichero = new File(archivo);
            raf = new RandomAccessFile(fichero, "rw");
            agregarNumerosAlPrincipio(raf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static void agregarNumerosAlPrincipio(RandomAccessFile raf) throws Exception {
        Scanner teclado = new Scanner(System.in);
        double numero;
        int tam = (int) raf.length() / 8; //8 valor que ocupa cada double en archivo
        double temp[] = new double[tam];
        int in = 0;
        System.out.println("Introduce un numero Double para agregar al principio del fichero: ");
        numero = teclado.nextDouble();
        raf.seek(0);
        for (in = 0; in < tam; in++) {
            temp[in] = raf.readDouble();
        }
        raf.seek(0);
        raf.writeDouble(numero);
        for (int i = 0; i < temp.length; i++) {
            raf.writeDouble(temp[i]);
        }

    }

    public static void agregarFinal() {
        RandomAccessFile raf = null;
        try {
            File fichero = new File(archivo);
            raf = new RandomAccessFile(fichero, "rw");
            agregarNumerosAlFinal(raf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void agregarNumerosAlFinal(RandomAccessFile raf) throws Exception {
        Scanner teclado = new Scanner(System.in);
        double numero;
        System.out.println("Introduce un numero Double para agregar al final del fichero: ");
        numero = teclado.nextDouble();
        raf.seek(raf.length());
        raf.writeDouble(numero);

    }

    public static void leerFichero() {
        RandomAccessFile raf = null;
        try {
            File fichero = new File(archivo);
            raf = new RandomAccessFile(fichero, "r");
            mostrarFichero(raf);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void mostrarFichero(RandomAccessFile raf) throws Exception {
        double numero;
        raf.seek(0);
        while (true) {
            numero = raf.readDouble();
            System.out.println(numero);
        }
    }

    public static void sustituirDoubles() {
        Scanner teclado = new Scanner(System.in);
        double sustituir, nuevo, numero;
        int i = 0;

        RandomAccessFile raf = null;

        try {
            File fichero = new File(archivo);
            raf = new RandomAccessFile(fichero, "rw");
            raf.seek(0);

            System.out.println("Introduce el valor que desea sustituir");
            sustituir = teclado.nextDouble();

            System.out.println("Introduce el nuevo valor");
            nuevo = teclado.nextDouble();

            while (true) {
                numero = raf.readDouble();
                if (numero == sustituir) {
                    System.out.println("Encontrado en la posicion " + i);
                    raf.seek(i * 8);
                    raf.writeDouble(nuevo);
                }
                i++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception e2) {
                System.out.println(e2.getMessage());
            }
        }

    }
}
