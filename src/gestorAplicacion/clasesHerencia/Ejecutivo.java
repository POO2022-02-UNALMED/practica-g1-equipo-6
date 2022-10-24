package gestorAplicacion.clasesHerencia;
import java.util.ArrayList;


import gestorAplicacion.clasesPrincipales.*;

public class Ejecutivo extends Bus {
	private final int precioKm=500;//precio por km
	int codigo;
	private final int capacidad=26;
	public static ArrayList<Ejecutivo> ejecutivos = new ArrayList<Ejecutivo>();
	
	//constructor
	public Ejecutivo(String placa, Conductor conductor,ArrayList<String> sillas) {
		super(placa,conductor,sillas);
		this.codigo=150;
		Ejecutivo.ejecutivos.add(this);
	}
	
	public Ejecutivo() {
		
	}
	
	//get_precio
	public int getPrecioKm() {
		return precioKm;
	}
	//get&set codigo
	public int getCodigo() { //desde aqui agregue 
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	@Override
	public void sillasDisponibles() {
		for(Tiquete tiquete : Viaje.getTiquetesTodos()){
			if(tiquete.getEstado() == false){
				System.out.println("la silla: "+tiquete.getSillaTiquete()+"esta disponible");
				}
			}
		}
	@Override
	public String sillaTiquete(Tiquete tiquete) {
		return tiquete.getSillaTiquete();
	}
}
