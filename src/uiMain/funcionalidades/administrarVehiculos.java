package uiMain.funcionalidades;

import gestorAplicacion.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class administrarVehiculos {
    	static Scanner sc = new Scanner(System.in);
  
    	public static void adminVehiculo(){
        Tiquete finalTiquete = new Tiquete();
        System.out.println("Que desea realizar: ");
	        	System.out.println("0. Agregar Bus ");
		        System.out.println("1. Eliminar Bus");
		        System.out.println("2. Cambiar conductor del bus");
		        System.out.println("3. Mostrar todos los buses de la flota");
		        int opcionelegida= sc.nextInt();
          
            while (opcionelegida!=0 & opcionelegida!=1 & opcionelegida!=2 & opcionelegida !=3) {
			        System.out.println("Porfavor ingresa una opcion valida");
			        opcionCompra = sc.nextInt();
		        }
        		int i=0;
	        	System.out.println("Los tipos de buses con los que contamos son: ");
	          System.out.println("0.  Ejecutivo de maximo 26 pasajeros");
		        System.out.println("1.  TecnoVans de maximo 22 pasajeros");
		        System.out.println("2.  EuroVans de maximo 14 pasajeros");
        
  }

    
  
  
  
}
