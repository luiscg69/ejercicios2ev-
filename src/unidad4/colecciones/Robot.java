package unidad4.colecciones;

public class Robot {
	private String nombre;
	private int tiempoProceso;
	private int crono;
	private String producto;
	
	public Robot(String nombre, int tiempo) {
		this.nombre = nombre;
		this.tiempoProceso = tiempo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getTiempoProceso() {
		return tiempoProceso;
	}



	public void addProducto(String producto) {
		this.producto = producto;
		crono = tiempoProceso;
	}
	
	public boolean procesar() {
		if (producto == null)
			return false;
		if (--crono == 0) {
			producto = null;
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		if (producto == null)
			return nombre + " inactivo";
		else
			return nombre + " procesando: " + producto + " - " + crono + " segundos de " + tiempoProceso;
	}
	
}
