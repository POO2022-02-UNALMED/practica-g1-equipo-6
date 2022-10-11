package gestorAplicacion.clasesPrincipales;

public class Tiquete {
	private String codigo;
	private Viaje viaje;
	private Ruta ruta;
	
	public Tiquete (String codigo, Viaje viaje, Ruta ruta) {
		this.codigo = codigo;
		this.viaje = viaje;
		this.ruta = ruta;
		
	}
	
	public String getCodigo() {
		return codigo;}
	public void setCodigo(String codigo) {
		this.codigo = codigo;}
	
	public String consultarTiquete() {
		
		return ;
	}
}
