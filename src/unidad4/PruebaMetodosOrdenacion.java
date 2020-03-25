package unidad4;

import java.util.Arrays;
import java.util.Random;

public class PruebaMetodosOrdenacion {

	static Random r = new Random();

	public static void main(String[] args) {
		int [] v = new int[30];
		
		llenarVector(v);
		System.out.println("Inserción directa:");
		System.out.println(Arrays.toString(v));
		MetodosOrdenacion.insercionDirecta(v);
		System.out.println(Arrays.toString(v));
		
		llenarVector(v);
		System.out.println("\nSelección directa:");
		System.out.println(Arrays.toString(v));
		MetodosOrdenacion.seleccionDirecta(v);
		System.out.println(Arrays.toString(v));
		
		llenarVector(v);
		System.out.println("\nIntercambio directo:");
		System.out.println(Arrays.toString(v));
		MetodosOrdenacion.intercambioDirecto(v);
		System.out.println(Arrays.toString(v));
	}

	static void llenarVector(int [] v) {
		for (int i=0; i<v.length; i++)
			v[i] = r.nextInt(100);
	}
}
