package uiMain.funcionalidades;
import java.util.Scanner;
import gestorAplicacion.clasesPrincipales.*;

public class Admin {
	Scanner viajeIdS = new Scanner(System.in);
	static Scanner in =new Scanner(System.in);
	static Scanner sc =new Scanner(System.in);
	
	
	public static void showMenuRentabilidad() {
        System.out.println(" ");
        System.out.println("----- RENTABILIDAD -----");

        System.out.println("[1] Visualizar estadisticas");
        System.out.println("[2] Rentabilidad");
        int opcion= sc.nextInt();
        switch (opcion) {
        case 1:
            Admin.visualizarEstadisticas();
            break;
        case 2:
            Admin.rentabilidad();
            break;
           }
    }

    public static void visualizarEstadisticas(){
        System.out.println("----- V I S U A L I Z A R   E S T A D I S T I C A S -----");
        for(Viaje viajes: Viaje.getViajes()){
            System.out.println(" ");
            System.out.println("Lugares: "+viajes.getDestino());
            int i=0;
            for(Tiquete tiquetes: viajes.tiquetesDisponibles()){
            	if(tiquetes.getViaje().getDestino().equals(viajes.getDestino())){
            		i++;
            }
            System.out.println("Numero de Visitante: "+ i);
            for(Viaje viaje : Viaje.getViajes()) {
                if (viaje.getDestino() != null){
                    System.out.println(" ");
                    System.out.println("    Viaje: "+ viaje.getId() + "\n   Origen: " + viaje.getOrigen() + "\n   Destino: " + viaje.getDestino() );
                }
            }
        }
        System.out.println("Dime el ID del viaje que deseas gestionar :  ");
        Scanner viajeIdS = new Scanner(System.in);
        int viajeID = viajeIdS.nextInt();
        Viaje viajeFinal = new Viaje();
        for(Viaje viaje1 : Viaje.getViajes()){
            if(viaje1.getId() == viajeID){
                viajeFinal = viaje1;
            }
        }
        if(viajeFinal.getBus() == null){
            System.out.println("VIAJE NO REGISTRADO");
        }
        else{
            float porcentaje = ((viajeFinal.getBus().getSillas().size() - viajeFinal.tiquetesDisponibles().size())*100)/viajeFinal.getBus().getSillas().size();
            System.out.println("    Promedio de ocupacion: " + porcentaje + " %");
            evaluarPorcentajeOcupacion(viajeFinal, porcentaje);
        }
    }
}

    public static Viaje evaluarPorcentajeOcupacion(Viaje viaje, float porcentaje){
        if (porcentaje >= 85){
            viaje.aumentarFrecuencia(1);
            return viaje;
        }else if(porcentaje >= 40 && porcentaje < 60){
            viaje.disminuirFrecuencia(2);
            //APLICAR LO DEL BONO
            return viaje;
        }else if(porcentaje < 10){
            System.out.println("[1] Eliminar Viaje\n[2] No eliminar, Tener Fe ");
            Scanner aux = new Scanner(System.in);
            int propuesta = aux.nextInt();
            if ( propuesta == 1) {
                viaje.eliminarViaje();
            }else{
                System.out.println("Esperemos que no genere muchas Perdidas");
            }
        }
        return viaje;
    }
	

    public static void rentabilidad(){
        System.out.println("--------- R E N T A B I L I D A D ---------" + "\n");        
        for (Viaje allViajes: Viaje.getViajes()) {
        	System.out.println(allViajes.toString() + "\n");
        }
        System.out.println("Dijite el id del viaje al cual le quiere calcular la rentabilidad");
        Scanner ciudadR = new Scanner(System.in);
        int entrada = ciudadR.nextInt();
        

        for (Viaje allViaje: Viaje.getViajes()) {
        	if (allViaje.getId() == entrada) {
        		rentabilidadViaje(allViaje);
        	}else {
        		continue;
        	}
        }

    }
    
  public static void rentabilidadViaje(Viaje viaje) {
	  int valorTiquetes = 0;
	  int sillasOcupadas = 0;
	  for (Tiquete tiqueteViaje: viaje.getTiquetesTodos()) {
		  if (tiqueteViaje.getEstado()) {
			  valorTiquetes += tiqueteViaje.getValor();
			  sillasOcupadas++;
		  }else {
			  continue;
		  }
	  }
	  System.out.println(viaje.toString()+ "\n");
	  System.out.println( "La ocupacion del vehiculo fue del : " + (100 / viaje.getTiquetesTodos().size() * sillasOcupadas) + "%" + "," + 
	  " con " + viaje.getTiquetesTodos().size() + " sillas disponibles en total. \n");
	  System.out.println("Para este viaje se genero por tiquetes $" + valorTiquetes + " y su costo de operaci�n fue de " + viaje.getCosto() + 
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
			  for (Tiquete tiqueteAux: cadaViaje.getTiquetesTodos()) {
				  if (tiqueteAux.getEstado()) {
					  valorTaux +=  tiqueteAux.getValor();
					  ocupadasAux++;
				  }else {
					  continue;
				  }				  			  
			  }
			  ocupacionT += 100/cadaViaje.getTiquetesTodos().size()*ocupadasAux;
			  cantViajes++;
			  costoTot += cadaViaje.getCosto();
			  gananciaT += valorTaux;
			  
		  }else {
			  continue;
		  }
		  System.out.println("La ocupacion promedio para la ruta "+ viaje.getOrigen()+"-"+viaje.getDestino()+ " es del " + ocupacionT/cantViajes + "%"+
				  " y su utilidad promedio es de " + (gananciaT -costoTot));
	  }
   }
  

}


