package gestorAplicacion.clasesPrincipales;

import java.util.ArrayList;

public class EuroVans extends Bus{
	private int capacidad;
	private final int precio=1000;//precio por km
	
	//constructor
		public EuroVans(String modelo, String placa, Conductor conductor, int capacidad, ArrayList<String> sillas) {
			super(modelo,placa,conductor,sillas);
			this.capacidad=capacidad;
			this.codigo=250;
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
		@Override
		public void sillasDisponibles() {
			for(Tiquete tiquete : Viaje.gettiquetesTodos()){
				if(tiquete.getEstado() == false){
					System.out.println("la silla: "+tiquete.getSillaTiquete()+"esta disponible");
					}
				}
			}
		public String sillaTiquete(Tiquete tiquete) {
			return tiquete.getSillaTiquete();
		}
}
