package gestorAplicacion.clasesPrincipales;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Bus {
	private Ruta rutaBus;
	protected int km;
	protected int precio;
	protected int capacidad;
	private int codigo; 
	private static ArrayList<String> sillaNoDisponibles=new ArrayList<String>();
	protected String modelo;
	protected String placa;
	protected Conductor conductor;
	private static  ArrayList<Bus> buses = new ArrayList<>(); //Agregue este atributo valen
	private ArrayList<String> sillas;
	//Constructor
	public Bus(String modelo, String placa, Conductor conductor, ArrayList<String> sillas){
		this.modelo=modelo;
		this.placa=placa;
		this.conductor=conductor;
		this.sillas=sillas;
		Bus.buses.add(this);
	}
	public Bus(String modelo, String placa, Conductor conductor, ArrayList<String> sillas,int capacidad){
		this.modelo=modelo;
		this.placa=placa;
		this.conductor=conductor;
		this.sillas=sillas;
		this.capacidad=capacidad;
		Bus.buses.add(this);
	}
	//get&set buses
	public static ArrayList<Bus> getBuses() {
		return buses;
	}
	public static void setBuses(ArrayList<Bus> buses) {
		Bus.buses = buses;
	}
	//get&set modelo
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo=modelo;
	}
	//get&set placa
	public String getPlaca() {
		return modelo;
	}
	public void setPlaca(String placa) {
		this.placa=placa;
	}
	//get&set conductor
	public Conductor getConductor() {
		return conductor;
	}
	public void setConductor(Conductor conductor) {
		this.conductor=conductor;
	}
	
	//get&set sillas
	public ArrayList<String> getSillas() { //Agregue st y get de sillas y de buses
		return sillas;
	}
	public void setSillas(ArrayList<String> sillas) {
		this.sillas = sillas;
	}
	//get&set capacidad
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad=capacidad;
	}
	//get&set sillanodisponible
	public static ArrayList<String> getSillaNoDisponibles() {
		return sillaNoDisponibles;
	}

	public static void setSillaNoDisponibles(String sillaNoDisponibles) {
		Bus.sillaNoDisponibles.add(sillaNoDisponibles);
	}
	//get&set km
	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}
	//get&set precio
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public static void setSillaNoDisponibles(ArrayList<String> sillaNoDisponibles) {
		Bus.sillaNoDisponibles = sillaNoDisponibles;
	}
	//metodos abstractos
	protected abstract void sillasDisponibles();//params Viaje viaje
	protected abstract String sillaTiquete(Tiquete tiquete);
	
	
}
