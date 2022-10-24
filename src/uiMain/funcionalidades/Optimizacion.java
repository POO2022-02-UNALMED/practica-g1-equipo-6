//package uiMain.funcionalidades;
//import gestorAplicacion.clasesPrincipales.*;
//import java.util.Scanner;

//public class Optimizacion {
//	static Scanner sc = new Scanner(System.in);
//	static Scanner in = new Scanner(System.in);
//	public static void showMenuTiquete() {
//		System.out.println(" ");
//		System.out.println("----- SISTEMA DE OPTIMIZACION -----");
//		System.out.println("¿Que operación desea realizar?");
//		System.out.println("[1] Optimizar precio:Obtener promoción");
//		System.out.println("[2] Optimizar viajes: viajes con paradas");
//		System.out.println("[3] Optimizar buses:cubrimiento buses");
//		
//	    int opcion = sc.nextInt();
//	    switch (opcion) {
//	    case 1:
//	    	Optimizacion.ObtenerPromocion();
//	    	break;
//	    case 2:
//	    	Optimizacion.ViajesParadas();
//	    }
//	}
//	public static void ObtenerPromocion() {
//		System.out.println("Ingrese su documento");
//		String numDocumento=sc.next().toUpperCase();
//		//System.out.println("Ingrese el origen");
//		//String origen=sc.next().toUpperCase();
//		//System.out.println("Ingrese el destino");
//		//String destino=sc.next().toUpperCase();
//		//if(!Viaje.getLugares().contains(origen) || !Viaje.getLugares().contains(destino) ) {
//			//System.out.println("Opcion no disponible");
//			//}
//		//System.out.println("Tus opciones de viaje disponibles son: ");
//		for(Tiquete tiquetes: Tiquete.getTiquetesComprados()){
//			if(tiquetes.getPasajero().getCedula().equals(numDocumento)){
//				int capacidadcal=(tiquetes.getViaje().getBus().getCapacidad()*10)/100;//cambiar
//				if(tiquetes.getViaje().tiquetesDisponibles().size()<=capacidadcal);
//				for(Viaje viaje: Viaje.getViajes()) {
//					if(viaje.getDestino())
//				}
//			}
//			if(viaje.getDestino().equalsIgnoreCase(destino) & viaje.tiquetesDisponibles().size()!=0 
//					& viaje.getEnViaje()) {
//				int capacidadcal=(viaje.getBus().getCapacidad()*10)/100;//utilizar funcion camilo
//				if(viaje.tiquetesDisponibles().size()<=capacidadcal) {//cambiar 10 por capacidad
//					System.out.println("Ingrese hora a la que quiere salir");//el viaje que deseas comprar tiene pocos tiquetes, tenemos la opcion de promo
//					String HoraCliente=sc.next();
//					String HoraViaje=viaje.getHora_inicio();
//					String[] partesCli = HoraCliente.split(":");
//				    String[] partesVia = HoraViaje.split(":");
//				    String hora_1=partesCli[0];
//				    int hora_min1 = Integer.parseInt (hora_1);
//				    String min_1=partesCli[1];
//				    int min_hora1 = Integer.parseInt (min_1);
//				    String hora_2=partesVia[0];
//				    int hora_min2 = Integer.parseInt (hora_2);
//				    String min_2=partesVia[1];
//				    int min_hora2 = Integer.parseInt (min_2);
//				    if(hora_min2>=hora_min1) {
//				    	int horasDcto;
//				    	hora_min2-=hora_min1;
//					    min_hora2-=min_hora1;
//					    horasDcto=(hora_min2*60+min_hora2);
//					    if(horasDcto>=0) {
//					    	if(horasDcto>=60 && horasDcto<120) {
//					    		viaje.setPrecio(viaje.getPrecio()-((viaje.getPrecio()*20)/100));
//					    	}else if(horasDcto>=120 && horasDcto<180){
//					    		viaje.setPrecio(viaje.getPrecio()-((viaje.getPrecio()*30)/100));
//					    	}else if(horasDcto>=180) {
//					    		viaje.setPrecio(viaje.getPrecio()-((viaje.getPrecio()*40)/100));
//					    	}
//					    	System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
//					    }
//					    else {
//					    	System.out.println("Fuera de servicio");}
//				    }
//				    else {
//				    	System.out.println("Fuera de servicio");}
//				}
//			}
//		  }
//	}
//	public static void ViajesParadas() {
//		System.out.println("Ingrese el origen");
//		String origen=sc.next().toUpperCase();
//		System.out.println("Ingrese el destino");
//		String destino=sc.next().toUpperCase();
//		int promEjecutivo=0; //si se pone como final
//		int promEuro=0;//se puede usar el codigo para acceder a la instancia
//		int promTecno=0;
//		int iterador_1=0;
//		int iterador_2=0;
//		int iterador_3=0;
//		for(Viaje viaje : Viaje.getViajes()){
//			if(viaje.getOrigen().equalsIgnoreCase(origen) & viaje.tiquetesDisponibles().size()!=0 &
//					viaje.getEnViaje()) {
//				if(viaje.getDestino().equalsIgnoreCase(destino)){
//					if(viaje.getBus()instanceof Ejecutivo) {
//						iterador_1+=1;
//						promEjecutivo+=promEjecutivo;
//						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
//					}
//					else if(viaje.getBus()instanceof EuroVans) {
//						iterador_2+=1;
//						promEuro+=promEuro;
//						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
//					}
//					if(viaje.getBus()instanceof TecnoVans) {
//						iterador_3+=1;
//						promTecno+=promTecno;
//						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
//					}
//					
//				}
//				
//				else if(viaje.getParada().contains(destino)) {
//					if(iterador_1>0) {
//						promEjecutivo=(int)(promEjecutivo/iterador_1);
//						viaje.setPrecio(promEjecutivo);
//						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
//						iterador_1=0;
//						}
//					else if(iterador_2>0) {
//						promEuro=(int)(promEuro/iterador_2);
//						viaje.setPrecio(promEuro);
//						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
//						iterador_2=0;
//					}
//					else if(iterador_3>0) {
//						promTecno=(int)(promTecno/iterador_3);
//						viaje.setPrecio(promTecno);
//						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
//						iterador_3=0;
//					}
//					else {
//						float beta;
//						beta=1/(viaje.getParada().size()+2);
//						viaje.setPrecio((viaje.getParada().indexOf(destino)+1)*beta);
//						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString()
//						+"Destino en la parada:"+viaje.getParada().indexOf(destino)+1);
//						
//					}
//				}
//			}
//		}
//	}
//	public static void OptimizarBuses() {
//		
//	}
//}
