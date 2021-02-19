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
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MFileChooser {

    public static void main(String[] args) {

        JFileChooser v = new JFileChooser();

        v.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int result = v.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) {
            System.exit(1);
        }

        File nom = v.getSelectedFile();

        if (nom == null || nom.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "nombre de archivo inválido", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                    (nom.isDirectory() ? "el Directorio " : "el archivo") + " seleccionado es: " + nom.getName());
        }
    }
}
