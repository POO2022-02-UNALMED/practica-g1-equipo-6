package uiMain.funcionalidades;
import gestorAplicacion.clasesHerencia.*;
import gestorAplicacion.clasesPrincipales.*;
import java.util.Scanner;

public class Optimizacion {
	static Scanner sc = new Scanner(System.in);
	static Scanner in = new Scanner(System.in);
	public static void showMenuTiquete() {
		System.out.println(" ");
		System.out.println("----- SISTEMA DE OPTIMIZACION -----");
		System.out.println("¿Que operación desea realizar?");
		System.out.println("[1] Optimizar precio:Obtener promoción");
		System.out.println("[2] Optimizar viajes: viajes con paradas");
		System.out.println("[3] Optimizar buses:cubrimiento buses");
		
	    int opcion = sc.nextInt();
	    switch (opcion) {
	    case 1:
	    	Optimizacion.ObtenerPromocion();
	    	break;
	    }
	}
	//el viaje que deseas comprar tiene pocos tiquetes, tenemos la opcion de promo
	public static void ObtenerPromocion() {
		System.out.println("Ingrese su documento");
		String numDocumento=sc.next().toUpperCase();
		for(Tiquete tiquetes: Tiquete.getTiquetesComprados()){
			if(tiquetes.getPasajero().getCedula().equals(numDocumento)){
				int capacidadcal=(tiquetes.getViaje().getBus().getCapacidad()*90)/100;//cambiar
				if(tiquetes.getViaje().tiquetesDisponibles().size()>=capacidadcal);
				for(Viaje viaje: Viaje.getViajes()) {
					if(viaje.getOrigen().equalsIgnoreCase(tiquetes.getViaje().getOrigen()) &
							viaje.getDestino().equalsIgnoreCase(tiquetes.getViaje().getDestino()) &
						    viaje.tiquetesDisponibles().size()!=0 & viaje.getEnViaje() & 
							viaje.tiquetesDisponibles().size()<=tiquetes.getViaje().tiquetesDisponibles().size()){
						String HoraCliente=tiquetes.getViaje().getHora_inicio();
						String HoraViaje=viaje.getHora_inicio();
						String[] partesCli = HoraCliente.split(":");
					    String[] partesVia = HoraViaje.split(":");
					    String hora_1=partesCli[0];
					    int hora_min1 = Integer.parseInt (hora_1);
					    String min_1=partesCli[1];
					    int min_hora1 = Integer.parseInt (min_1);
					    String hora_2=partesVia[0];
					    int hora_min2 = Integer.parseInt (hora_2);
					    String min_2=partesVia[1];
					    int min_hora2 = Integer.parseInt (min_2);
					    if(hora_min2>=hora_min1) {
					    	int horasDcto;
					    	hora_min2-=hora_min1;
						    min_hora2-=min_hora1;
						    horasDcto=(hora_min2*60+min_hora2);
						    if(horasDcto>=60 && horasDcto<120) {
						    	System.out.println(viaje.getPrecio()-((viaje.getPrecio()*20)/100));
						    	System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString()+"Precio con descuento"+(viaje.getPrecio()-((viaje.getPrecio()*20)/100)));
						    	//viaje.setPrecio(viaje.getPrecio()-((viaje.getPrecio()*20)/100));
						    }
						    else if(horasDcto>=120 && horasDcto<180){
						    	System.out.println(viaje.getPrecio()-((viaje.getPrecio()*30)/100));
						    	System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString()+"Precio con descuento"+(viaje.getPrecio()-((viaje.getPrecio()*30)/100)));
						    	//viaje.setPrecio(viaje.getPrecio()-((viaje.getPrecio()*30)/100));
						    }
						    else {
						    	System.out.println("No tenemos una promocion para ti en este momento D':");
						    }
						}
					    else {System.out.println("No tenemos una promocion para ti en este momento D':");}
						
					}
					else {System.out.println("No hay viajes disponibles con estas condicions, estamos trabajando en ello :D");}
				}
			}
			else {System.out.println("No hay viajes registrados con ese documento");}
		}
	}
	
	

					

	//se puede usar el codigo para acceder a la instancia en vez del instanceof
	public static void ViajesParadas() {
		System.out.println("Ingrese el origen");
		String origen=sc.next().toUpperCase();
		System.out.println("Ingrese el destino");
		String destino=sc.next().toUpperCase();
		int promEjecutivo=0; //si se pone como final
		int promEuro=0;
		int promTecno=0;
		int iterador_1=0;
		int iterador_2=0;
		int iterador_3=0;
		for(Viaje viaje : Viaje.getViajes()){
			if(viaje.getOrigen().equalsIgnoreCase(origen) & viaje.tiquetesDisponibles().size()!=0 &
					viaje.getEnViaje()) {
				if(viaje.getDestino().equalsIgnoreCase(destino)){
					if(viaje.getBus()instanceof Ejecutivo) {
						iterador_1+=1;
						promEjecutivo+=promEjecutivo;
						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
					}
					else if(viaje.getBus()instanceof EuroVans) {
						iterador_2+=1;
						promEuro+=promEuro;
						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
					}
					if(viaje.getBus()instanceof TecnoVans) {
						iterador_3+=1;
						promTecno+=promTecno;
						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
					}
					
				}
				
				else if(viaje.getRuta().getParadas().contains(destino)) {
					if(iterador_1>0) {
						promEjecutivo=(int)(promEjecutivo/iterador_1);
						viaje.setPrecio(promEjecutivo);
						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
						iterador_1=0;
						}
					else if(iterador_2>0) {
						promEuro=(int)(promEuro/iterador_2);
						viaje.setPrecio(promEuro);
						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
						iterador_2=0;
					}
					else if(iterador_3>0) {
						promTecno=(int)(promTecno/iterador_3);
						viaje.setPrecio(promTecno);
						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
						iterador_3=0;
					}
					else {
						float beta;
						beta=1/(viaje.getRuta().getParadas().size()+2);
						viaje.setPrecio((int)((viaje.getRuta().getParadas().indexOf(destino)+1)*beta));
						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString()
						+"Destino en la parada:"+viaje.getRuta().getParadas().indexOf(destino)+1);
						
					}
				}
			}
		}
	}
	public static void OptimizarBuses() {
		
	}
}
