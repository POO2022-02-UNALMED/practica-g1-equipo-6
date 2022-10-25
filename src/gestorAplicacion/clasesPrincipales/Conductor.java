package gestorAplicacion.clasesPrincipales;

import java.io.Serializable;
import java.util.ArrayList;

public class Conductor implements Serializable {
	
	private static final long serialVersionUID = 2L;
	
	private String nombre;
	private long cedula;
	private long celular;
	private int sueldo;
	private boolean disponible;
	private static ArrayList<Conductor> conductores = new ArrayList<>();
	
	public Conductor(String nombre, long cedula, long celular, int sueldo) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.celular = celular;
		this.sueldo = sueldo;
		setDisponible(true);
        Conductor.conductores.add(this);
	}

	//GETs y SETs
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public long getCedula() {
		return cedula;
	}
	
	public void setCedula(int cedula) {
		this.cedula = cedula;
	} 
	
	
	public long getCelular() {
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

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	//Metodos
	
}