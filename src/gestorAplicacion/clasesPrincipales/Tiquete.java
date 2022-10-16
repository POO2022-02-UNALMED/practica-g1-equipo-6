package gestorAplicacion.clasesPrincipales;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tiquete implements Serializable {
		
		private static final long serialVersionUID = 8L;
		private int codigo;
		protected Pasajero pasajero;
		protected Bus sillaTiquete;
		protected Viaje viaje;
		protected int valor;
		protected LocalDate fechaCompra;
		private boolean estado;		
		private static ArrayList<Tiquete> tiquetes;

		static {
			tiquetes = new ArrayList<Tiquete>();
		}

	public  Tiquete(){}

	public Tiquete(Bus sillaTiquete, Viaje viaje, int valor) {
		this.sillaTiquete = sillaTiquete;
		this.viaje = viaje;
		this.estado = false;
		this.valor = valor;
	}

	public Tiquete(int codigo, Pasajero pasajero, Bus sillaTiquete, Viaje viaje, int valor, LocalDate fechaCompra) {
		this.codigo = codigo;
		this.pasajero = pasajero;
		this.sillaTiquete = sillaTiquete;
		this.viaje = viaje;
		this.valor = valor;
		this.estado = false;
		this.fechaCompra = fechaCompra;
		Tiquete.tiquetes.add(this);
	}


	public Bus getSillaTiquete() {
		return sillaTiquete;}

	public Viaje getViaje() {
		return viaje;	}

	public Pasajero getUsuario() {
		return pasajero;}

	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public void setComprador(Pasajero comprador) {
		this.pasajero = comprador;}

	public int getValor() {	
		return valor;}

	public Pasajero getComprador() {	
		return pasajero;}

	public void setFechaCompra(LocalDate fechaCompra) {	
		this.fechaCompra = fechaCompra;	}

	public static ArrayList<Tiquete> getTiquetes() {
		return tiquetes;	}

	@Override
	public String toString() {
		return "Tiquete = " +"ID : " + codigo + ", SILLA :" + sillaTiquete + "\n" +
				"	VIAJE =" + viaje + 
				", valor : " + valor +
				", fechaCompra : " + fechaCompra;
	}
}




