package unidad5;

public class Naipe {
	
	private Palo palo;
	private Rango rango;
	private int valor;
	
	public Naipe(Palo palo, Rango rango, int valor) {
		this.palo = palo;
		this.rango = rango;
		this.valor = valor;
	}

	public Naipe(Palo palo, Rango rango) {
		this(palo, rango, rango.ordinal() + 1);
	}
	
	public boolean isFigura() {
		return rango.isFigura();
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Palo getPalo() {
		return palo;
	}

	public Rango getRango() {
		return rango;
	}
	
	@Override
	public String toString() {
		return rango.getSimbolo() + palo.getSimbolo();
	}
	
}
