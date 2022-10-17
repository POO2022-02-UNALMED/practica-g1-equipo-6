package gestorAplicacion.clasesPrincipales;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bus {
	String modelo;
	String placa;
	int capacidad;
	private ArrayList<String> sillas; //Agregue este atributo valen
	private static  ArrayList<Bus> buses = new ArrayList<>(); //Agruegue este atributo valen
	//atributo_interseccion
	private ArrayList<Empresa> empresa = new ArrayList<Empresa>();
	//Constructor
	Bus(String modelo, String placa, int capacidad, Empresa empresa,ArrayList<String> sillas){
		this.modelo=modelo;
		this.placa=placa;
		this.capacidad=capacidad;
		this.empresa.add(empresa);
		this.sillas=sillas;
		Bus.buses.add(this);
	}
	Bus(String modelo, String placa, int capacidad){
		this.modelo=modelo;
		this.placa=placa;
		this.capacidad=capacidad;
	}
	Bus(){
	
	}
	//get&set_Empresa
	public ArrayList<Empresa> getEmpresa() {
		return empresa;
	}
	public void setEmpresa(ArrayList<Empresa> empresa) {
		this.empresa = empresa;
	}

	public ArrayList<String> getSillas() { //Agregue st y get de sillas y de buses
		return sillas;
	}

	public void setSillas(ArrayList<String> sillas) {
		this.sillas = sillas;
	}
	public static ArrayList<Bus> getBuses() {
		return buses;
	}

	public static void setBuses(ArrayList<Bus> buses) {
		Bus.buses = buses;
	}


	//Metodo_adquirir
	/**public static Servicio adquirirServicio(){
		return new Servicio();
		}**/

}
