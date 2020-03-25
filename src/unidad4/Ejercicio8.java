package unidad4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner in = new Scanner(System.in);

		/*
		 * Obtener el tamaño del vector.
		 */
		System.out.print("Tamaño del vector (entre 10 y 200): ");
		int n;
		do {
			n = Integer.valueOf(in.nextLine());
			if (n < 10 || n > 200)
				System.out.print("Tamaño incorrecto, introdúcelo de nuevo: ");
		} while (n < 10 || n > 200);

		/*
		 * Crear el vector con el tamaño especificado.
		 */
		int[] vector = new int[n];

		/*
		 * Llenar el vector con valores aleatorios.
		 */
		for (int i = 0; i < n; i++)
			vector[i] = random.nextInt(301) - 100;
		
		/*
		 * Calcular la suma
		 */
		int suma = 0;
		int noSumados = 0;
		int i=0;
		while (i < n) {
			int numero = vector[i++];
			if (numero == 13) {
				int sumaParcial = 13;
				int j = 13;
				while (j-- > 0 && i < n)
					sumaParcial += vector[i++];
				if (sumaParcial == 7)
					suma += sumaParcial;
				else
					noSumados += 13 - j;
			}
			else
				suma += numero;
		}
		
		/*
		 * Mostrar resultados
		 */
		System.out.println(Arrays.toString(vector));
		System.out.printf("Suma: %d\nNo sumados: %d", suma, noSumados);
		
		in.close();
	}

}
