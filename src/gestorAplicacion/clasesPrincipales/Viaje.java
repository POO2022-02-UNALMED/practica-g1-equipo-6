package gestorAplicacion.clasesPrincipales;
import java.util.ArrayList;
import java.time.LocalDate;
import java.io.Serializable;
import gestorAplicacion.clasesPrincipales.Ruta;

public class Viaje implements Serializable{
	
	private static final long serialVersionUID= 8L;
	
	private int id;//Agregue este id valen
	private String hora_inicio;
	private String hora_llegada;
	private String origen;
	private String destino; //Agregue destino y origen valen 
	//private Ruta ruta; //quite ruta valen
	private LocalDate fecha;
	private int precio;
	//private Conductor conductor; Quite conductor valen
	private Bus bus;
	private boolean enViaje;
	private static ArrayList<Viaje> viajes= new ArrayList<Viaje>();
	private static ArrayList<String> lugares= new ArrayList<String>();
	private static ArrayList<Tiquete> tiquetesTodos;

//contructor

	public Viaje(int id,String hora_inicio, String hora_llegada, LocalDate fecha, int precio, 
			String origen, String destino,Bus bus, Boolean enViaje ) {
		this.hora_inicio= hora_inicio;
		this.hora_llegada= hora_llegada;
		this.fecha= fecha;
		this.origen= origen; //Agregue id , origen y destino y quite conductor y ruta valen
		this.destino=destino;
		//this.origen= this.ruta.getOrigen();
		//this.destino= this.ruta.getDestino();
		//this.ruta= ruta;//Ruta debe crear el destino y el origen sino debe tenerlas el viaje 
		this.precio= precio;
		//this.conductor= conductor;
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
//	public Conductor getConductor() {
//		return conductor;
//	}
//	public void setConductor(Conductor conductor) {
//		this.conductor = conductor;
//	}
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
	

	//metodos 

	public void sillasDisponibles() {
		for(Tiquete tiquete : tiquetesTodos){
			if(tiquete.getEstado() == false){
				System.out.println("la silla: "+tiquete.getSillaTiquete()+"esta disponible");
				}
			}
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
	
	public static ArrayList<Tiquete> gettiquetesTodos(){
		return tiquetesTodos;
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
	
	public void eliminarTiquete(Tiquete tiquete) {
		tiquete=null;
	}


}

	



