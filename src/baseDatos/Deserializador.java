package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import gestorAplicacion.clasesPrincipales.*;

public class Deserializador {
    public static <E> void deserializador(List<E> list, String className) {
    	
        try {
            String path = System.getProperty("user.dir") + "/baseDatos/temp/" + className + ".txt"; // Ruta del archivo que se va a cargar
            File archivo = new File(path);  // Ruta donde crear este archivo, si aun no existe
            archivo.createNewFile(); // Crear un nuevo archivo, si no existe
            FileInputStream fileIn = new FileInputStream(path); // de donde cargar el archivo

            // Si el archivo esta vacio se lanza un throw EOFException y se muestra como un
            // mensaje de vacio, pero si no se usa el objeto in para leer el archivo
            ObjectInputStream in = new ObjectInputStream(fileIn);

            // Lee el listado de elementos
            //@SuppressWarnings("unchecked")
			ArrayList<E> listado = (ArrayList<E>) in.readObject();

            // Recorro el ArrayList
            for (E el : listado) {
                list.add(el);
            }

            in.close();
            fileIn.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
        } catch (IOException e) {
            System.out.println("Error flujo de inicialización");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
    }

    //Las clases que se deben deserializar
    public static void deserializarTodo() {
        Deserializador.deserializador(Bus.getBuses(), "buses");
        Deserializador.deserializador(Conductor.getConductores(), "conductores");
        Deserializador.deserializador(Empresa.getEmpresas(), "empresas");
        Deserializador.deserializador(Pasajero.getPasajeros(), "pasajeros");
        Deserializador.deserializador(Ruta.getRutas(), "rutas");
        Deserializador.deserializador(Tiquete.getTiquetes(), "tiquetes");
        Deserializador.deserializador(Viaje.getViajes(), "viajes");

    }
}
