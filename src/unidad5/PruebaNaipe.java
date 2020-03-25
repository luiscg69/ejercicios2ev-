package unidad5;

public class PruebaNaipe {

	public static void main(String[] args) {
		Naipe naipe = new Naipe(Palo.CLOVERS, Rango.AS);
		System.out.println(naipe.isFigura());
		System.out.println(naipe);
		Mazo mazo = new Mazo();
		System.out.println(mazo);
	}

}
