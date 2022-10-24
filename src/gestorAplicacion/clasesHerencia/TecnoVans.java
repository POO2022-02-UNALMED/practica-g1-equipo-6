package gestorAplicacion.clasesHerencia;

import java.util.ArrayList;
import gestorAplicacion.clasesPrincipales.*;

import gestorAplicacion.clasesPrincipales.Bus;
import gestorAplicacion.clasesPrincipales.Conductor;

public class TecnoVans extends Bus{
	int codigo;
	private final int precio=800;//precio por km
	public static ArrayList<TecnoVans> tecnosV = new ArrayList<TecnoVans>();

	
	//constructor
		public TecnoVans(String modelo, String placa, Conductor conductor, int capacidad, ArrayList<String> sillas) {
			super(modelo,placa,conductor,sillas);
			this.capacidad=capacidad;
			this.codigo=200;
			TecnoVans.tecnosV.add(this);
		}
	//get&set capacidad
		public int getCapacidad() {
			return capacidad;
		}
		public void setCapacidad(int capacidad) {
			this.capacidad=capacidad;
		}
		public int getPrecio() {
			return precio;
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