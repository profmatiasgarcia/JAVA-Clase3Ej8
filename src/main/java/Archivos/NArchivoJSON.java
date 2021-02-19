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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NArchivoJSON {

    public static void main(String[] args) {
        //Primer empleado
        JSONObject detallesEmpleado = new JSONObject();
        detallesEmpleado.put("apellido", "Garcia");
        detallesEmpleado.put("nombre", "Matias");
        detallesEmpleado.put("mail", "info@profmatiasgarcia.com.ar");

        JSONObject empleadoObject = new JSONObject();
        empleadoObject.put("empleado", detallesEmpleado);

        //Second Employee
        JSONObject detallesEmpleado2 = new JSONObject();
        detallesEmpleado2.put("apellido", "Gonzalez");
        detallesEmpleado2.put("nombre", "Blanca");
        detallesEmpleado2.put("mail", "blancagon@gmail.com");

        JSONObject empleadoObject2 = new JSONObject();
        empleadoObject2.put("empleado", detallesEmpleado2);

        //Add employees to list
        JSONArray listadoEmpleados = new JSONArray();
        listadoEmpleados.add(empleadoObject);
        listadoEmpleados.add(empleadoObject2);

        //Write JSON file
        try ( FileWriter file = new FileWriter("src/main/resources/empleados.json")) {

            file.write(listadoEmpleados.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("El archivo empleados.json se escribo satisfactoriamente\n");

        //----LECTURA----
        //JSON parser object de la dependencia adjunta
        JSONParser jsonParser = new JSONParser();

        try ( FileReader reader = new FileReader("src/main/resources/empleados.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray empleadosListado = (JSONArray) obj;
            System.out.println(empleadosListado);

            //Iterate over employee array
            empleadosListado.forEach(emp -> parseEmpleadoObject((JSONObject) emp));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseEmpleadoObject(JSONObject empleado) {
        //Obtiene el objeto empleado
        JSONObject empleadoObjeto = (JSONObject) empleado.get("empleado");

        //Obtiene el apellido del empleado
        String apellido = (String) empleadoObjeto.get("apellido");
        System.out.println(apellido);

        //Obtiene el nombre del empleado
        String nombre = (String) empleadoObjeto.get("nombre");
        System.out.println(nombre);

        //Obtiene el mail del empleado
        String mail = (String) empleadoObjeto.get("mail");
        System.out.println(mail);
    }
}
