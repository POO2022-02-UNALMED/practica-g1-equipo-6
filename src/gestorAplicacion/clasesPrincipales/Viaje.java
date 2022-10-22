package gestorAplicacion.clasesPrincipales;
import java.util.ArrayList;
import java.time.LocalDate;
import java.io.Serializable;
import gestorAplicacion.clasesPrincipales.Ruta;

public class Viaje implements Serializable{
	
	private static final long serialVersionUID= 8L;
	
	private int id;
	private String hora_inicio;
	private String hora_llegada;
	private String origen;
	private String destino;
	private Ruta ruta; 
	private LocalDate fecha;
	private int precio;
	private Bus bus;
	private boolean enViaje;
	private static ArrayList<LocalDate> fechasViaje = new ArrayList<LocalDate>();
	private static ArrayList<Viaje> viajes= new ArrayList<Viaje>();
	private static ArrayList<String> lugares= new ArrayList<String>();
	private ArrayList<Tiquete> tiquetesTodos;

//contructor

	public Viaje(int id,String hora_inicio, String hora_llegada, LocalDate fecha, int precio, 
			Ruta ruta, Bus bus, Boolean enViaje ) {
		this.hora_inicio= hora_inicio;
		this.hora_llegada= hora_llegada;
		this.fecha= fecha;
		this.ruta= ruta;
		this.precio= precio;
		this.enViaje =enViaje;
		this.bus= bus;
		this.tiquetesTodos= new ArrayList<>();
		
		
		for (String sillaEnVehiculo: this.bus.getSillas()) {
			int genId = id;
			this.tiquetesTodos.add(new Tiquete(genId, null, sillaEnVehiculo, this,10000, fecha));//Valor tengo duda
			
		}
		viajes.add(this);
	}
	public Viaje(){
}
	
	
	//getter y setter 
	public static ArrayList<LocalDate> getFechasViaje() {
		return fechasViaje;
	}

	public static void setFechasViaje(ArrayList<LocalDate> fechasViaje) {
		Viaje.fechasViaje = fechasViaje;
	}

		
	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public Ruta getRuta() {
		return ruta;
	}


	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}


	public ArrayList<Tiquete> getTiquetesTodos() {
		return tiquetesTodos;
	}


	public void setTiquetesTodos(ArrayList<Tiquete> tiquetesTodos) {
		this.tiquetesTodos = tiquetesTodos;
	}

	
	public static void setLugares(ArrayList<String> lugares) {
		Viaje.lugares = lugares;
	}

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
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	

	public static Tiquete generarTiquete(int codigo, Pasajero pasajero, String sillaTiquete, Viaje viaje, int valor, LocalDate fechaCompra) {
		return new Tiquete(codigo, pasajero, sillaTiquete, viaje, valor, fechaCompra);
	}
	
	
	public static ArrayList<Viaje> getViajes() {
		return viajes;
	}


	public static void setViajes(ArrayList<Viaje> viajes) {
		Viaje.viajes = viajes;
		
		
	}
	
	//metodos


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
	
	
	
	@Override
	public String toString() {
		return "Viaje{" +
				", origen=" + origen +
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
	
	
	public void eliminarTiquete(Tiquete tiquete) {
		tiquete=null;
	}

	
	

}

	



