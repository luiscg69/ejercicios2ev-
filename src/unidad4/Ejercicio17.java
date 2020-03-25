package unidad4;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio17 {
	
	static Random r = new Random();

	public static void main(String[] args) {
		int [] v1 = new int[r.nextInt(91) + 10];
		int [] v2 = new int[r.nextInt(91) + 10];
		llenarVector(v1);
		Arrays.sort(v1);
		llenarVector(v2);
		Arrays.sort(v2);
		int [] v = mezclar(v1, v2);
		System.out.println(Arrays.toString(v1));
		System.out.println(Arrays.toString(v2));
		System.out.println(Arrays.toString(v));
	}

	static int [] mezclar(int [] v1, int [] v2) {
		int [] v = new int[v1.length + v2.length];
		int j=0, k = 0;
		for (int i=0; i<v.length; i++) {
			if (j < v1.length && k < v2.length) {
				if (v1[j] < v2[k])
					v[i] = v1[j++];
				else
					v[i] = v2[k++];
			}
			else if (j < v1.length)
				v[i] = v1[j++];
			else if (k < v2.length)
				v[i] = v2[k++];
		}
		return v;
	}
	
	static void llenarVector(int [] v) {
		for (int i=0; i<v.length; i++)
			v[i] = r.nextInt(100);
	}
	
}
