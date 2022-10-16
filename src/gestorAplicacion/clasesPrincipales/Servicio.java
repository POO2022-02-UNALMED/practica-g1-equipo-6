package gestorAplicacion.clasesPrincipales;

public enum Servicio {
	
	MALETAS_EXTRA(5000),
	ALMOHADA(2500),
	AURICULARES(3000),
	VIAJAR_CON_MASCOTA(10000);
	
	private final int precio;
	
	Servicio(int precio) {
		this.precio=precio;
	}

	public int getPrecio() {
		return precio;
	}
	
	
}
