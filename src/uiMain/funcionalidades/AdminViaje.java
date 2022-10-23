package uiMain.funcionalidades;

import gestorAplicacion.clasesPrincipales.*;
import java.time.LocalDate;
import java.util.Scanner;

public class AdminViaje {
	static Scanner sc = new Scanner(System.in);
    static Scanner in = new Scanner(System.in);
	public static void showMenuTiquete() {
        System.out.println(" ");
        System.out.println("----- SISTEMA DE COMPRA TIQUETES -----");
        
        System.out.println("¿Que operación desea realizar?");
        System.out.println("[1] Ver todos los viajes disponibles por tipos de buses");
        System.out.println("[2] Compra de tiquete");
        System.out.println("[3] Adquirir servicios");
        System.out.println("[4] Modificar silla ");
        int opcion = sc.nextInt();
        switch (opcion) {
        case 1:
            AdminViaje.viajesPorBus();
            break;
        case 2:
        	AdminViaje.comprarTiqueteTerminal();
            break;
        case 3:
        	AdminViaje.adquirirServicio();
            break;
        case 4:
        	AdminViaje.modificarSilla();
            break;
        }
        
    }
	
	public static void viajesPorBus() {
		System.out.println("Ingrese una opcion de bus");
		System.out.println("1. Ejecutivo");
		System.out.println("2. Tecnovans");
		System.out.println("3. Eurovans");
		int bus= sc.nextInt();
		if(bus==1) {
			for(Viaje viajes: Viaje.getViajes()) { //Recorre todos los viajes 
				if(viajes.getBus().codigo==150) {//Valida que el codigo del bus sea igual al dado
					System.out.println(viajes); //imprime los viajes que coinciden con la coondicion(Ejecutivo)
				}
			}
		}else if(bus==2) {
			for(Viaje viajes: Viaje.getViajes()) {
				if(viajes.getBus().codigo==200) {
					System.out.println(viajes);
				}
			}
		}else {
			for(Viaje viajes: Viaje.getViajes()) {
				if(viajes.getBus().codigo==250) {
					System.out.println(viajes);
				}
			}
		}
		
	}
	
	
	public static void modificarSilla() {
		System.out.println("Digite su numero de documento: ");
		int numDocumento = sc.nextInt();
		System.out.println("Digite su silla actual");
		String sillaVieja= sc.next();
		System.out.println("Digite la silla deseada: ");
		String sillaNueva = sc.next();
		if(Bus.getSillaNoDisponibles().contains(sillaNueva)) { //Valida que la silla no este ocupada
			System.out.println("Silla ocupada");
		}else {
			for (Tiquete tiquetes: Tiquete.getTiquetesComprados()) { //recorre la lista de tiqComprados
				if(tiquetes.getPasajero().getCedula().equals(numDocumento)){//busca el tiquete que coincida con la cedula ingresada
					tiquetes.setSillaTiquete(sillaNueva); // Se le asigna la nueva silla al tiquete comprado
					Bus.getSillaNoDisponibles().remove(sillaVieja); //de la lista de sillasNo disponibles se remueve la silla inicial
					Bus.getSillaNoDisponibles().add(sillaNueva); // de la lista de sillas no disponibles se agrega la nueva silla asignada
					System.out.println(tiquetes.toString()); //imprime el tiquete con la nueva silla
				}
				for(Viaje viajes: Viaje.getViajes()) { //recorre todos los viajes 
					for(Tiquete tiquetesTodos: viajes.tiquetesDisponibles()) { //obtiene todos los tiquetes disponibles
						if(tiquetesTodos.getSillaTiquete().equalsIgnoreCase(sillaNueva)) { //busca el tiquete que tenia asignada la silla que eligio el usuario como nueva
							tiquetesTodos.setSillaTiquete(sillaVieja); // se hace un intercambio: de la silla asignada anteriormente por la silla que habia comprado el usuario inicialmente
						  }
					   }
				    }
		        }
	       }
		}
	public static void adquirirServicio(){
		System.out.println("SERVICIOS");
		System.out.println("Digite un servicio:\r\n\" MALETAS_EXTRA(5000),\r\n"
				+ "		ALMOHADA(2500),\r\n"
				+ "		AURICULARES(3000),\r\n"
				+ "		VIAJAR_CON_MASCOTA(10000);");
		System.out.println("Ingrese el servicio que sea adquirir: ");
		String serv = sc.next().toUpperCase();
		System.out.println("Digite su numero de documento: ");
		int numDocumento = sc.nextInt();
		for (Tiquete tiquetes: Tiquete.getTiquetesComprados()) { //recorre la lista de los tiquetes comprados
			if(tiquetes.getPasajero().getCedula().equals(numDocumento) ){//busca el tiqeuete que coincida con la cedula ingresada
				Servicio el_Servicio = Enum.valueOf(Servicio.class, serv); //guarda el valor del nommbre del enum ingresado
				int nuevoValor = (tiquetes.getValor() + el_Servicio.getPrecio());//Tomo el valor de tiquete y no de viaje   IMPORTANTE
				tiquetes.setValor(nuevoValor); //Se reemplaza el anterior valor por el nuevo que es el valor del tiquete mas el del servicio
				System.out.println(tiquetes.toString()+"\r\n"+ //se imprime el nuevo tiquete con el servicio incluido
				"Servicios: "+"\r\n"+serv);
				}else {
					System.out.println("Tiquete no encontrado"); //en caso de que no encuentre un tiquete con la cedula ingresada
				}
			}
		}
	public static Tiquete comprarTiqueteTerminal(){
        Pasajero compradorBase = new Pasajero("Juan","Ardila",1002819665,21, "FLOTAAPPCOMPRADOR"); //creo una instancia de pasajero
        Tiquete finalTiquete = new Tiquete(); //creo unainstancia de tiqquete vacio
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
			String opcionOrigen= sc.next().toUpperCase();
			if(!Viaje.getLugares().contains(opcionOrigen)) { //valida que el origen ingresado este en las opciones de ruta o viajes disponibles
				System.out.println("Opcion de origen no disponible");
				return finalTiquete;
			}
			System.out.println("Tus opciones de viaje disponibles son: ");
			
			for(Viaje viaje : Viaje.getViajes()){
				if(viaje.getOrigen().equalsIgnoreCase(opcionOrigen) & viaje.tiquetesDisponibles().size()!=0 //recorre todos los viajes e imprime los que coincidan con el origen ingresado por el usuario
						& viaje.getEnViaje()) {
					System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
				}
			}
			System.out.println("Ingrese una opcion de viaje: "); //elige uno de los viajes 
			int opcionViaje = sc.nextInt();
			for(Viaje viaje : Viaje.getViajes()){
				if(viaje.getOrigen().equalsIgnoreCase(opcionOrigen) & viaje.tiquetesDisponibles().size()!=0 //toma los viajes que coincidan con el origen ingresado y valida que haya tiquetes disponible y el id del viaje coincida con el numero ingresado
						& viaje.getId()== opcionViaje) {
					if( opcionViaje == viaje.getId()){
						Tiquete tiquete = viaje.tiquetesDisponibles().get(0);//elige uno de los tiquetes asociados al viaje elegido
	                    Tiquete.asignarTiquete( compradorBase , tiquete); //Se asigna el tiquete al comprador 
	                    Bus.setSillaNoDisponibles(tiquete.getSillaTiquete());//Sillas no disponibles
	                    System.out.println(tiquete); //devuelve el tiquete 
	                    return tiquete;
		                }
		                else{
		                    System.out.println("ID NO VALIDO"); //si la opcion ingresada no coincide con los viajes disponibles al origen escogido
							return finalTiquete;
		                }
			     }
		      }
	 }else if(opcionCompra==1) {
		 System.out.println("Ingresa tu destino: ");
		 String opcionDestino= sc.next().toUpperCase(); //lo mismo que el primero pero con destino
		 if(!Viaje.getLugares().contains(opcionDestino)) {
				System.out.println("Opcion de origen no disponible");
				return finalTiquete;
			}
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
			if(viaje.getDestino().equalsIgnoreCase(opcionDestino) & viaje.tiquetesDisponibles().size()!=0
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
		 String opcionOrigen= sc.next().toUpperCase(); //lo mismo pero con destino y origen
		 System.out.println("Ingresa tu destino");
		 String opcionDestino = sc.next().toUpperCase();
		 if(!Viaje.getLugares().contains(opcionOrigen) || !Viaje.getLugares().contains(opcionDestino) ) {
				System.out.println("Opcion no disponible");
				return finalTiquete;
			}
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
		 LocalDate localDate = LocalDate.parse(opcionFecha);//lo mismo pero con getfecha
		 if(!Viaje.getFechasViaje().contains(localDate)) {
			 System.out.println("Fecha no disponible");
			 return finalTiquete;
		 }
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
