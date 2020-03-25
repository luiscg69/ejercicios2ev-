package unidad5;

public enum Palo {
	
	CLOVERS('\u2663'), HEARTS('\u2665'), DIAMONDS ('\u2666'), SPADES('\u2660');
	
	private Palo(char simbolo) {
		this.simbolo = simbolo;
	}
	
	private char simbolo;

	public char getSimbolo() {
		return simbolo;
	}
	
}
