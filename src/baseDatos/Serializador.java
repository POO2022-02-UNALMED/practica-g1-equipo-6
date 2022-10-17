package baseDatos;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.List;

import gestorAplicacion.clasesPrincipales.*;

//Serializar todos los objetos creados durante la ejecucion del proyecto
 
public class Serializador {
    /*
     * lista <E>    Una lista de objetos. El generico se usa para poder agredar las clases que se crearon
     * className    El nombre de la clase que queremos usar como nombre del archivo
     */
    public static <E> void serializar(List<E> lista, String className) {

        try {
            String path = System.getProperty("user.dir") + "/baseDatos/temp/" + className + ".txt"; //Se borra /src ya que estaba quedando duplicado en la ruta
            FileOutputStream fileOut = new FileOutputStream(path); //donde serializar los archivos
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut); //escribir en el archivo
            objOut.writeObject(lista);  // Guardamos la lista de objetos
            objOut.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        }
        
    }
    
    //Las clases que se deben serializar
    public static void serializarTodo() {
        Serializador.serializar(Bus.getBuses(), "buses");
        Serializador.serializar(Conductor.getConductores(), "conductores");
        Serializador.serializar(Empresa.getEmpresas(), "empresas");
        Serializador.serializar(Pasajero.getPasajeros(), "pasajeros");
        Serializador.serializar(Ruta.getRutas(), "rutas");
        Serializador.serializar(Tiquete.getTiquetes(), "tiquetes");
        Serializador.serializar(Viaje.getViajes(), "viajes");
    }
}