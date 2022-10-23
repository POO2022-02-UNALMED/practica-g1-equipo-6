package uiMain.funcionalidades;

import gestorAplicacion.clasesPrincipales.*;
import java.time.LocalDate;
import java.util.Scanner;

public class comprarTiquete {
	static Scanner sc = new Scanner(System.in);
	public static Tiquete comprarTiqueteTerminal(){
        Pasajero compradorBase = new Pasajero("Juan","Ardila",1002819665,21, "FLOTAAPPCOMPRADOR");
        Tiquete finalTiquete = new Tiquete();
        System.out.println("Quieres buscar un bus por: ");
		System.out.println("0. Origen");
		System.out.println("1. Destino");
		System.out.println("2. Origen y destino");
		System.out.println("3. Fecha ");
		int opcionCompra= sc.nextInt();
		while (opcionCompra!=0 & opcionCompra!=1 & opcionCompra!=2 & opcionCompra !=3) {
			System.out.println("Porfavor ingresa una opcion valida");
			opcionCompra = sc.nextInt();
		}
		int i=0;
		System.out.println("Los lugares disponibles de origen y destino son: ");
		for(String viaje: Viaje.getLugares()) {
			System.out.println(i + ". "+viaje);//Imprimir los lugares disponibles para viajar
			i++;
	   }
		if(opcionCompra==0) {
			System.out.println("Ingresa tu origen: ");
			String opcionOrigen= sc.next();
			System.out.println("Tus opciones de viaje disponibles son: ");
			for(Viaje viaje : Viaje.getViajes()){
				if(viaje.getOrigen().equalsIgnoreCase(opcionOrigen) & viaje.tiquetesDisponibles().size()!=0
						& viaje.getEnViaje()) {
					System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
				}
			}
			System.out.println("Ingrese una opcion de viaje: ");
			int opcionViaje = sc.nextInt();
			for(Viaje viaje : Viaje.getViajes()){
				if(viaje.getOrigen().equalsIgnoreCase(opcionOrigen) & viaje.tiquetesDisponibles().size()!=0
						& viaje.getId()== opcionViaje) {
					if( opcionViaje == viaje.getId()){
						Tiquete tiquete = viaje.tiquetesDisponibles().get(0);
	                    Tiquete.asignarTiquete( compradorBase , tiquete);
	                    System.out.println(tiquete);
	                    return tiquete;
		                }
		                else{
		                    System.out.println("ID NO VALIDO");
							return finalTiquete;
		                }
			     }
		      }
	 }else if(opcionCompra==1) {
		 System.out.println("Ingresa tu destino: ");
		 String opcionDestino= sc.next();
		 System.out.println("Tus opciones de viaje disponibles son: ");
		 for(Viaje viaje : Viaje.getViajes()){
				if(viaje.getDestino().equalsIgnoreCase(opcionDestino) & viaje.tiquetesDisponibles().size()!=0
						& viaje.getEnViaje()) {
						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
			     }
		      }
		 System.out.println("Ingrese una opcion de viaje: ");
			int opcionViaje = sc.nextInt();
			for(Viaje viaje : Viaje.getViajes()){
				if(viaje.getOrigen().equalsIgnoreCase(opcionDestino) & viaje.tiquetesDisponibles().size()!=0
						& viaje.getId()== opcionViaje) {
					if( opcionViaje == viaje.getId()){
						Tiquete tiquete = viaje.tiquetesDisponibles().get(0);
	                    Tiquete.asignarTiquete( compradorBase , tiquete);
	                    System.out.println(tiquete);
	                    return tiquete;
		                }
		                else{
		                    System.out.println("ID NO VALIDO");
							return finalTiquete;
		                }
			     }
		      }
		 
	 }else if(opcionCompra==2) {
		 System.out.println("Ingresa tu origen: ");
		 String opcionOrigen= sc.next();
		 System.out.println("Ingresa tu destino");
		 String opcionDestino = sc.next();
		 System.out.println("Tus opciones de viaje disponibles son: ");
		 for(Viaje viaje : Viaje.getViajes()){
				if(viaje.getOrigen().equalsIgnoreCase(opcionOrigen) & viaje.getDestino().equalsIgnoreCase(opcionDestino) 
						& viaje.tiquetesDisponibles().size()!=0 & viaje.getEnViaje()) {
						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
					}
		      }
		 System.out.println("Ingrese una opcion de viaje: ");
			int opcionViaje = sc.nextInt();
			for(Viaje viaje : Viaje.getViajes()){
				if(viaje.getOrigen().equalsIgnoreCase(opcionOrigen) & viaje.getDestino().equalsIgnoreCase(opcionDestino) & viaje.tiquetesDisponibles().size()!=0
						& viaje.getId()== opcionViaje) {
					if( opcionViaje == viaje.getId()){
						Tiquete tiquete = viaje.tiquetesDisponibles().get(0);
	                    Tiquete.asignarTiquete( compradorBase , tiquete);
	                    System.out.println(tiquete);
	                    return tiquete;
		                }
		                else{
		                    System.out.println("ID NO VALIDO");
							return finalTiquete;
		                }
			     }
		      }
	 }else if(opcionCompra==3) {
		 System.out.println("Ingresa la fecha del viaje (aaaa-mm-dd) : ");
		 String opcionFecha = sc.next();
		 LocalDate localDate = LocalDate.parse(opcionFecha);
		 System.out.println("Tus opciones de viaje disponibles son: ");
			for(Viaje viaje : Viaje.getViajes()){
				if(viaje.getFecha().equals(localDate) & viaje.tiquetesDisponibles().size()!=0
						& viaje.getEnViaje()) {
					System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
				}
			}
			System.out.println("Ingrese una opcion de viaje: ");
			int opcionViaje = sc.nextInt();
			for(Viaje viaje : Viaje.getViajes()){
				if(viaje.getFecha().equals(localDate) & viaje.tiquetesDisponibles().size()!=0
						& viaje.getId()== opcionViaje) {
					if( opcionViaje == viaje.getId()){
						Tiquete tiquete = viaje.tiquetesDisponibles().get(0);
	                    Tiquete.asignarTiquete( compradorBase , tiquete);
	                    System.out.println(tiquete);
	                    return tiquete;
		                }
		                else{
		                    System.out.println("ID NO VALIDO");
							return finalTiquete;
		                }
			     }
			}
		 
	 }
		System.out.println("NO HAY TIQUETES DISPONIBLES PARA EL VIAJE QUE DESEAS");
        return finalTiquete;
   }

}
