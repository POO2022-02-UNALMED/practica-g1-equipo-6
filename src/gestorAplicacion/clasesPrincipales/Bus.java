package gestorAplicacion.clasesPrincipales;
import java.util.ArrayList;

public class Bus {
	String modelo;
	String placa;
	int capacidad;
	//atributo_interseccion
	private ArrayList<Empresa> empresa = new ArrayList<Empresa>();
	//get&set_Empresa
	public ArrayList<Empresa> getEmpresa() {
		return empresa;
	}
	public void setEmpresa(ArrayList<Empresa> empresa) {
		this.empresa = empresa;
	}
	/**Metodo adquirir servicio raro**/
}

