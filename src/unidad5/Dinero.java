package unidad5;

public enum Dinero {
	CINCUENTA(50), VEINTE(20), DIEZ(10), CINCO(5),  DOS(2),  UNO(1);
	
	private int valor;
	
	private Dinero(int valor) {
		this.valor = valor;
	}
	
	public int getValor() {
		return valor;
	}
}
