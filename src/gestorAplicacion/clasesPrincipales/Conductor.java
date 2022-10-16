package gestorAplicacion.clasesPrincipales;

import java.io.Serializable;
import java.util.ArrayList;

public class Conductor implements Serializable {
	
	private static final long serialVersionUID = 2L;
	
	private String nombre;
	private int cedula;
	private int celular;
	private int sueldo;
	private static ArrayList<Conductor> conductores = new ArrayList<>();
	
	public Conductor(String nombre, int cedula, int celular, int sueldo) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.celular = celular;
		this.sueldo = sueldo;
        Conductor.conductores.add(this);
	}

	//GETs y SETs
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getCedula() {
		return cedula;
	}
	
	public void setCedula(int cedula) {
		this.cedula = cedula;
	} 
	
	
	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public static ArrayList<Conductor> getConductores() {
		return conductores;
	}

	public static void setConductores(ArrayList<Conductor> conductores) {
		Conductor.conductores = conductores;
	}

	//Metodos
	
}

