package unidad4;

import java.util.Arrays;
import java.util.Random;

public class Ejercicio9 {

	public static void main(String[] args) {
		Random r = new Random();
		
		/*
		 * Crear vector
		 */
		
		int [] v = new int[r.nextInt(490) + 10];
		for (int i = 0; i < v.length; i++)
			v[i] = r.nextInt(200) - 100;
		
		/*
		 * Buscar y contar secuencias de números repetidos
		 */
		
		int secuencias = 0;
		boolean secuencia = false;
		for (int i=1; i<v.length; i++)
			if (v[i] == v[i-1]) {
				if (!secuencia) {
					secuencias++;
					secuencia = true;
				}
			}
			else
				if (secuencia)
					secuencia = false;
		
		/*
		 * Mostrar resultados
		 */
		
		if (v.length <= 50)
			System.out.println(Arrays.toString(v));
		System.out.printf("Número de secuencias de números repetidos: %d", secuencias);
	}

}
