package gestorAplicacion.clasesPrincipales;

import java.io.Serializable;

public class Pasajero  implements Serializable  {
	
	private static final long serialVersionUID = 4L;
	private String nombre;
	private String apellido;
	private Integer cedula;
	private int edad;
	private String correo;
	public Pasajero(String nombre, String apellido, Integer cedula, int edad, String correo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.edad = edad;
		this.correo = correo;
	}
	
	// -----GETTERS AND SETTERS----- 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getCedula() {
		return cedula;
	}
	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	} 
}
