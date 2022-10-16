package gestorAplicacion.clasesPrincipales;
import java.util.ArrayList;
import java.time.LocalDate;
import java.io.Serializable;
import gestorAplicacion.clasesPrincipales.Ruta;

public class Viaje implements Serializable{
	
	private static final long serialVersionUID= 8L;
	
	private String hora_inicio;
	private String hora_llegada;
	//private String origen;
	private Ruta ruta;
	private LocalDate fecha;
	private int precio;
	private Conductor conductor;
	private Bus bus;
	private boolean enViaje;
	private static ArrayList<Viaje> viajes= new ArrayList<Viaje>();
	private static ArrayList<String> lugares= new ArrayList<String>();
	private ArrayList<Tiquete> tiquetesTodos;

//contructor

	public Viaje(String hora_inicio, String hora_llegada, LocalDate fecha, int precio, Ruta ruta, Conductor conductor,
	Bus bus, Boolean enViaje ) {
		this.hora_inicio= hora_inicio;
		this.hora_llegada= hora_llegada;
		this.fecha= fecha;
		//this.origen= 
		//this.origen= this.ruta.getOrigen();
		//this.destino= this.ruta.getDestino();
		this.ruta= ruta;//Ruta debe crear el destino y el origen sino debe tenerlas el viaje 
		this.precio= precio;
		this.conductor= conductor;
		this.enViaje = true;
		this.bus= bus;
		this.tiquetesTodos= new ArrayList<>();
		
		
		for (String sillaEnVehiculo: this.bus.getSillas()) {
			int genId = this.bus.getSillas().indexOf(sillaEnVehiculo);
			this.tiquetesTodos.add(new Tiquete(genId, null, sillaEnVehiculo, this,10000, fecha));//Valor tengo duda
			
		}
		viajes.add(this);
	}
	
		
	public Viaje(){
		}

		
	//gett y setter  
	public String getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public String getHora_llegada() {
		return hora_llegada;
	}
	public void setHora_llegada(String hora_llegada) {
		this.hora_llegada = hora_llegada;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Conductor getConductor() {
		return conductor;
	}
	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public boolean getEnViaje() {
		return enViaje;
	}
	public void setEnViaje(boolean enViaje) {
		this.enViaje = enViaje;
	}

	//metodos 

	public String sillasDisponibles() {
		
	}

	/*public int asignarsilla() {
		return c;
	}*/

	public Tiquete generarTiquete() {	
	
	}
	
	public ArrayList<Tiquete> tiquetesDisponibles(){
		ArrayList<Tiquete> tiqueteFinal = new ArrayList<>();
		for(Tiquete tiquete : tiquetesTodos){
			if(tiquete.getEstado() == false){
				tiqueteFinal.add(tiquete);
			}
		}
		return tiqueteFinal;
	}

	public void eliminarViaje(){
		Viaje.viajes.remove(this);
	}
	
	
	
	//
	@Override
	public String toString() {
		return "Viaje{" +
				", origen=" + origen +//Rutas debe crear getOrigen donde saque el origen de las rutas 
				", destino=" + destino +
				", fechaViaje=" + fecha +
				'}';
	}
	
	
	public static ArrayList<String> getLugares(){
		for( Viaje viajes: Viaje.getViajes()) {
			if(!lugares.contains(viajes.getOrigen())) {
				lugares.add(viajes.getOrigen());
			}
		}
		for (Viaje viajes: Viaje.getViajes()) {
			if(!lugares.contains(viajes.getDestino())) {
				lugares.add(viajes.getDestino());;
			}
		}return lugares;
	}
/*
	public Tiquete eliminarTiquete() {
	
	} */


}

	



