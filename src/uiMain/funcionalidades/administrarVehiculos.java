package uiMain.funcionalidades;

import gestorAplicacion.clasesPrincipales.*;
import gestorAplicacion.clasesHerencia.*;
import java.util.Scanner;

public class administrarVehiculos {
	static Scanner sc = new Scanner(System.in);
	String placa;
	static Conductor cond;

  
    	public static void adminVehiculo(){
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
		        	System.out.println("Que tipo de bus vas a crear: ");
		        	int tipobus= sc.nextInt();
		        	while (opcionelegida!=0 & opcionelegida!=1 & opcionelegida!=2) {
		        		System.out.println("Porfavor ingresa una opcion valida");
		        		tipobus = sc.nextInt();
		        	}
		        	
		        	
		        	System.out.println("Ingresa el numero de la placa");
		        	String pla = sc.next();	        	
		        	
					for(Conductor c: Conductor.getConductores()) { //Recorre todos los viajes 
						if(c.isDisponible() == false) {
							cond =c;
							break;
						}
					}
					
					if(cond == null){
						cond=null;
						System.out.println("No hay conductors disponibles");
						System.out.println("Ingrese nuevo conductor");
						
			        	System.out.println("Nombre");
			        	String nomb = sc.next();	  
			        	
			        	System.out.println("Cedula");
			        	int ced = sc.nextInt();
			        	
			        	System.out.println("Celular");
			        	int cel = sc.nextInt();
			        	
			        	System.out.println("Salario");
			        	int suel = sc.nextInt();
			        	
						cond = new Conductor(nomb,ced,cel,suel);				
					}
					
					if(tipobus==0) {
						
						Bus B1 = new Ejecutivo();
						B1.setConductor(cond);
						B1.setPlaca(pla);
					}
		        	
					if(tipobus==1) {
						
						Bus B2 = new TecnoVans();
						B2.setConductor(cond);
						B2.setPlaca(pla);
					}
					
					if(tipobus==2) {
						
						Bus B3 = new EuroVans();
						B3.setConductor(cond);
						B3.setPlaca(pla);
					}
		        	
		        }
		        
		        else if(opcionelegida==1) {
		        	
		        	System.out.println("Ingrese la placa del bus que va ha eliminar: ");
		        	String plac = sc.next();	   
		        	
					for(Bus b: Bus.getBuses()) { //Recorre todos los viajes 
						if(b.getPlaca() == plac) {
							Bus.getBuses().remove(b);
							break;
							}
						}
		        }
		        
		        else if(opcionelegida==2) {
		        	System.out.println("Ingrese nombre de Conductor a Cambiar");
		        	String cond1 = sc.next();	
		        	
		        	System.out.println("Ingrese nombre de nuevo conductor");
		        	String cond2 = sc.next();	 
		        	
					for(Conductor c: Conductor.getConductores()) { //Recorre todos los viajes 
						if(c.getNombre() == cond1) {
							
							c.setNombre(cond2);
				        	
				        	System.out.println("Cedula del nuevo conductor");
				        	int cedu = sc.nextInt();
							c.setCedula(cedu);
				        	
				        	System.out.println("Celular del nuevo conductor");
				        	int celu = sc.nextInt();
							c.setCelular(celu);
				        	
				        	System.out.println("Salario del nuevo conductor");
				        	int sueld = sc.nextInt();
							c.setSueldo(sueld);
												
							break;
						}
		        	

					}
		        }
		        
		        
		        else if(opcionelegida==3) {
					for(Bus bu: Bus.getBuses()) { //Recorre todos los viajes 
							System.out.println(bu);
						}
		        }
    	}

    
  
  
  
}
