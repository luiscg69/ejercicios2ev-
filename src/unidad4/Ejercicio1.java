package unidad4;

import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		/* 1. En el método main de una clase Java llamada Cadenas1 escribe un programa
		 *  que lea una cadena desde el teclado y muestre en la consola el número de veces 
		 *  que se repite cada vocal.
		 */
		
		
		/* Creamos un nuevo objeto de la clase Scanner*/
		
			Scanner in = new Scanner(System.in);
		
		
		/* Declaramos las vocales, al principo como todavia el programa
		 * no empezado a contar vocales su valor inicila es 0
		 */
		int a = 0, e = 0, i = 0, o = 0, u = 0;
		
		/* declaramos la variable s como cadena de texto*/
		
		String s;
		
		/*Pedimos al usuario que introduzca un texto*/
		System.out.println("Introduce un texto: ");
		
		/*almacenamos la cadena de texto introducida previamente convirtiendo a minusculas ".toLowerCase()"
		 * mediante el objeto creado previamente de la Scanner s
		 */
		s = in.nextLine().toLowerCase();
		
		/* hacemos un bucle for para recorrer cada letra de la cadena de texto que se introdujo,
		 * que esta almacenada como valor de s
		 */
		
		/* para j igual a cero (la cadena va empezar en la posición cero
		 * 
		 * mientras que j sea menor a la longitud de la cadena (como empezamos en cero la posicion
		 * de la ultima letra de la cadena de texto sera la longitud menos 1, es decir menor que la longitud
		 * en este caso
		 * 
		 * 
		 * Y vamos incrementado el valor de j en 1
		 * 
		 * Es decir empezamos el bucle en j = 0 (primer caracter de la cadena de texto)
		 * y lo vamos incrementando en una unidad
		 * mientras el valor de j sea inferior a la longitud de la cadena de texto en s		 
		 */
		for (int j=0; j<s.length(); j++) {
			
			/*Creamos c de tipo char que ira tomando el valor en cada ciclo del bucle
			 * del caracter de la cadena en el numero de posición del valor de j 
			 * es decir desde 0 hasta la longitud de la cadena-1
			 * 
			 */
			char c = s.charAt(j);
			
			/*a continuación mediante un switch case, valoramos el valor de c es decir el
			 * caracter que nos vamos encontrando a lo largo de la cadena,
			 * si este es igual a una de las vocales incrementara en uno el valor del contador de cada una
			 * de las variables
			 * 
			 */
			switch (c) {
			case 'a':
				a++;
				break;
			case 'e':
				e++;
				break;
			case 'i':
				i++;
				break;
			case 'o':
				o++;
				break;
			case 'u':
				u++;
				break;
			}
		}
		
		/*una vez finalizado el bucle, el cual ya ha recorrido toda la cadena de texto
		 * y habra contado cade una de las vocales, sacamos por pantalla los resultados
		 */
		System.out.println("a: " + a);
		System.out.println("e: " + e);
		System.out.println("i: " + i);
		System.out.println("o: " + o);
		System.out.println("u: " + u);
		in.close();
	}

}
