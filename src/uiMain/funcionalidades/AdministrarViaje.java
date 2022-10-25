package uiMain.funcionalidades;

import java.time.LocalDate;
import java.util.ArrayList;
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
        System.out.println("[2] Cancelar un viaje");
        int opcion = sc.nextInt();
        switch (opcion) {
        case 1:
        	AdministrarViaje.agregarViaje();
            break;
        case 2:
        	AdministrarViaje.modificarViaje();   
        	break;
        case 3:
        	AdministrarViaje.cancelarViaje();   
        	break;
        }
        
    }
    
    public static void agregarViaje() {
    	//public Viaje(String hora_inicio, String hora_llegada,Ruta ruta,Bus bus, int frecuencia, int costoViaje) 
		System.out.println("Digite la hora de inicio del viaje (HH:MM)");
		String hora_inicio=sc.next();
		System.out.println("Digite la hora de llegada al destino del viaje (HH:MM)");
		String hora_llegada=sc.next();
		System.out.println("Seleccione una de las siguientes rutas");
		System.out.println("En caso de que no se encuentre la ruta necesitada, ingrese -1, para ingresar una nueva");
		Ruta.listadoRutas(); //imprime las rutas 
		int rutaSeleccionada=sc.nextInt();
		Ruta ruta;
		if(rutaSeleccionada==-1) {
			//Ruta(String origen, String destino, int km, ArrayList<String> paradas)
			System.out.println("Digite el origen de la ruta");
			String origen=sc.next();
			System.out.println("Digite el destino de la ruta");
			String destino=sc.next();
			System.out.println("Digite el numero de km de la ruta");
			int km=sc.nextInt();
			System.out.println("Ingrese las paradas (separadas por un espacio)");
			System.out.println("Si no desea escribir mas paradas, escriba NO");
			String parada;
			ArrayList<String> paradas=new ArrayList<String>();
			while(true) {
				parada=sc.next();
				if(parada.toUpperCase().equals("NO")) {
					break;
				}else {
					paradas.add(parada);
				}
			}
			ruta=Ruta.crearRuta(origen, destino, km, paradas);
		}else {
			ruta=Ruta.getRutas().get(rutaSeleccionada);
		}
		Bus bus=null;
		
		
		System.out.println("Digite la frecuencia del viaje");
		int frecuencia=sc.nextInt();
		System.out.println("Digite el costo del viaje");
		int costoViaje=sc.nextInt();
    	Empresa.crearViaje(hora_inicio, hora_llegada, ruta, bus, frecuencia, costoViaje);
    }
    
    public static void modificarViaje() {
		System.out.println("Seleccione uno de los siguientes viajes");
    	Viaje.listadoViajes(); //imprime los viajes 
		int viajeSeleccionado=sc.nextInt();
		Viaje.getViajes().get(viajeSeleccionado);
		while(true) {
	        System.out.println("¿Que le desea modificar al viaje?");
	        System.out.println("[1] Fecha");
	        System.out.println("[2] Precio");
	        int opcion = sc.nextInt();
	        switch (opcion) {
	        case 1:
	    		System.out.println("Digite la nueva fecha del viaje (YYYY-MM-DD)");
	    		LocalDate fechaNueva=LocalDate.parse(sc.next());
	    		Viaje.getViajes().get(viajeSeleccionado).setFecha(fechaNueva);
	        	break;
	        case 2:
	    		System.out.println("Digite el nuevo precio del viaje");
	    		int precioViaje=sc.nextInt();
	    		Viaje.getViajes().get(viajeSeleccionado).setPrecio(precioViaje);
	        	break;
	        }
			Viaje.getViajes().get(viajeSeleccionado);
			
	        System.out.println("¿Desea modificar algo mas (Si-No)?");
    		if(sc.next().toUpperCase().equals("NO")) {
    			break;
    		}
		}

    	
    	
    }
    
    public static void cancelarViaje() {
		System.out.println("Seleccione uno de los siguientes viajes");
    	Viaje.listadoViajes(); //imprime los viajes 
		int viajeSeleccionado=sc.nextInt();
		Viaje.getViajes().get(viajeSeleccionado).eliminarViaje();
    }
    
    
}
