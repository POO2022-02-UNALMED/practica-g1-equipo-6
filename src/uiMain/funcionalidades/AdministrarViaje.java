package uiMain.funcionalidades;

import java.util.Scanner;

public class AdministrarViaje {
	static Scanner sc = new Scanner(System.in);
    public static void showMenuViaje() {
        System.out.println(" ");
        System.out.println("----- SISTEMA DE ADMINISTRACION DE VIAJES -----");
        
        System.out.println("¿Que operacion desea realizar?");
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
    	
    }
    
    public static void modificarViaje() {
    	
    }
    
    
}
