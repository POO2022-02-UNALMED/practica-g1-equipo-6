package gestorAplicacion.clasesPrincipales;

import java.util.ArrayList;

public class EuroVans extends Bus{
	private final int precio=1000;
	int codigo;//precio por km
	
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
