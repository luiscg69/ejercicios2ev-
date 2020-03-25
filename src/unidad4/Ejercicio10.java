package unidad4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner in = new Scanner(System.in);

		/*
		 * Obtener el tama�o del vector.
		 */
		
		System.out.print("Tama�o del vector (entre 10 y 20): ");
		int n;
		do {
			n = Integer.valueOf(in.nextLine());
			if (n < 10 || n > 20)
				System.out.print("Tama�o incorrecto, introd�celo de nuevo: ");
		} while (n < 10 || n > 20);

		/*
		 * Crear el vector con el tama�o especificado.
		 */
		
		int[] vector = new int[n];

		/*
		 * Llenar el vector con valores aleatorios.
		 */
		
		for (int i = 0; i < n; i++)
			vector[i] = random.nextInt(100);

		/*
		 * Calcular la m�nima diferencia entre dos valores adjacentes.
		 */
		
		int difMin = Integer.MAX_VALUE;
		int dif;
		for (int i=1; i<vector.length; i++) {
			dif = vector[i] - vector[i - 1];
			if (dif < difMin)
				difMin = dif;
		}
		
		/*
		 * Mostrar resultado
		 */
		
		System.out.println(Arrays.toString(vector));
		System.out.printf("Diferencia m�nima entre dos valores adjacentes: %d", difMin);
		
		in.close();
	}

}
