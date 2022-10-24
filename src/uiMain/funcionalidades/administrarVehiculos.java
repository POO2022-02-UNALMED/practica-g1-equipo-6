package uiMain.funcionalidades;

import gestorAplicacion.clasesPrincipales.*;
import gestorAplicacion.clasesHerencia.*;

import gestorAplicacion.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class administrarVehiculos {
    	static Scanner sc = new Scanner(System.in);
  
    	public static void adminVehiculo(){
    		Bus Buses = new Bus();
    		System.out.println("Que desea realizar: ");
	        	System.out.println("0. Agregar Bus ");
		        System.out.println("1. Eliminar Bus");
		        System.out.println("2. Cambiar conductor del bus");
		        System.out.println("3. Mostrar todos los buses de la flota y su ocupacion");
		        int opcionelegida= sc.nextInt();
          
            while (opcionelegida!=0 & opcionelegida!=1 & opcionelegida!=2 & opcionelegida !=3) {
			        System.out.println("Porfavor ingresa una opcion valida");
			        opcionelegida = sc.nextInt();
		        }
	        	System.out.println("Los tipos de buses con los que contamos son: ");
	        	System.out.println("0.  Ejecutivo de maximo 26 pasajeros");
		        System.out.println("1.  TecnoVans de maximo 22 pasajeros");
		        System.out.println("2.  EuroVans de maximo 14 pasajeros");
		     
		        if(opcionelegida==0) {
		        	Scanner tb = new Scanner(System.in);
		        	String placa;
		        	Conductor cond;
		        	System.out.println("Que tipo de bus vas a crear: ");
		        	int tipobus= sc.nextInt();
		        	while (opcionelegida!=0 & opcionelegida!=1 & opcionelegida!=2) {
		        		System.out.println("Porfavor ingresa una opcion valida");
		        		tipobus = tb.nextInt();
		        	}
		        	
		        	Scanner pla = new Scanner(System.in);
		        	System.out.println("Ingresa el numero de la placa");
		        	placa = pla.toString();
		        	
					for(Conductor c: Conductor.getConductores()) { //Recorre todos los viajes 
						if(c.isDisponible() == false) {
							cond=c;
							break;
						}
					}
					if(cond =! c){
						cond=null;
						System.out.println("No hay conductors disponibles");
						
						Conductor(nombre,cedula,celular,sueldo)						
					}
					
					
					
					if(tipobus==0) {
						
						Bus B1 = new Ejecutivo();
						B1.setConductor(cond);
						B1.setPlaca(placa);
					}
		        	
					if(tipobus==1) {
						
						Bus B2 = new TecnoVans();
						B2.setConductor(cond);
						B2.setPlaca(placa);
					}
					
					if(tipobus==2) {
						
						Bus B3 = new EuroVans();
						B3.setConductor(cond);
						B3.setPlaca(placa);
					}
		        	
		        }
		        
		        else if(opcionelegida==1) {
		        	System.out.println("Que tipo de bus vas a eliminar: ")
		        }
		        
		        else if(opcionelegida==2) {
		        	
		        }
		        else if(opcionelegida==3) {
		        	
		        }
    	}

    
  
  
  
}
