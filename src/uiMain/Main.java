/*
 * Clase main de la cual se ejecuta el programa con su respectiva interfaz
 * Estructuras: Scanner, ArrayList, LocalDate, swich
 * 
 * @author: Andres Lema, Daniel Estrada, Nicolas Perez, Valen Ardila, Camilo Bello
 *
 */

package uiMain;

import gestorAplicacion.clasesPrincipales.*;
import gestorAplicacion.clasesHerencia.*;

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
       // Deserializador.deserializarTodo();
        
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
         
        Ruta uno = new Ruta("MONTERIA", "PASTO", 120);
        Ruta dos = new Ruta("MEDELLIN", "MANIZALES",100);
        Ruta tres = new Ruta("POPAYAN", "CALI",80);
        Ruta cuatro = new Ruta("MEDELLIN", "CARTAGENA",150);
        Ruta cinco = new Ruta("PASTO", "MONTERIA",120);
        Ruta seis = new Ruta("MANIZALES", "MEDELLIN",100);
        Ruta siete = new Ruta("CALI","POPAYAN",80);
        Ruta ocho = new Ruta("CALI", "CARTAGENA",170);
        Ruta nueve = new Ruta("CARTAGENA", "MEDELLIN",150);
        Ruta diez = new Ruta("CARTAGENA","CALI",170);
        
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
        Bus B1 = new Ejecutivo("AAA000",cond1,sillasv3); 
        Bus B2 = new EuroVans("ZZZ999",cond2,sillasv2);
        Bus B3 = new TecnoVans("ABC123",cond3, sillasv1);

        //VIAJES
        Viaje viaje2 = new Viaje(1,"8:00","12:00",intermedio,uno, B1, true,7,40000);
        Viaje viaje3 = new Viaje(2,"8:00","11:00",fin,dos, B2, true,7, 40000);
        Viaje viaje1 = new Viaje(3,"8:00","13:00",intermedio, tres, B3, true,7,35000);
        Viaje viaje4 = new Viaje(4,"8:00","20:00", fin,cuatro, B1, true, 7, 37000);
        Viaje viaje5 = new Viaje(5,"8:00","14:00",intermedio, cinco, B2, true, 7, 40000);
        Viaje viaje6 = new Viaje(6,"8:00","15:00",intermedio, seis, B3, true,7, 30000);
        Viaje viaje7 = new Viaje(7,"8:00","16:00", intermedio, siete, B1, true,7,30000);
        Viaje viaje9 = new Viaje(8,"8:00","16:00", intermedio, ocho, B2, true,7, 35000);
        Viaje viaje10 = new Viaje(9,"8:00","16:00", intermedio, nueve, B3, false,7,37000);
        Viaje viaje8 = new Viaje(10,"8:00","17:00",intermedio,uno, B2, true,7, 40000);

        
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
                Admin.showMenuRentabilidad();
                System.out.println("");
            	System.out.println("¿Desea realiza una operación mas(Si-No)?");
            	String opcion1 = in.next().toUpperCase();
            	while(opcion1.equals("SI")) {
            		Admin.showMenuRentabilidad();
            		System.out.println("¿Desea realiza una operación mas (Si-No)?");
	            	opcion1 = in.next().toUpperCase();
            	}
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
            	comprarTiquete.showMenuTiquete();
            	System.out.println("");
            	System.out.println("¿Desea realiza una operación mas(Si-No)?");
            	String opc = in.next().toUpperCase();
            	while(opc.equals("SI")) {
            		comprarTiquete.showMenuTiquete();
            		System.out.println("¿Desea realiza una operación mas (Si-No)?");
	            	opc = in.next().toUpperCase();
            	}
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
        
        
        