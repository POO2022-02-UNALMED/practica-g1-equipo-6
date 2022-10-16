package gestorAplicacion.clasesPrincipales;
import java.util.ArrayList;

public class Empresa {
	//atributo conductores contendra una lista con los conductores de la empresa cardinalidad[0..*]
	private ArrayList<Conductor> conductores = new ArrayList<Conductor>();
	//atributo viajes contendra una lista con los viajes de la empresa cardinalidad[0..*]
	private ArrayList<Viaje> viajes = new ArrayList<Viaje>();
	//atributo buses contendra una lista con los buses de la empresa cardinalidad[0..*]
	private ArrayList<Bus> buses = new ArrayList<Bus>();
	
	/**suposicion1:encapsulamiento,privado**/
	/**DUDA:el atributo interseccion no se crea por atributos?**/
	/**Discusion:Que queremos con viajes? guardar todas las instancias de tipo viaje?**/
	
	//Constructores
	Empresa(Conductor conductor, Viaje viaje, Bus bus){
		this.conductores.add(conductor);
		this.viajes.add(viaje);
		this.buses.add(bus);
	}
	
	Empresa(){
		
	}
	
	//Get&Set_Conductores
	public ArrayList<Conductor> getConductores() {
		return conductores;
	}
	public void setConductores(ArrayList<Conductor> conductores) {
		this.conductores = conductores;
	}
	//Get&Set_Viajes
	public ArrayList<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(ArrayList<Viaje> viajes) {
		this.viajes = viajes;
	}

	//Get&Set_Buses
	public ArrayList<Bus> getBuses() {
		return buses;
	}

	public void setBuses(ArrayList<Bus> buses) {
		this.buses = buses;
	}
	//Metodo_crearViaje
	public void crearViaje(){
		//Viaje.crearViaje();
		/**en viaje*/
		/**static Viaje crearViaje(params) {
			return new Viaje(params)
		}**/
		//se puede invocar un constructor dentro de un método?
		}
	//Metodo_CancelarViaje
	public void CancelarViaje(Viaje viaje) {
		viaje=null;
	}
	/**si es un metodo que borre la instancia de viaje o cambie un valor como estadoviaje podria ser
	 * un metodo de la clase viaje
	 */
	
}
