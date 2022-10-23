package gestorAplicacion.clasesPrincipales;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Tiquete implements Serializable {
		
		private static final long serialVersionUID = 7L;
		
		private int codigo;
		protected Pasajero pasajero;
		protected String sillaTiquete; //cambie tipo bus por tipo string, se cambio la visibilidad :(
		protected Viaje viaje;
		protected int valor;
		protected LocalDate fechaCompra;
		private boolean estado;		
		private static ArrayList<Tiquete> tiquetes;
		private static ArrayList<Tiquete> tiquetesComprados; //Añadi este nuevo array valen

		static {
			tiquetes = new ArrayList<Tiquete>();
			tiquetesComprados= new ArrayList<Tiquete>();//se anañdio este valen
		}

	public  Tiquete(){}

	public Tiquete(String sillaTiquete, Viaje viaje, int valor) {
		this.sillaTiquete = sillaTiquete;
		this.viaje = viaje;
		this.estado = false;
		this.valor = valor;
	}

	public Tiquete(int codigo, Pasajero pasajero, String sillaTiquete, Viaje viaje, int valor, LocalDate fechaCompra) {
		this.codigo = codigo;
		this.pasajero = pasajero;
		this.sillaTiquete = sillaTiquete;
		this.viaje = viaje;
		this.valor = valor;
		this.estado = false;
		this.fechaCompra = fechaCompra;
		Tiquete.tiquetes.add(this);
	}
	

	public static Tiquete asignarTiquete(Pasajero comprador, Tiquete tiquete){
	    tiquete.setPasajero(comprador);
	    tiquete.setFechaCompra(LocalDate.now());
	    tiquete.setEstado(true);
	    tiquete.getViaje().getDestino();
	    tiquetesComprados.add(tiquete);//Añadi este valen
	    return tiquete;
	}


	public String getSillaTiquete() {
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

	public void setPasajero (Pasajero comprador) {
		this.pasajero = comprador;}
	
	public void setValor(int valor) { //Agregue esto valen
		this.valor=valor;
	}

	public int getValor() {	
		return valor;}

	public Pasajero getPasajero() {	
		return pasajero;}

	public void setFechaCompra(LocalDate fechaCompra) {	
		this.fechaCompra = fechaCompra;	}

	public static ArrayList<Tiquete> getTiquetes() {
		return tiquetes;	}
	
	public int getCodigo() { //Añadi este valen
		return codigo;
	}

	public void setCodigo(int codigo) { //Añadi este valen
		this.codigo = codigo;
	}

	public static ArrayList<Tiquete> getTiquetesComprados() { //añadi este valen
		return tiquetesComprados;
	}

	public static void setTiquetesComprados(ArrayList<Tiquete> tiquetesComprados) {//añadi valen
		Tiquete.tiquetesComprados = tiquetesComprados;
	}
	

	public void setSillaTiquete(String sillaTiquete) { //agregue esto valen
		this.sillaTiquete = sillaTiquete;
	}

	@Override
	public String toString() {
		return "************************************"+ "\r\n"+
	            "Su compra se ha realizado con exito"+"\r\n"+
				"Gracias por confiar en nosotros"+"\r\n"+
	            "************************************"+"\r\n"+
				"Tiquete No: " + codigo+"\r\n" + pasajero+"\r\n"+
	            "Silla: " + sillaTiquete + "\n"+ 
				"Origen: "+viaje.getOrigen()+"\n"+
				"Destino: "+viaje.getDestino()+"\n"+
				"FechaCompra: " + fechaCompra+"\r\n"+
				"Precio:"+valor;
	}
}




