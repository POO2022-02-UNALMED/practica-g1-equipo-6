package gestorAplicacion.clasesPrincipales;

import java.io.Serializable;
import java.util.ArrayList;

public class Bus  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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

