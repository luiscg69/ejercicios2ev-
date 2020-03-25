package unidad4;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {

		/*
		 * Created by: Luis Cortés Date:: 26-01-2020
		 */

		/*
		 * 7. En el método main de una clase Java llamada Vectores2 escribe un programa
		 * que cree un vector de números enteros de un tamaño especificado por el
		 * usuario entre 10 y 1.000.000 de elementos. El vector se llenará con números
		 * aleatorios comprendidos entre -999.999 y 1.000.000 sin repetir ninguno. A
		 * continuación, mostrará el tamaño del vector, el tiempo empleado en llenarlo,
		 * la diferencia entre el menor y el mayor de los números almacenados en el
		 * vector y el tiempo empleado en obtener dicha diferencia.
		 */

		Scanner input = new Scanner(System.in);

		int Tvector;

		do {

			System.out.print("Por favor introduzca el tamaño del vector que desee crear (entre 10 y 1000000): ");

			Tvector = input.nextInt();

		} while (Tvector < 10 || Tvector > 1000000);

		int[] vectorO = new int[Tvector];

		long TiempoI = System.nanoTime();

		Random r = new Random();

		for (int indiceV = 0; indiceV < vectorO.length; indiceV = indiceV + 1) {

			int naleatorio = ((r.nextInt(2000000)) - 999999);

			for (int indiceA = 0; indiceA <= indiceV; indiceA = indiceA + 1) {

				if (vectorO[indiceA] == naleatorio) {

					indiceA = indiceV + 1;
					indiceV = indiceV - 1;

				} else if (indiceA == indiceV) {
					vectorO[indiceV] = naleatorio;
				}

			}
		}

		long TiempoF = System.nanoTime();

		System.out.println("El vector tiene un tamaño de " + vectorO.length + " elementos.");

		long tiempo1s = (TiempoF - TiempoI)/1000000 ;
		
		System.out.print("El tiempo empleado en llenar el vector ha sido de ");

		if (tiempo1s > 0) {
			
			
			if (tiempo1s > 60) {
				
							
			System.out.print(tiempo1s/60 +" minutos, "  + tiempo1s%60 +" segundos, ");

			} else {

			System.out.print(tiempo1s + " segundos, ");

		}

		}	
			
			
			
			
		long TiempoDI = System.nanoTime();

		int valorMa = -999999;
		int valorMi = 1000000;

		for (int x = 0; x < vectorO.length; x = x + 1) {

			if (vectorO[x] > valorMa) {
				valorMa = vectorO[x];
			}
			if (vectorO[x] < valorMi) {
				valorMi = vectorO[x];
			}
		}

		int diferenciavalorMaMi = valorMa - valorMi;

		System.out.println("La diferencia entre el menor y el mayor de los numeros almacenados en el vector es de: "
				+ diferenciavalorMaMi);

		long TiempoDF = System.nanoTime();

		long tiempoD = (TiempoDF - TiempoDI) / 1000000;

		if (tiempoD < 0) {

			System.out.println("El tiempo empleado en calcular esta diferencia ha sido de " + (TiempoDF - TiempoDI)
					+ " millonesimas de segundo.");

		} else {

			System.out.println("El tiempo empleado en llenar el vector ha sido de " + tiempoD + " segundos y "
					+ (TiempoDF - TiempoDI) % 1000000 + " millonesimas de segundo.");

		}
		input.close();
	}

}
