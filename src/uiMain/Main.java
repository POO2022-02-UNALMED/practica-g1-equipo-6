/*
 * Clase main de la cual se ejecuta el programa con su respectiva interfaz
 * Estructuras: Scanner, ArrayList, LocalDate, swich
 * 
 * @author: Andres Lema
 */

package uiMain;

import gestorAplicacion.*;

import baseDatos.*;
import uiMain.funcionalidades.*;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static boolean running = true;
    private static int election = -1;

    public static void main(String[] args) {
        Deserializador.deserializarTodo();
        
        Pasajero u1 = new Pasajero("Andres","Lema",1039458020,30, "example@email.com");
        Pasajero u2 = new Pasajero("Daniel","Estrada",1020486909,24, "example2@email.com");
        Pasajero u3 = new Pasajero("Nicolas","Perez",1036214594,21, "example3@email.com");
        Pasajero u4 = new Pasajero("Valen","Ardila",102819668,19, "example4@email.com");
        Pasajero u5 = new Pasajero("Camilo","Bello",1004354028,20, "example5@email.com");

        ////FECHAS PRUEBAS

        LocalDate fin = LocalDate.now().plusDays(15);
        LocalDate inicio = LocalDate.now().plusDays(2);
        LocalDate intermedio = LocalDate.now().plusDays(12);

        ////RUTAS
         
        Ruta Medellin = new Ruta(1, "MEDELLIN");
        Ruta Bello = new Ruta(12, "BELLO");
        Ruta Popayan = new Ruta(7, "POPAYAN");
        Ruta Cali = new Ruta(8, "CALI");
        Ruta Monteria = new Ruta(5, "MONTERIA");
        Ruta Cartagena = new Ruta(4, "CARTAGENA");
        Ruta Pasto = new Ruta(6, "PASTO");
        Ruta Barranquilla = new Ruta(9, "BARRANQUILLA");
        Ruta Manizales = new Ruta(3, "MANIZALES");
        

        //////BUS
        Bus B1 = new Bus("AAA000", sillasv1, 150);
        Bus B2 = new Bus("ZZZ999", sillasv2, 100);
        Bus B3 = new Bus("ABC123", sillasv3, 80);

        //VIAJES
        Viaje viaje1 = new Viaje();
        Viaje viaje2 = new Viaje();
        Viaje viaje3 = new Viaje();
        Viaje viaje4 = new Viaje();
        
        ////CONDUCTORES
        Conductor con1 = new Conductor("Don Javie",1021123854 ,3004569696l, 4000);
        Conductor con2 = new Conductor("Don Hernan",1021123855,3007569696l, 4100);
        Conductor con3 = new Conductor("Dona Marta",1021123856,3004589696l, 4200);
        
        
        