package gestorAplicacion.clasesPrincipales;
import java.util.ArrayList;

public class Ejecutivo extends Bus {
	private final int precio=500;//precio por km
	int codigo;
	
	//constructor
	public Ejecutivo(String modelo, String placa, Conductor conductor, int capacidad, ArrayList<String> sillas) {
		super(modelo,placa,conductor,sillas);
		this.capacidad=capacidad;
		this.codigo=150;
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
		for(Tiquete tiquete : Viaje.gettiquetesTodos()){
			if(tiquete.getEstado() == false){
				System.out.println("la silla: "+tiquete.getSillaTiquete()+"esta disponible");
				}
			}
		}
	public String sillaTiquete(Tiquete tiquete) {
		return tiquete.getSillaTiquete();
	}
}
