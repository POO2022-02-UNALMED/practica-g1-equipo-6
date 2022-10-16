package gestorAplicacion.clasesPrincipales;

import java.io.Serializable;
import java.util.ArrayList;

public class Ruta implements Serializable{
	
	private static final long serialVersionUID = 5L;
	
	private int idRuta;
    private String nombre; 
    private static  ArrayList<Ruta> rutas;
    private int numVisitantes;
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

    public static void quitarRuta(String ruta) {
    	if (!rutas.isEmpty()) {
			for (Ruta c : rutas) {
				if (c.nombre.equals(ruta)) {
					rutas.remove(c); //No corre en una clase afuera, analizar m�todo
				}
			}
		}
	}
    
    // hV es la ruta con su respectivo historico de viajes
    //Lo mejor ser�a implementar un toString para retornar toda la ruta y es mejor que sea un m�todo de clase?
    public static String historicoViajes(String nomRutas) {
    	String hV = "";
    	
    	if (!rutas.isEmpty()) {
    		for(Ruta c: rutas) {
    			if (c.nombre.equals(nomRutas)) {
    				hV = "La Ruta " + c.nombre + "a tenido " + c.numVisitantes; //Numero de visitantes es de tipo String mirar que compile
    			}else {
    				hV = "La ruta " +  nomRutas + " no existe dentro de nuestra base de datos";
    			}
    		}
    		
    	}else {
    		hV = "La ruta " + nomRutas + "no existe";	
    	}
		return hV;
    } 
    
    public String historicoViajes() {  
    	
    	String hV = "";
    	if (!rutas.isEmpty()) {
    		for(Ruta c: rutas) {
    			if (c.nombre.equals(this.nombre)) {
    				hV = "La ruta " + c.nombre + "a tenido " + c.numVisitantes;
    			}else {
    				hV = "La ruta " +  this.nombre + " no existe dentro de nuestra base de datos";
    			}
    		}
    		
    	}else {
    		hV = "La ciudad " + this.nombre + "no existe";	
    	}
		return hV;
    }
    
	public void anadirVisitantes(int numVisitantes) {
		this.numVisitantes += numVisitantes;
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
    
	public int getNumVisitantes() {
		return numVisitantes;
	}
	
	public static ArrayList<Ruta> getRutas(){ 
		return rutas;	
	}
	
	@Override
	public String toString() {
		return "Ruta: "+nombre +
				" idRuta: "+ idRuta;
	}
}
