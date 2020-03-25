package unidad4.colecciones;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio1 {

//	public static void main(String[] args) {
//		Set<String> nombres = new HashSet<>();
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		for (int i=0; i<n; i++)
//			nombres.add(in.next());
//		System.out.println(nombres);
//	}
	
	public static void main(String[] args) {
		List<String> nombres = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i=0; i<n; i++) {
			String nombre = in.next();
			if (!nombres.contains(nombre))
				nombres.add(nombre);
		}
		System.out.println(nombres);
	}

}
