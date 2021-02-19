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

public class ICrearDirectorio {

    public static void main(String[] args) {
        //Guardo el directorio del usuario
        String homeUsuario = System.getProperty("user.home");
        // Creamos el nombre de un directorio mediante un objeto File
        // El directorio raiz debe de existir -- mkdir --

        File directorio = new File(homeUsuario + "/directorio");
        // File directorio = new File("c:\\temp\\directorio"); //en Winchor sin seguridad de usuario

        if (directorio.mkdir()) {
            System.out.println("Se ha creado directorio");
        } else {
            System.out.println("No se ha podido crear el directorio");
        }

        // El directorio raiz no tiene porque existir -- mkdirs --
        File directorio2 = new File(homeUsuario + "/directorio/prof/matias/garcia");
        if (directorio2.mkdirs()) {
            System.out.println("Se ha creado directorio");
        } else {
            System.out.println("No se ha podido crear el directorio");
        }

    }

}
