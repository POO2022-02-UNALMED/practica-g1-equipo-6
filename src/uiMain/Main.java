/*
 * Clase main de la cual se ejecuta el programa con su respectiva interfaz
 * Estructuras: Scanner, ArrayList, LocalDate, swich
 * 
 * @author: Andres Lema, Daniel Estrada, Nicolas Perez, Valen Ardila, Camilo Bello
 *
 */

package uiMain;

import gestorAplicacion.clasesPrincipales.*;

import baseDatos.*;
import uiMain.funcionalidades.*;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static boolean running = true;
    private static int election = -1;
    static Scanner in = new Scanner(System.in);

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
         
        Ruta Amazonas = new Ruta(1,"RUTA1","MEDELLIN", "AMAZONAS",1792);
        Ruta Bello = new Ruta(12,"RUTA2","MEDELLIN", "BELLO",12);
        Ruta Popayan = new Ruta(7,"RUTA3","MEDELLIN", "POPAYAN",437);
        Ruta Cali = new Ruta(8,"RUTA4","MEDELLIN", "CALI",331);
        Ruta Monteria = new Ruta(5,"RUTA5","MEDELLIN", "MONTERIA",404);
        Ruta Cartagena = new Ruta(4,"RUTA6","MEDELLIN", "CARTAGENA",461);
        Ruta Pasto = new Ruta(6,"RUTA7","MEDELLIN", "PASTO",814);
        Ruta Barranquilla = new Ruta(9,"RUTA8","MEDELLIN", "BARRANQUILLA",701);
        Ruta Manizales = new Ruta(3,"RUTA9","MEDELLIN", "MANIZALES",192);
        
      ///SILLAS
        ArrayList<String> sillasv1 = new ArrayList<String>();
        sillasv1.add("A1");
        sillasv1.add("A2");
        sillasv1.add("A3");
        sillasv1.add("A4");
        ArrayList<String> sillasv2 = new ArrayList<String>();
        sillasv2.add("B1");
        sillasv2.add("B2");
        sillasv2.add("B3");
        sillasv2.add("B4");
        sillasv2.add("B5");
        sillasv2.add("B6");
        sillasv2.add("B7");
        sillasv2.add("B8");
        ArrayList<String> sillasv3 = new ArrayList<String>();
        sillasv3.add("C1");
        sillasv3.add("C2");
        sillasv3.add("C3");
        sillasv3.add("C4");
        sillasv3.add("C5");
        sillasv3.add("C6");
        sillasv3.add("C7");
        sillasv3.add("C8");
        
        ////CONDUCTORES
        Conductor cond1 = new Conductor("Don Javier",1021123854 ,3004569696l, 4000);
        Conductor cond2 = new Conductor("Don Hernan",1021123855,3007569696l, 4100);
        Conductor cond3 = new Conductor("Dona Marta",1021123856,3004589696l, 4200);
        
        //////BUS
        Ejecutivo B1 = new Ejecutivo("1998","AAA000",cond1,60, sillasv3); 
        EuroVans B2 = new EuroVans("2000","ZZZ999",cond2,90, sillasv2);
        TecnoVans B3 = new TecnoVans("1999","ABC123",cond3,120, sillasv1);

        //VIAJES
        Viaje viaje2 = new Viaje(1,"8:00","12:00",intermedio, Medellin, B3, true,7,40000);
        Viaje viaje3 = new Viaje(2,"8:00","11:00",fin,Bello, B3, true,7, 40000);
        Viaje viaje1 = new Viaje(3,"8:00","13:00",intermedio, Popayan, B3, true,7,35000);
        Viaje viaje4 = new Viaje(4,"8:00","20:00", fin,Cali, B3, true, 7, 37000);
        Viaje viaje5 = new Viaje(5,"8:00","14:00",intermedio, Monteria, B3, true, 7, 40000);
        Viaje viaje6 = new Viaje(6,"8:00","15:00",intermedio, Cartagena, B3, true,7, 30000);
        Viaje viaje7 = new Viaje(7,"8:00","16:00", intermedio, Pasto, B3, true,7,30000);
        Viaje viaje9 = new Viaje(8,"8:00","16:00", intermedio, Barranquilla, B3, true,7, 35000);
        Viaje viaje10 = new Viaje(9,"8:00","16:00", intermedio, Manizales, B3, false,7,37000);
        Viaje viaje8 = new Viaje(10,"8:00","17:00",intermedio,Popayan, B3, true,7, 35000);

        
        while(running) {
            showMenu();
            while(election < 0 || election > 6) {
                try {
                    election = in.nextInt();
                    if (election < 0 || election > 7) {
                        System.out.println("Opcion invalida..., probemos otra vez");
                        System.out.println("Recuerda, elije una de las opciones [1] [2] [3] [4] [5] [6]");
                    }
                } catch (Exception InputMismatchException) {
                    // TODO: handle exception
                    System.out.println("No te entiendo..., probemos otra vez");
                    System.out.println("Recuerda, elije una de las opciones [1] [2] [3] [4] [5] [6]");
                }
            }
            System.out.println("");
            executeFunctionality(election, in);
            election = -1;
        }
    }
    public static void showMenu() {
        System.out.println(" ");
        System.out.println("----- M E N U -----");

        System.out.println("[1] Rentabilidad");
        System.out.println("[2] Optimiazcion ruta");
        System.out.println("[3] Gestionar Tiquete");
        System.out.println("[4] Gestionar Viaje - (cc) ");
        System.out.println("[5] Compra de Tiquete");
        System.out.println("[6] Salir\n");

    }

    public static void executeFunctionality(int election, Scanner in) {
        switch (election) {
            case 1:
                //AdminViaje.visualizarEstadisticas();
                break;
            case 2:
                System.out.println("GESTIONAR CONDUCTORES");
                //Gestionar.gestionarConductores();
                break;
            case 3:
                //Gestionar.gestionarEspecialistas();
                break;
            case 4:
                System.out.println("Gestionar Viaje - CC: ");
                Scanner ccGV = new Scanner(System.in);
                int ccCG = ccGV.nextInt();
                //Gestionar.gestionarViajes(ccCG);
                break;
            case 5:
            	comprarTiquete.comprarTiqueteTerminal();
                break;
            	
            case 6:
            	System.out.println("Vuelva pronto");
            	Serializador.serializarTodo();
            	System.exit(0);
                running = false;
                break;
        }
    }
}
        
        
        