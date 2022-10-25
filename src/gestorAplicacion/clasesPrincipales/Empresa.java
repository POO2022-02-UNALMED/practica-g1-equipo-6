package gestorAplicacion.clasesPrincipales;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa   implements Serializable  {
	
	private static final long serialVersionUID = 4L;
	
	private ArrayList<Conductor> conductores = new ArrayList<Conductor>();//atributo conductores contendra una lista con los conductores de la empresa cardinalidad[0..*]
	private ArrayList<Viaje> viajes = new ArrayList<Viaje>();//atributo viajes contendra una lista con los viajes de la empresa cardinalidad[0..*]
	private ArrayList<Bus> buses = new ArrayList<Bus>();//atributo buses contendra una lista con los buses de la empresa cardinalidad[0..*]
	private static ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	
	
	//Constructores
	Empresa(Conductor conductor, Viaje viaje, Bus bus){
		this.conductores.add(conductor);
		this.viajes.add(viaje);
		this.buses.add(bus);
		Empresa.empresas.add(this);
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
	
	
	public static ArrayList<Empresa> getEmpresas() {
		return empresas;
	}

	public static void setEmpresas(ArrayList<Empresa> empresas) {
		Empresa.empresas = empresas;
	}

	//Metodo_crearViaje
	public static Viaje crearViaje(int id,String hora_inicio, String hora_llegada, LocalDate fecha,
			Ruta ruta,Bus bus, Boolean enViaje, int frecuencia, int costoViaje){

		return new Viaje(id, hora_inicio, hora_llegada, fecha, ruta, bus, enViaje, frecuencia, costoViaje);
		}
	
	//Metodo_crearViaje
	public static void crearViaje(int id,String hora_inicio, String hora_llegada, Ruta rut,Bus bus,int frequency, int costoViaje){

		 new Viaje(id, hora_inicio, hora_llegada, rut, bus, frequency, costoViaje);
	}
	//Metodo_CancelarViaje
	public void CancelarViaje(Viaje viaje) {
		viaje=null;
	}

}
