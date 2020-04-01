package repaso2ev;

public class Matrices {

	// Ejercicio de Repaso 2ª Evaluación - Matrices CIFP Avilés 1º DAW
	// Programación Clase Matrices
	//
	// Created by Luis Cortes. Date 26-03-2020

	// Modified 1 by Luis Cortes. Date 26-03-2020
	// Se modifica en Metodo palindromo, en relación al abecedario
	// Se elimina el vector y se cogeran las letras por su codigo ACCII,
	// Para el caracter cetral tendremos en cuenta minusculas y mayusculas para que
	// la suma pueda ser de 26+25 = 51 elementos

	// Metodo de clase cuadrada1
	// Como entrada es un número entero y salida va a ser una matriz de dos
	// dimensiones, con valores enteros.
	static int[][] cuadrada1(int dim) {

		int matriz[][] = new int[dim][dim]; // Se crea el objeto Matriz de tipo entera la dimensión dim dim
		int valor = 1; // Declaramos una variable de tipo entera y le damos el valor 0, que sea el
						// valor que va tomando cada elemento de la matriz

		// Hacemos un bucle recorriendo la matriz he introducciendo los valores en cada
		// elemento

		for (int j = 0; j < dim; j++) {
			for (int i = 0; i < dim; i++) {
				// Recorremos la matriz empezando por el el elemento F 0 C 0, nos vamos moviendo
				// dentro de cada columna por las filas que tiene y luego cambiamos de columna y
				// recorremos otra vez sus filas....
				matriz[i][j] = valor;

				// El valor va incrementandose en 1 cada vez que cambiamos de elemento
				valor = valor + 1;
			}
		}

		// retornamos la matriz con todos los valores de sus elementos
		return matriz;

	}

	// Metodo de clase cuadrada1 VERSION 1 01-04-2020
	// Como entrada es un número entero y salida va a ser una matriz de dos
	// dimensiones, con valores enteros.
	static int[][] cuadrada2(int dim) {

		int matriz[][] = new int[dim][dim];// Se crea el objeto Matriz de tipo entera la dimensión dim dim
		int valor = 1;// Declaramos una variable de tipo entera y le damos el valor 0, que sea el
						// valor que va tomando cada elemento de la matriz

		// En este caso dependiendo si la columna es par o impar, recorremos al matriz
		// de abajo a arriba o de arriba a abajo

		// Empezamos en la columna 0 hasta su longitud-1, en este caso es el parametro
		// introducido-1
		for (int j = 0; j < dim; j++) {

			// valoramos si esa columna es par o impar,

			// Si es par
			if (j % 2 == 0) {

				// recorremos la columna, de la fila 0 hasta su longitud
				for (int i = 0; i < dim; i++) {

					// y metemos el valor de la variable que tiene en ese momento
					matriz[i][j] = valor;

					// incrementamos en 1 el valor de la variable en cada iteración
					valor = valor + 1;
				}
				// Sino es par la columna
			} else {

				// recorremos dentro de cada columna, desde la ultima fila (dim-1) hasta 0 en el
				// ejemplo de abajo a arriba
				for (int i = dim - 1; i >= 0; i--) {

					// y metemos el valor de la variable que tiene en ese momento
					matriz[i][j] = valor;
					// incrementamos en 1 el valor de la variable en cada iteración
					valor = valor + 1;
				}
			}
		}
		// retornamos la matriz con todos los valores de sus elementos
		return matriz;

	}

	// Metodo de clase palindromo
	// Como entrada son dos números enteros ques serán las dimensiones de una matriz
	// y salida
	// Retornara o bien una matriz de tipo String con los palindromos o bien
	// retronará null

	static String[][] palindromo(int d, int f) {

		/**
		 * La dimensión maxima de filas y columnas tiene que estar comprnedido entre el
		 * 1 y el 26 Entonces si se cumplen estos requisitos,
		 */

		if ((d >= 1 && d <= 26) && (f >= 1 && f <= 26)) {

			// Se crea un objeto matriz de tipo cadena de texto

			String matriz[][] = new String[d][f];

			/**
			 * VERSION 1 El valor del primera y tercera letra, dentro de cada referencia de
			 * la matriz es el valor del codigo ASCII de la referencia de fila en la que
			 * estemos sumandole 97 (que es el codigo ASCII de la a misnuscula) y el valor
			 * de cada uno de sus sucesivos numeros hasta el codigo 122 es el valor de cada
			 * una de las letras del abecedario ordenadas alfabeticamente.
			 * 
			 * Para saber el valor de un codigo ASCII utilizaremos "(Char) codigoASCII"
			 * 
			 * 
			 * Para el caso de la segunda letra, como está determinado por la suma de la
			 * fila y la columna Necesitaremos 26 + 25 elementos por lo tanto meteremos en
			 * juego al abecederario en letras minusculas (26) y en letras MAYUSCULAS (25),
			 * de tal forma que si la suma de si la suma es entre 0 a 25 (26 elementos)
			 * cogeremos el valor de esta suma + 97, si la suma de la referencia de la fila
			 * y columna es etre 26 y 51 incluidos cogeremos el valor de la suma de la fila
			 * y columna sumandole 39 ( en realidad usaremos if como condicion la primera y
			 * un else si no cuemple la primera como el primer codigo AXCII devido a que las
			 * letras mayusculas empiezan en el codigo ASCII 65. Si la suma es 26 entonces
			 * para llegar a 65 deberemos sumarle 39.
			 * 
			 */

			// Recorremos la matriz fila --> columna
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < f; j++) {

					// Calculamos el codigo ASCII para el segundo valor

					int codigoASCII; // variable que sera el codigo ASCII de la segunda letra

					if (i + j <= 25) {
						codigoASCII = i + j + 97;
					} else {
						codigoASCII = i + j + 39;
					}

					// imprimimos la Matriz
					matriz[i][j] = (String.valueOf((char) (i + 97)) + String.valueOf((char) (codigoASCII))
							+ String.valueOf((char) (i + 97)));

				}
			}

			// Retornamos la matriz con palindormos creada
			return matriz;
		}

		// Sino cumplio los requisitos rertamos valor null
		return null;
	}

	// Metodo de clase max3x3sum
	// Como entrada tenemos una matriz de dimension 2 de numeros entreros y salida
	// retornamos un numero entero

	static int max3x3sum(int[][] matriz) {

		// declarmaos un parametro que sera la suma maxima que retornara el metodo en
		// principo vale 0,
		int sumaMax = 0;
		// Hacemos cuatro bucles

		// empezamos por la fila 0 hasta la fila de referencia (la longitud - 3 )
		// las referencias van llegan hasta longitud-1 y la referencia inicial maxima es
		// longitud-1-2 para luego porder coger 3 digitos

		for (int i = 0; i <= (matriz.length - 3); i++) {

			// dentro de cada fila recorreremos cada columna desde la columna 0 hasta (la
			// longitud -3 )
			for (int j = 0; j <= (matriz[i].length - 3); j++) {
				// cuando estamos en la primera referencia tendremos que empezar a sumar
				// declaramos una variable entera que será la suma parcial que vamos obteniendo
				int suma = 0;

				// recorremos desde fila de la referencia anterior por fila (3 filas)
				for (int f = i; f <= (i + 2); f++) {

					// en cada fila recorremos cada columna, empezando por la primera (3 columnas)
					for (int c = j; c <= (j + 2); c++) {

						// a la variable suma le vamos incrementando el valor que tiene cada referencia
						// de el recorrido de la matriz de 3x3
						suma = suma + matriz[f][c];
					}
				}

				// si el resultado obtenido de la suma es sumperior a una anterior suma Maxima
				// A la suma Maxima le damos el valor de la suma.
				if (suma > sumaMax) {
					sumaMax = suma;

				}
			}
		}

		// Despues de hacer los calculos recorriendo toda la matriz en matrices de 3x3
		// retornamos la Suma Maxima
		return sumaMax;
	}
}
