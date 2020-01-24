package unidad4;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {

		/*
		 * Created by: Luis Cortés Date:: 24-01-2020
		 */

		/*
		 * 4. En el método main de una clase Java llamada Dado escribe un programa que,
		 * minimizando la cantidad de variables que se vayan a utilizar, simule el
		 * lanzamiento de un dado N veces, siendo N un número entero que se introducirá
		 * por teclado, y que muestre al final cuantas veces salió cada una de sus
		 * caras.
		 */

		/*
		 * declaramos y creamos un array literal contadores, de tamaño de dimensión 6 y
		 * cada elemento del array tiene un valor entero de 0, siendo cada elemento el
		 * numero de veces que aparace cada numero de la cara del dado, siendo, la
		 * posición 0 el numero de veces que sale el 1, indice 1 el número de veces que
		 * sale el numero 2, y asi respectivamente hasta el elemento de indice 5 que
		 * sera el numero de veces que salio el numero 6.
		 * 
		 */
		int[] contadores = { 0, 0, 0, 0, 0, 0 };

		/*
		 * declaramos la variable entera n que será numero de veces que el usuario nos
		 * dira que quiera que se tire el dado
		 */
		int n;

		/*
		 * creamos un objeto de la clase Scanner que leera lo introduzca por consola el
		 * ususario
		 */

		Scanner input = new Scanner(System.in);

		/*
		 * Decimos al usuario que nos introduzca el numero de veces que desea que se
		 * lanze el dado
		 */

		System.out.print("introduzca el numero de veces que quiere que se lanze el dado: ");

		/* almacenamos en n el numero introducido por el ususario */

		n = input.nextInt();

		/*
		 * Hacemos un bucle for para que se repita el numero de veces que el ususario ha
		 * introducido "tiradas"
		 * 
		 */
		for (int ntirada = 1; ntirada <= n; ntirada = ntirada + 1) {

			/*
			 * en cada tirada se calcula aleatoriamente el numero de cara del 1 al 6 que va
			 * saliendo
			 * 
			 * /*Creamos un objeto de la clase Ramdom
			 */

			Random r = new Random();

			/*
			 * usando el método nextInt(int n), que devuelve un valor entre 0 y n, excluido
			 * n. ue es la que nos calculara aletoriamente el numero de la cara que va ir
			 * saliendo en cada tirada, en nuestro caso los numeros que salgan irian desde
			 * el 1 hasta 6, por lo tanto si el ramdom tiene valor 6 nos devuelve valores
			 * entre 0 y 5 y si le sumamos 1 nos devolvera valores entre el 1 y el 6
			 */

			int ncara = r.nextInt(6) + 1;

			/*
			 * cada numero que salga esta relacionado con el indice del vector es decir si
			 * sale un 1 al elemento del vector de indice 0 deberemos incrementarlo en una
			 * unidad.
			 */

			contadores[ncara - 1] = contadores[ncara - 1] + 1;

			/*
			 * Es decir que el valor del elemento de la posición del numero que ha salido
			 * menos 1 sera igual al valor del elemento que tenga esa posicion mas 1 y lo
			 * ira al macenando en el propio array
			 * 
			 */
		}

		/*
		 * Para sacar los resultados por pantalla haremos un bucle for de 1 hasta 6,
		 * donde valor a sacar por pantalla sera lo almacenado en el array contadores en
		 * la posicion de n-1
		 */

		for (int c = 1; c <= 6; c = c + 1) {

			System.out.println("El número " + c + " ha salido " + contadores[c - 1] + " veces");
		}

	}

}