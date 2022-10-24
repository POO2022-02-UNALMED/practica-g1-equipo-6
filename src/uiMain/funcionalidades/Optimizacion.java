package uiMain.funcionalidades;
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
	    case 2:
	    	Optimizacion.ViajesParadas();
	    }
	}
	public static void ObtenerPromocion() {
		System.out.println("Ingrese el origen");
		String origen=sc.next().toUpperCase();
		System.out.println("Ingrese el destino");
		String destino=sc.next().toUpperCase();
		if(!Viaje.getLugares().contains(origen) || !Viaje.getLugares().contains(destino) ) {
			System.out.println("Opcion no disponible");
			}
		//System.out.println("Tus opciones de viaje disponibles son: ");
		for(Viaje viaje : Viaje.getViajes()){
			if(viaje.getDestino().equalsIgnoreCase(destino) & viaje.tiquetesDisponibles().size()!=0 
					& viaje.getEnViaje()) {
				int capacidadcal=(viaje.getBus().getCapacidad()*10)/100;
				if(viaje.tiquetesDisponibles().size()<=capacidadcal) {//cambiar 10 por capacidad
					System.out.println("Ingrese hora a la que quiere salir");
					String HoraCliente=sc.next();
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
					    if(horasDcto>=0) {
					    	if(horasDcto>=60 && horasDcto<120) {
					    		viaje.setPrecio(viaje.getPrecio()-((viaje.getPrecio()*20)/100));
					    	}else if(horasDcto>=120 && horasDcto<180){
					    		viaje.setPrecio(viaje.getPrecio()-((viaje.getPrecio()*30)/100));
					    	}else if(horasDcto>=180) {
					    		viaje.setPrecio(viaje.getPrecio()-((viaje.getPrecio()*40)/100));
					    	}
					    	System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
					    }
					    else {
					    	System.out.println("Fuera de servicio");}
				    }
				    else {
				    	System.out.println("Fuera de servicio");}
				}
			}
		  }
	}
	public static void ViajesParadas() {
		System.out.println("Ingrese el origen");
		String origen=sc.next().toUpperCase();
		System.out.println("Ingrese el destino");
		String destino=sc.next().toUpperCase();
		int precioProm=0;
		int iterador=0;
		for(Viaje viaje : Viaje.getViajes()){
			if(viaje.getOrigen().equalsIgnoreCase(origen) & viaje.tiquetesDisponibles().size()!=0 &
					viaje.getEnViaje()) {
				if(viaje.getDestino().equalsIgnoreCase(destino)){
					iterador+=1;
					precioProm+=precioProm;
					System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
					
				}
				
				else if(viaje.getParada().contains(destino)) {
					if(iterador>0) {
						iterador=0;
						precioProm=(int)(precioProm/iterador);
						viaje.setPrecio(precioProm);
						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString());
						}
					else {
						float beta;
						beta=1/(viaje.getParada().size()+2);
						viaje.setPrecio((viaje.getParada().indexOf(destino)+1)*beta);
						System.out.println("id : ["+viaje.getId()+"] = " +viaje.toString()
						+"Destino en la parada:"+viaje.getParada().indexOf(destino)+1);
						
					}
				}
			}
		}
	}
}
