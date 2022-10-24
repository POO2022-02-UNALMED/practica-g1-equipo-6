package gestorAplicacion.clasesPrincipales;

import java.io.Serializable;
import java.util.ArrayList;
public class Ruta implements Serializable {
	
	private static final long serialVersionUID = 5L;
	
	private int idRuta;
    private String nombre; 
    private String origen;
    private String destino;
    private int km;
    private static  ArrayList<Ruta> rutas;
	static {
		rutas = new ArrayList<Ruta>();
	}
	
     /*Desde el constructor se valida para agregar una nueva ruta que no exista previamente y cuando esto pase no
      se crea la instancia
     */

    public Ruta(int idRuta, String nombre) { 
    	this.idRuta = idRuta;
    	this.nombre = nombre;
    	rutas.add(this); 
    }
    public Ruta(String origen, String destino, int km) {
    	this.origen=origen;
    	this.destino=destino;
    	this.km=km;
    }

    public static void quitarRuta(String ruta) {
    	if (!rutas.isEmpty()) {
			for (Ruta c : rutas) {
				if (c.nombre.equals(ruta)) {
					rutas.remove(c); //No corre en una clase afuera, analizar m�todo
				}
			}
		}
	}
    
	
	public void setIdRuta(int idRuta) {	
		this.idRuta = idRuta;}
	public int getIdRuta() {
		return idRuta;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
	public static ArrayList<Ruta> getRutas(){ 
		return rutas;	
	}
	
	
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	@Override
	public String toString() {
		return "Ruta: "+nombre +
				" idRuta: "+ idRuta;
	}
}
