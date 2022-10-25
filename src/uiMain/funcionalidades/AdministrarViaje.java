package uiMain.funcionalidades;

import java.util.Scanner;
import gestorAplicacion.clasesPrincipales.*;

public class AdministrarViaje {
	static Scanner sc = new Scanner(System.in);
    public static void showMenuViaje() {
        System.out.println(" ");
        System.out.println("----- SISTEMA DE ADMINISTRACION DE VIAJES -----");
        
        System.out.println("¿Que operación desea realizar?");
        System.out.println("[1] Agregar un nuevo viaje");
        System.out.println("[2] Modificar un viaje");
        int opcion = sc.nextInt();
        switch (opcion) {
        case 1:
        	AdministrarViaje.agregarViaje();
            break;
        case 2:
        	AdministrarViaje.modificarViaje();   
        	break;
        }
        
    }
    
    public static void agregarViaje() {
    	//public Viaje(int id,String hora_inicio, String hora_llegada, LocalDate fecha, Ruta ruta,Bus bus, Boolean enViaje, int frecuencia, int costoViaje )
    	Empresa.crearViaje(0, null, null, null, null, null, null, 0, 0);
    }
    
    public static void modificarViaje() {
    	
    }
    
    
}
