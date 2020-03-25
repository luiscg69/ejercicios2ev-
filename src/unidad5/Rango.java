package unidad5;

public enum Rango {
	AS("A"), DOS("2"), TRES("3"), CUATRO("4"), CINCO("5"),
	SEIS("6"), SIETE("7"), OCHO("8"), NUEVE("9"), DIEZ("10"),
	JAKE("J"), QUEEN("Q"), KING("K");
	
	private String simbolo;
	
	private Rango(String simbolo)  {
		this.simbolo = simbolo;
	}
	
	public String getSimbolo() {
		return simbolo;
	}

	public boolean isFigura() {
		return (this == AS || this == JAKE ||
				this == QUEEN || this == KING);
	}
}
