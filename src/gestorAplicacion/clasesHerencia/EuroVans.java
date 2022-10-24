package gestorAplicacion.clasesHerencia;

import java.util.ArrayList;
import gestorAplicacion.clasesPrincipales.Tiquete;
import gestorAplicacion.clasesPrincipales.Viaje;
import gestorAplicacion.clasesPrincipales.Bus;
import gestorAplicacion.clasesPrincipales.Conductor;

public class EuroVans extends Bus{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final int precioKm=1000;
	int codigo;//precio por km
	private final int capacidad=14;
	public static ArrayList<EuroVans> eurosV = new ArrayList<EuroVans>();

	
	//constructor
		public EuroVans(String placa, Conductor conductor, ArrayList<String> sillas) {
			super(placa,conductor,sillas);
			this.codigo=250;
			EuroVans.eurosV.add(this);
		}
		
		public EuroVans() {
			
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
