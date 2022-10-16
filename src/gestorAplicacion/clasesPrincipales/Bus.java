package gestorAplicacion.clasesPrincipales;
import java.util.ArrayList;

public class Bus {
	String modelo;
	String placa;
	int capacidad;
	//atributo_interseccion
	private ArrayList<Empresa> empresa = new ArrayList<Empresa>();
	//Constructor
	Bus(String modelo, String placa, int capacidad, Empresa empresa){
		this.modelo=modelo;
		this.placa=placa;
		this.capacidad=capacidad;
		this.empresa.add(empresa);
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
	/**Metodo adquirir servicio raro**/
}
