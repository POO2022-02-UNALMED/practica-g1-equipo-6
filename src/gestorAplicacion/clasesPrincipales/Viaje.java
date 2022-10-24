package gestorAplicacion.clasesPrincipales;
import java.util.ArrayList;
import java.time.LocalDate;
import java.io.Serializable;
import gestorAplicacion.clasesPrincipales.Ruta;

public class Viaje implements Serializable{
	
	private static final long serialVersionUID= 7L;
	
	private int id;
	private int costoViaje;
	private String hora_inicio;
	private String hora_llegada;
	private String origen;
	private String destino;
	private Ruta ruta;
	private LocalDate fecha;
	private int precio;
	private Bus bus;
	private boolean enViaje;
	private static ArrayList<LocalDate> fechasViaje = new ArrayList<LocalDate>(); //agregue esto
	private static ArrayList<Viaje> viajes= new ArrayList<Viaje>();
	private static ArrayList<String> lugares= new ArrayList<String>();
	private static ArrayList<Tiquete> tiquetesTodos;
	private int frecuencia;

	//contructor

	public Viaje(int id,String hora_inicio, String hora_llegada, LocalDate fecha,
		Ruta ruta,Bus bus, Boolean enViaje, int frecuencia, int costoViaje ) {
		this.hora_inicio= hora_inicio;
		this.id=id; 
		this.hora_llegada= hora_llegada;
		this.fecha= fecha;
		this.origen= ruta.getOrigen();
		this.destino=ruta.getDestino();
		this.setFrecuencia(frecuencia);
		this.costoViaje= costoViaje;
		this.enViaje=enViaje;
		this.bus= bus;
		this.precio= (ruta.getKm()*bus.getPrecioKm());
		Viaje.tiquetesTodos= new ArrayList<>();
		Viaje.fechasViaje.add(fecha); 
		
		
		for (String sillaEnVehiculo: this.bus.getSillas()) {
			int genId = id;
			Viaje.tiquetesTodos.add(new Tiquete(genId, null, sillaEnVehiculo, this,precio, fecha));
		}
		viajes.add(this);
	}
	
	//constructor vacio 
		
	public Viaje(){
		}

		
	//gett y setter  
	
	
	public String getHora_inicio() {
		return hora_inicio;
	}
	
	public int getId() { 
		return id;
	}


	public void setId(int id) { 
		this.id = id;
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
	
	
	public Ruta getRuta() {
		return ruta;
	}

	
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	
	public boolean getEnViaje() {
		return enViaje;
	}
	
	
	public void setEnViaje(boolean enViaje) {
		this.enViaje = enViaje;
	}
	
	public static ArrayList<Viaje> getViajes() { 
		return viajes;
	}

	public static void setViajes(ArrayList<Viaje> viajes) {
		Viaje.viajes = viajes;
	}


	public static ArrayList<Tiquete> getTiquetesTodos() { 
		return tiquetesTodos;
	}


	public static void setTiquetesTodos(ArrayList<Tiquete> tiquetesTodos) { 
		Viaje.tiquetesTodos = tiquetesTodos;
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

	

	public static ArrayList<LocalDate> getFechasViaje() { 
		return fechasViaje;
	}


	
	public static void setFechasViaje(ArrayList<LocalDate> fechasViaje) {
		Viaje.fechasViaje = fechasViaje;
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
	
	
	public int getCosto() {
		return costoViaje;
	}

	
	public void setCosto(int costo) {
		this.costoViaje = costo;
	}
	
	//metodos de frecuencia
	
	public void aumentarFrecuencia(int frecuencia){	
		this.setFrecuencia(this.getFrecuencia() + frecuencia);	
		}

	public void disminuirFrecuencia(int frecuencia) {	
		this.setFrecuencia(this.getFrecuencia() - frecuencia);	}
	
	//metodos creados

	//generar tiquete 
	public static Tiquete generarTiquete(int codigo, Pasajero pasajero, String sillaTiquete, Viaje viaje, int valor, LocalDate fechaCompra) {
		return new Tiquete(codigo, pasajero, sillaTiquete, viaje, valor, fechaCompra);
	}

	//tiquete disponible

	public ArrayList<Tiquete> tiquetesDisponibles(){
		ArrayList<Tiquete> tiqueteFinal = new ArrayList<>();
		for(Tiquete tiquete : tiquetesTodos){
			if(tiquete.getEstado() == false){
				tiqueteFinal.add(tiquete);
			}
		}
		return tiqueteFinal;
	}
	
	//eliminar viaje 

	public void eliminarViaje(){
		Viaje.viajes.remove(this);
	}
	
	//eliminar tiquete 
	
	
	public void eliminarTiquete(Tiquete tiquete) {
		tiquete=null;
	}
	
	//to String 
	@Override
	public String toString() {
		return "Viaje: " +
				" Origen=" + origen +
				" Destino=" + destino +
				" FechaViaje=" + fecha +
				" Precio= "+precio;
	}

	public int getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}

}

	



