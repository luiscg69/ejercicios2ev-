package unidad4;

import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		System.out.println("Introduce 10 nombres (1 por línea)");
		String [] nombres = new String[10];
		Scanner in = new Scanner(System.in);
		for (int i=0; i<nombres.length; i++)
			nombres[i] = in.nextLine();
		System.out.println("El nombre más largo es:");
		System.out.println(cadenaMasLarga(nombres));
		in.close();
	}
	
	static String cadenaMasLarga(String [] v) {
		int iMax = 0;
		for (int i=1; i<v.length; i++)
			if (v[i].length() > v[iMax].length())
				iMax = i;
		return v[iMax];
	}

}
