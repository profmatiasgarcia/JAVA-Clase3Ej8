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
import java.util.*;

public class FContarVocalesFichero {

    private String Filename = "";
    private File file = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private List<String> lineas = new ArrayList<String>();

    public static void main(String[] args) {
        FContarVocalesFichero contador = new FContarVocalesFichero();
        int cantidad = contador.contarVocales("src/main/resources/texto.txt");
        System.out.println("El fichero tiene " + cantidad + " vocales");
    }

    public void setFilename(String f) {
        Filename = f;
    }

    public void openFile() {
        try {
            file = new File(Filename);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch (Exception ex) {
        }
    }

    public void closeFile() {
        try {
            if (fr != null) {
                fr.close();
            }
            br = null;
            file = null;
            System.gc();// llamada a forzar garbage collector
        } catch (Exception ex) {
        }
    }

    public void readFile() {
        String linea = "";
        try {
            if (br == null) {
                openFile();
            }
            if (br != null) {
                while ((linea = br.readLine()) != null) {
                    lineas.add(linea);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeFile();
        }
    }

    /**
     * Conteo de vocales de un archivo
     *
     */
    public int contarVocales(String filename) {
        int cant_voc = 0;
        try {
            setFilename(filename);
            openFile();
            readFile();
        } catch (Exception ex) {
        }
        for (String charline : lineas) {
            cant_voc += contarVocalesPorLinea(charline);
        }
        return cant_voc;
    }

    /**
     * Conteo de vocales por linea de texto
     *
     */
    public int contarVocalesPorLinea(String line) {
        int cant_vocales = 0;
        char[] vocales = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        char[] charsLine = line.toCharArray();
        for (int i = 0; i < charsLine.length; i++) {
            for (int j = 0; j < vocales.length; j++) {
                if (charsLine[i] == vocales[j]) {
                    cant_vocales++;
                }
            }
        }
        return cant_vocales;
    }

}
