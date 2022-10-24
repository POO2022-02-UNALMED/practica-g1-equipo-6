package gestorAplicacion.clasesHerencia;
import java.util.ArrayList;


import gestorAplicacion.clasesPrincipales.*;

public class Ejecutivo extends Bus {
	private final int precio=500;//precio por km
	int codigo;
	public static ArrayList<Ejecutivo> ejecutivos = new ArrayList<Ejecutivo>();
	
	//constructor
	public Ejecutivo(String modelo, String placa, Conductor conductor,int capacidad,ArrayList<String> sillas) {
		super(modelo,placa,conductor,sillas);
		this.capacidad=capacidad;
		this.codigo=150;
		Ejecutivo.ejecutivos.add(this);
	}
	
	//get_precio
	public int getPrecio() {
		return precio;
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
