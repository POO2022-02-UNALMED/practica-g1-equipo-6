package gestorAplicacion.clasesPrincipales;

public class Ruta {
	private String partida;
	private String[] paradas;
	private String destino;
	
	public Ruta(String partida, String[] paradas, String destino) {
		this.partida = partida;
		this.paradas = paradas;
		this.destino = destino;
		
	}
	// holi
	
	public String[] getParadas() {
		return paradas;}
	public void setParadas(String[] paradas) {
		this.paradas = paradas;}
	
	public String getPartida() {
		return partida;}
	public void setPartida(String partida) {
		this.partida = partida;}
	
	public String getDestino() {
		return destino;}
	public void setParadas(String destino) {
		this.destino = destino;}
	
	public String crearRuta() {
		
		return ;
	}
}
