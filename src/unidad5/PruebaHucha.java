package unidad5;

public class PruebaHucha {
	
	public static void main(String[] args) {
		Hucha hucha = new Hucha(9231);
		System.out.println(hucha);
		System.out.println(hucha.retirar(100));
		System.out.println(hucha);
		hucha.add(Dinero.VEINTE, 3);
	}
	
}
