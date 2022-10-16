package gestorAplicacion.clasesPrincipales;


public class Viaje {
	private String hora_inicio;
	private String hora_llegada;
	//private String origen;
	private Ruta ruta;
	//private String destino;
	private String fecha;
	private int precio;
	private Conductor conductor;
	private Bus bus;
	private Boolean enViaje;

//contructor

	public Viaje(String hora_inicio, String hora_llegada, String fecha, int precio,Ruta ruta, Conductor conductor,
	Bus bus, Boolean enViaje ) {
		this.hora_inicio= hora_inicio;
		this.hora_llegada= hora_llegada;
		//this.fecha= fecha;
		//this.origen= 
		this.ruta= ruta;
		this.precio= precio;
		this.conductor= conductor;
		this.enViaje = true;
		this.bus= bus;
		
		int j=0;
		for (String sillaEnVehiculo: this.bus.getSillas()) {
			this.allTiquetes.add(new Tiquete(j, null, sillaEnVehiculo, this, tipoSilla, fechaViaje));
			j++;
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
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
	public Boolean getEnViaje() {
		return enViaje;
	}
	public void setEnViaje(Boolean enViaje) {
		this.enViaje = enViaje;
	}

	//metodos 

	public String sillasDisponibles() {
		
	}

	/*public int asignarsilla() {
		return c;
	}

	public Tiquete generarTiquete() {	
	
	}

	public Tiquete eliminarTiquete() {
	
	} */


}

	



