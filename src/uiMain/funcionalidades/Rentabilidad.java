package uiMain.funcionalidades;
import java.util.Scanner;
import gestorAplicacion.clasesPrincipales.*;

public class Rentabilidad {
	Scanner viajeIdS = new Scanner(System.in);
	static Scanner in =new Scanner(System.in);
	static Scanner sc =new Scanner(System.in);
	
	
	public static void showMenuRentabilidad() {
        System.out.println(" ");
        System.out.println("----- RENTABILIDAD -----");

        System.out.println("[1] Visualizar Ocupacion de Viajes");
        System.out.println("[2] Rentabilidad De Viajes");
        int opcion= sc.nextInt();
        switch (opcion) {
        
        case 1:
            Rentabilidad.visualizarOcupacion();
            break;
        
        case 2:
            Rentabilidad.rentabilidad();
            break;
           }
    }

    
	public static void visualizarOcupacion(){
        System.out.println("----- V I S U A L I Z A R   O C U P A C I O N  D E  V I A J E S  -----");
        for(Viaje viajes: Viaje.getViajes()) {
        	System.out.println("Viaje: "+viajes.getId()+"\r\n"+"Origen: "+viajes.getOrigen()+
        			"\r\n"+"Destino: "+viajes.getDestino());
        }
        
        System.out.println("Ingrese el numero del viaje que desea gestionar: ");
        int idViaje = sc.nextInt();
        Viaje viajeFinal = new Viaje();
        for(Viaje viajes2: Viaje.getViajes()) {
        	if(viajes2.getId()==idViaje) {
        		viajeFinal= viajes2;
        	}
        }
        
        if(viajeFinal.getEnViaje() == false){
            System.out.println("VIAJE NO REGISTRADO");
        }
        
        else{
        	float porcentaje = ((viajeFinal.getBus().getSillas().size() - viajeFinal.tiquetesDisponibles().size())*100)/viajeFinal.getBus().getSillas().size();
            System.out.println("    Promedio de ocupacion: " + porcentaje + " %");
            evaluarPorcentajeOcupacion(viajeFinal, porcentaje);
        }
}

    public static Viaje evaluarPorcentajeOcupacion(Viaje viaje, float porcentaje){
        if (porcentaje >= 85){
            viaje.aumentarFrecuencia(1);
            return viaje;
        }
        else if(porcentaje >= 40 && porcentaje < 60){
            viaje.disminuirFrecuencia(2);
            return viaje;
        }
        else if(porcentaje >= 15 && porcentaje < 40){
            viaje.disminuirFrecuencia(3);
            return viaje;
        }
        else if(porcentaje < 15){
            System.out.println("[1] Eliminar Viaje\n[2] No eliminar ");
            int eliminar = sc.nextInt();
            if ( eliminar == 1) {
                viaje.eliminarViaje();
               for(Tiquete tiqueteEliminar: Viaje.getTiquetesTodos()) {
            	   if(tiqueteEliminar.getEstado()==true) {
            		   System.out.println("Al siguiente tiquete hay que hacerle un reembolso: "+"\r\n"+tiqueteEliminar);
            	   }
               }

            }
            else{
                System.out.println("Esperemos que no genere muchas Perdidas");
            }
        }
        return viaje;
    }
	

    public static void rentabilidad(){
        System.out.println("--------- R E N T A B I L I D A D  D E  V I A J E S---------" + "\n");        
        for (Viaje todosViajes: Viaje.getViajes()) {
        	System.out.println(todosViajes.toString() + "\n");
        }
        
        System.out.println("Digite el id del viaje al cual le quiere calcular la rentabilidad");
        Scanner ciudadR = new Scanner(System.in);
        int entrada = ciudadR.nextInt();
        ciudadR.close();

        for (Viaje todosViajes: Viaje.getViajes()) {
        	if (todosViajes.getId() == entrada) {
        		rentabilidadViaje(todosViajes);
        	}else {
        		continue;
        	}
        }

    }
    
  public static void rentabilidadViaje(Viaje viaje) {
	  int valorTiquetes = 0;
	  int sillasOcupadas = 0;
	  for (Tiquete tiqueteViaje: Viaje.getTiquetesTodos()) {
		  if (tiqueteViaje.getEstado()) {
			  valorTiquetes += tiqueteViaje.getValor();
			  sillasOcupadas++;
		  }else {
			  continue;
		  }
	  }
	  System.out.println(viaje.toString()+ "\n");
	  System.out.println( "La ocupacion del vehiculo fue del : " + (100 / Viaje.getTiquetesTodos().size() * sillasOcupadas) + "%" + "," + 
	  " con " + Viaje.getTiquetesTodos().size() + " sillas disponibles en total. \n");
	  System.out.println("Para este viaje se genero por tiquetes $" + valorTiquetes + " y su costo de operacion fue de " + viaje.getCosto() + 
			  " con una uilidad del " + (valorTiquetes - viaje.getCosto())+ "\n");
	  
	  // promedio  por ruta 
	  int ocupacionT = 0;
	  int cantViajes = 0;
	  int costoTot = 0;
	  int gananciaT = 0;
	  for(Viaje cadaViaje: Viaje.getViajes()) {
		  if(cadaViaje.getOrigen().equals(viaje.getOrigen()) && cadaViaje.getDestino().equals(viaje.getDestino())) {
			  int valorTaux = 0;
			  int ocupadasAux = 0;
			  for (Tiquete tiqueteAux: Viaje.getTiquetesTodos()) {
				  if (tiqueteAux.getEstado()) {
					  valorTaux +=  tiqueteAux.getValor();
					  ocupadasAux++;
				  }
				  else {
					  continue;
				  }				  			  
			  }
			  ocupacionT += 100/Viaje.getTiquetesTodos().size()*ocupadasAux;
			  
			  cantViajes++;
			  
			  costoTot += cadaViaje.getCosto();
			  
			  gananciaT += valorTaux;
			  
		  }
		  else {
			  continue;
		  }
		  System.out.println("La ocupacion promedio para la ruta "+ viaje.getOrigen()+"-"+viaje.getDestino()+ " es del " + ocupacionT/cantViajes + "%"+
				  " y su utilidad promedio es de " + (gananciaT -costoTot));
	  }
   }
  

}


