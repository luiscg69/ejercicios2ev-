package unidad4;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Tamaño del vector: ");
		int [] v = new int[in.nextInt()];
		System.out.println("Introduce %d números enteros: ");
		for (int i=0; i<v.length; i++)
			v[i] = in.nextInt();
		Integer c = centro(v);
		System.out.print("Centro del vector: ");
		System.out.println(c == null ? "no tiene centro" : c);
		in.close();
	}
	
	static Integer centro(int [] v) {
		int izda;
		int dcha;
		for (int c=1; c<v.length-1; c++) {
			izda = 0;
			for (int i=0; i<c; i++)
				izda += (c - i) * v[i];
			dcha = 0;
			for (int j=c+1; j<v.length; j++)
				dcha += (j - c) * v[j];
			if (izda == dcha)
				return c;
		}
		return null;
	}

}
