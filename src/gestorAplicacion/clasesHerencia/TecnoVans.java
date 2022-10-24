package gestorAplicacion.clasesHerencia;

import java.util.ArrayList;
import gestorAplicacion.clasesPrincipales.*;

import gestorAplicacion.clasesPrincipales.Bus;
import gestorAplicacion.clasesPrincipales.Conductor;

public class TecnoVans extends Bus{
	int codigo;
	private final int precioKm=800;//precio por km
	private final int capacidad=22;
	public static ArrayList<TecnoVans> tecnosV = new ArrayList<TecnoVans>();

	
	//constructor
		public TecnoVans(String placa, Conductor conductor, ArrayList<String> sillas) {
			super(placa,conductor,sillas);
			this.codigo=200;
			TecnoVans.tecnosV.add(this);
		}
	//get&set capacidad
		public int getCapacidad() {
			return capacidad;
		}

		public int getPrecioKm() {
			return precioKm;
		}
		//get&set codigo
		public int getCodigo() { //desde aqui agregue 
			return codigo;
		}

		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		@Override
		public void sillasDisponibles() {
			for(Tiquete tiquete : Viaje.getTiquetesTodos()){
				if(tiquete.getEstado() == false){
					System.out.println("la silla: "+tiquete.getSillaTiquete()+"esta disponible");
					}
				}
			}
		public String sillaTiquete(Tiquete tiquete) {
			return tiquete.getSillaTiquete();
		}
}