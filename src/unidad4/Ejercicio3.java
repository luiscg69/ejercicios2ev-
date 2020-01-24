package unidad4;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		/*
		 * 3. En el método main de una clase Java llamada Cadenas3 escribe un programa
		 * que lea dos cadenas desde el teclado y muestre el número de veces que la
		 * segunda está contenida en la primera.
		 */

		/* Creamos un nuevo objeto de la clase Scanner */
		Scanner input = new Scanner(System.in);

		/*
		 * Solicitamos al usuario que introduzca un texto mediante el teclado
		 * /*almacenamos la cadena de texto introducida previamente convirtiendo a
		 * minusculas ".toLowerCase()" mediante el objeto creado previamente de la
		 * Scanner input
		 * 
		 * Recordemos que el metodo nextline de la clase Scanner nos devuelve un String
		 * 
		 * el texto lo almacenamos en la variable de tipo String a
		 */

		System.out.println("Introduce la primera cadena: ");
		String a = input.nextLine().toLowerCase();

		/*
		 * Solicitamos al usuario que introduzca un texto mediante el teclado
		 * /*almacenamos la cadena de texto introducida previamente convirtiendo a
		 * minusculas ".toLowerCase()" mediante el objeto creado previamente de la
		 * Scanner input
		 * 
		 * Recordemos que el metodo nextline de la clase Scanner nos devuelve un String
		 * 
		 * el texto lo almacenamos en la variable de tipo String b
		 */

		System.out.println("Introduce la segunda cadena: ");
		String b = input.nextLine().toLowerCase();

		int i = 0;
		int contador = 0;

		/*
		 * tenemos que tener en cuenta que debemos mostrar el numero de veces que la
		 * segunda cadena (completa) este incluida en la primera, por lo tanto la
		 * longitud de la primera cadena no puede mas pequeña que la segunda, si ocurre
		 * esto, el programa nos informara de ello y finalizara
		 * 
		 */
		if (a.length() < b.length())
			System.out.println("La segunda cadena no puede ser más larga que la primera");

		/*
		 * En el caso que las cadenas se puedan comparar, es decir que la longitud de la
		 * primera cadena No sea inferor a la longitud de la segunda cadena,
		 * procederemos con la busqueda.
		 * 
		 */
		else {

			/*
			 * En el caso que las cadenas se puedan comparar, es decir que la longitud de la
			 * primera cadena No sea inferior a la de la segunda cadena, lo que vamos a
			 * hacer es:
			 * 
			 * utilizaremos indexOf de tal manera,
			 * 
			 * primera posicion encontrada = cadena en la que buscar.indexOf(cadena a
			 * buscar, desde la posicion encontrada (indice) hasta el final de la cadena )
			 * 
			 * El método indexOf devuelve el INDICE de la primera aparición de una cadena
			 * dentro de un String. Si le pasamos dos parámetros el primero será la cadena a
			 * buscar y el segundo la posición en la que empezará a buscar.
			 * 
			 * 
			 * En el caso de que el carácter o la cadena no exista se devuelve un -1
			 * 
			 * En el caso de que encuentre la cadena buscada nos devuelve la posicion de la
			 * primera ocurrencia encontrada
			 * 
			 * En nuestro caso habiamos declarado int i = 0, que va tomar el valor de la
			 * primera posición encontrada y en el caso de no encontrar ninguna ocurrencia
			 * nos devolvera el valor -1
			 * 
			 * El valor de i nos servira para,
			 * 
			 * Si encuentra la ocurrencia para determinar el indice y sumarle 1 para que
			 * siga buscando si hay mas ocurrencias Si encuentra la ocurrencia para
			 * cuantificarla Si no encuentra la ocurrencia su valor será de -1 y sabremos
			 * que hemos finalizado la busqueda
			 * 
			 * i lo declaramos con valor 0, porque el indice del primer caracter de la
			 * cadena en donde debemos buscar
			 * 
			 * 
			 * a es la primera cadena ( DONDE tenemos que buscar la segunda cadena
			 * (ocurrencia)) b es la segunda cadena (es la cadena que tenemos que buscar en
			 * la primera)
			 * 
			 * habiamos definido dos valiables de tipo int:
			 * 
			 * habiamos declarado la variable int contador = 0, Que es numero de veces que
			 * ocurra la ocurrencia, el numero de veces que encontro un indice, Antes de
			 * ejecutar su valor es 0, no encontro ningun indice, y cada vez que encuentre
			 * un indice quiere decir que encontro la ocurrencia por lo tanto, se ira
			 * incrementado en 1 cada vez que nos devuelva un indice i
			 * 
			 * 
			 */

			/*
			 * hacemos un bucle do while dado que queremos que por lo menos se haga una
			 * primera busqueda , y este se ejecute mientras i sea distinto a -1, dado que
			 * si devuelve -1 es que no encontro ninguna posicion, y no seria necesario
			 * seguir buscando
			 * 
			 */

			do {
				i = a.indexOf(b, i); /*
										 * devuelve la primera posicion donde encuentra la ocurrencia, si no la
										 * encuentra nos devuelve -1
										 * 
										 * /*System.out.
										 * println("la posición del primer texto  donde se encontro el segundo es: " +
										 * i);
										 */

				/*
				 * Si encontro un indice es porque es valor de i es distinto de -1, por lo
				 * tanto, a i le incrementamos en 1 para que la siguiente busqueda la inicie en
				 * el siguiente caracter contador le incrementamos en 1 su valor, porque ha
				 * encontrado la ocurrencia
				 * 
				 */
				if (i != -1) {
					i++;
					contador++;
				}
			} while (i != -1); /*
								 * el bucle finaliza cuando no ha encontrado ningún indice, i nos devielve que
								 * es -1
								 */

			/*
			 * sacamos por consola el resultado del numero de ocurrencias que es valor que
			 * tiene el contador
			 */
			System.out.println("La segunda está contenida " + contador + " veces en la primera");
		}
	}

}
