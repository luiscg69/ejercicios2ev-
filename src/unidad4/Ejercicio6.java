package unidad4;

import java.util.Random;

public class Ejercicio6 {

	public static void main(String[] args) {
		/*
		 * Created by: Luis Cortés Date:: 26-01-2020
		 */

		/*
		 * 6. En el método main de una clase Java llamada Vectores1 escribe un programa
		 * que cree un vector de números enteros de un tamaño aleatorio comprendido
		 * entre 10 y 50 elementos. El vector se llenará con números aleatorios
		 * comprendidos entre -100 y 100 sin repetir ninguno. A continuación, se creará
		 * un segundo vector que contenga los elementos del anterior almacenados en
		 * orden inverso. El programa finalizará mostrando ambos vectores en la
		 * pantalla.
		 */

		/* Creamos un objeto de la clase Random */

		Random r = new Random();

		/*
		 * usando el método nextInt(int n) de Random, que devuelve un valor entre 0 y n,
		 * excluido n. En buestro caso necesitamos un numero aleatorio comprendido entre
		 * 10 y 50 Es decir 41 numeros
		 * 
		 * Si el random empieza en 0, hay que sumarle 10 para que sea el numero del
		 * rango inferior Para calcular el valor del parametro de Ramdon que es el
		 * limite superior(50)+1 - 10 que lo que vamos a sumar al random nos da que el
		 * parametro del Random tiene que ser 50+1-10 = 41
		 * 
		 * El decir si hacemos un random(41) calculara un numero aleatorio entre 0 y 40
		 * (41-1) y si a este rango le sumamos 10 los numeros resultantes serán entre 10
		 * y 50.
		 * 
		 * El resultado de este random es la dimensión que va a tener la matriz
		 */

		int dimension = r.nextInt(41) + 10;

		/*
		 * Creamos un vector de dimensión (número de elementos) igual al valor que tiene
		 * "dimension" que posteriormente se ira llenado de numeros enteros lo llamamos
		 * vectorO
		 */

		int[] vectorO = new int[dimension];

		/*
		 * los indices que tiene cada elemento del vector van de cero hasta la longitud
		 * del vector-1
		 */

		/*
		 * debemos llenar el vectorO con numeros aleatorios entre -100 y 100 son 201
		 * numeros y que estos no se repitan.
		 * 
		 * utilizaremos el objeto Random con el método nextInt(int n) ir calculando los
		 * numeros aleatorios
		 *
		 * el rango inferior de Random es 0 y el numero inferior del rango tiene que ser
		 * -100 le restaremos 100 al random. el número superior del random tiene que ser
		 * 100, por lo tanto el parametro del random tiene que ser 100-(-100)+1 = 201
		 * 
		 */

		/*
		 * la descripcion del algoritmo a utilizar es:
		 * 
		 * Para cada indice de el Vector empezando por el 0 hasta el indice longitud del
		 * vector -1
		 * 
		 * 
		 */

		/*
		 * Hacemos un bucle for donde la variable entera va ir desde el indice 1 del
		 * vectorO el indice igual hasta su longitud -1 en cada interacion le
		 * incrementamos una unidad Es decir vamos a recorrer todos los elementos del
		 * vector
		 */
		for (int indiceV = 0; indiceV < vectorO.length; indiceV = indiceV + 1) {

			/*
			 * En cada interacion El ordenador calcula un numero aleatorio entre -100 y 100
			 */
			int naleatorio = r.nextInt(201) - 100;

			/*
			 * una vez que tenemos cada indice y el posible valor aleatorio recorreremos
			 * cada elemento del vector desde 0 hasta este indice
			 */
			for (int indiceA = 0; indiceA <= indiceV; indiceA = indiceA + 1) {

				/*
				 * Si al recorrer cada uno de los elementos del vector encuentra que su valor es
				 * igual al numero aleatorio
				 */
				/*
				 * Forzamos una salida del bucle ( haciendo que la variable no cumple la
				 * condicion del bucle) para que vuelva a calcular un numero aleatorio Pero
				 * tenemos que tener en cuenta que bucle principal sumara uno al indice en el
				 * que estamos, el cual deberá seguri siendo el mismo, por lo tanto tendremos
				 * que restarle un aunidad para cuando el bucle principal le sume 1 siga siendo
				 * el mismo
				 */
				if (vectorO[indiceA] == naleatorio) {
					indiceA = indiceV + 1;
					indiceV = indiceV - 1;
				}

				/*
				 * En el caso de halla llegado hasta el ultimo indice en el que estamos
				 * significara que no encontro el numero aleatorio en ningun elemento y por lo
				 * tanto lo metera en el utlimo indice en el que estamos
				 */
				else if (indiceA == indiceV) {
					vectorO[indiceV] = naleatorio;
				}
			}
		}

		/*
		 * una vez que todos los elementos del vector estan con numeros aleaorios los
		 * sacamos por pantalla desde la posicion 0 hasta la posicion de la longitud del
		 * vector -1
		 * 
		 */
		System.out.println("El primer vector tiene " + vectorO.length + " elementos, que son:");

		for (int x = 0; x < vectorO.length; x = x + 1) {
			System.out.print(vectorO[x] + ", ");
		}
		/*
		 * Nos pide crear otro vector con los numeros del primer vector pero en orden
		 * inverso
		 */

		/*
		 * creamos un segundo vector entero con dimension igual a la del vector anterior
		 */
		int[] vectorI = new int[vectorO.length];

		/*
		 * Con un bucle vamos a ir introducciendo los valores en orden inverso del
		 * vertorO en este vectorI
		 */

		/*
		 * El primer elemento que vamos a coger del primer vectorO* es el ultimo
		 * elemento es decir el de indice de su longitud -1
		 */
		int j = (vectorO.length) - 1;
		/*
		 * declaramos la variable entera y que sera cada uno de los indices del segunfo
		 * vector
		 */
		int y;

		/*
		 * recorremos cada uno de los elementos del segundo vectorI desde el indice 0
		 * hasta el indice cuyo valor sea inferior a su longitud -1 Es decir se inicia
		 * en el indice 0, se va incrementando en una unidad mientras sea mas pequeño
		 * que la longitud del vectorI
		 */
		for (y = 0; y < vectorI.length; y = y + 1) {

			/*
			 * Para cada elemento del vectoI empezando por el indice 0 le ponemos el
			 * elemento del vector origen empezando por su ultimo indice
			 */
			vectorI[y] = vectorO[j];

			/* Referenciamos ahora el indice del vectorO, disminuyendole una unidad. */
			j = j - 1;
		}

		/*
		 * Ahora mostramos por pantalla este segundo vector
		 * 
		 */
		System.out
				.println("\nEl segundo (elementos invertidos) vector tiene " + vectorO.length + " elementos, que son:");

		for (int x = 0; x < vectorI.length; x = x + 1) {
			System.out.print(vectorI[x] + ", ");
		}
	}
}
