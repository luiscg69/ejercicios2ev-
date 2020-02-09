package unidad4.colecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio4 {

	/*
	 * Programa que lea líneas de texto por teclado y almacene las palabras de forma
	 * que podamos consultar la lista de palabras de una determinada longitud en
	 * orden alfabético. El comienzo de cada línea determinará la acción que
	 * queremos realizar:
	 * 
	 * Si la línea comienza con "Texto: ", se almacenarán las palabras que le
	 * siguen.
	 * 
	 * Si la línea comienza con "Lista n", siendo n una longitud, se mostrará la
	 * lista de palabras de dicha longitud.
	 */

	/*
	 * En primer lugar vamos a definir un mapa, del tipo HashMap Donde la clave
	 * (key) va ser un número entero que será la longitud de la palabra introducida
	 * 
	 * y el valor, para cada clave sera cada una de las palabras que se introducen
	 * de esa longitud y se pueden introducir palabras distintas con la misma
	 * longitud, misma Key, lo que haremos es asignar a cada key (longitud) un
	 * conjunto de tipo TreeSet String, y para cada palabra de misma longitud,
	 * estara en el mismo conjunto con la misma key (longitud).
	 * 
	 */

	static Map<Integer, TreeSet<String>> mapa = new HashMap<Integer, TreeSet<String>>();

	public static void main(String[] args) throws IOException {

		/*
		 * declaramos un BufferReader que lee los datos de la consola
		 * 
		 */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		/*
		 * declaramos una variable booleriana fin, que en principio le asignamos un
		 * false para cuando esta fin sera veradera finalice el programa.
		 */

		boolean fin = false;

		/*
		 * Hacemos un buble, while que se ejecutara mientras la expresion sea true, es
		 * decir como fin es false, mientras sea no fin es decir no false,
		 * 
		 * Si fin = false !fin = !false = true
		 * 
		 * * Para salir del bucle, lo que tenemos que hacer es decir que fin es true,
		 * para que la expresion No fin, sea No true, sea falsa
		 * 
		 * Si fin = true !fin = !true = false
		 * 
		 */
		while (!fin) {

			/*
			 * Solicitamos al usuario que introduzca la instruccion que quiera realizar
			 * 
			 */

			System.out.print("Introduzca la acción a realizar> ");

			/*
			 * Linea almacenara el texto introducido por el usuario por la consola
			 */
			String linea = in.readLine();

			/*
			 * fin llamara a un metodo procesarLinea, que procesara lo almacenado en la
			 * variable linea.
			 * 
			 */

			fin = procesarLinea(linea);
			
		}
	}

	/*
	 * metodo procesarLinea para procesar lo introducido por el usuario por consola.
	 * lo que nos devuelva va a ser el valor de fin
	 */

	static boolean procesarLinea(String linea) {

		// CASO 1 EL USUARIO INTRODUJO fin por la consola
		/*
		 * Si introdujo el usuario por el teclado "fin" (precisamente de convertir a
		 * minusculas lo que el usuario introdujo por el teclado) entonces este metodo
		 * devolvera true, entonces la variable fin = true y (!fin) sera false y esto
		 * hara que saldra del bucle while
		 */

		if (linea.toLowerCase().equals("fin"))
			return true;

		// CASO 2 EL USUARIO INTRODUJO OTRO TEXTO QUE NO FUESE FIN
		/*
		 * El texto introducido y leido a través BufferedReader y almacenado en linea lo
		 * almacenamos en un objeto de la clase Scanner, debido a que Scanner tiene mas
		 * metodos que BufferedReader
		 */

		Scanner s = new Scanner(linea);

		/*
		 * vamos a leer lo introducido por el usuario hasta el primer espacio en blanco
		 */

		String comando = s.next();// s.next lee desde el principio hasta el primer espacio en blanco

		// System.out.println("comando es iguala:"+comando+"f");

		// CASO 2 A :EL USUARIO INTRODUJO AL INICIO "texto: "

		/*
		 * Si lo introducido empieza por "texto; " vamos a introducir la palabla debemos
		 * introducir "texto: " con un espacio y luego la palabra para poder comprobar
		 * la primera palabra hasta el primer espacio que sea "texto:" Hemos puesto
		 * toLowerCase(), por si el usuario introdujo alguna letra en Mayusculas lo
		 * transforme en minuscula y la igualdad se cumpla. Por ejemplo "Texto: ",
		 * "TEXTO: ", "TExtO: "
		 */

		if (comando.toLowerCase().equals("texto:")) {

			/*
			 * ahora lo que nos interesa es lo introducido despues de "texto: " utilizaramos
			 * substring a partir del primer espacio indice 7 texto: 0123456 Entendemos que
			 * solo va a introducir una palabra, si introduce varias incluso con espacios en
			 * blanco procesara todo apartir del primer espacio en blanco como si fuese una
			 * sola palabra
			 */
			String palabra = linea.substring(7);// es la palabla introducida (es todo lo que introdujo el usuario a
												// partir de la posicion 7)
			int longitudpalabra = linea.substring(7).length();// es la longitud de la palabra introducida que sera el
																// Key del map

			// CASO 2 A 1: EL USUARIO INTRODUJO "Texto: " Y DESPUES INTRODUJO UNA PALABRA ES
			// DECIR TIENE UNA LONGITUD

			if (longitudpalabra > 0) {

				// Primero lo que hacemos es mirar si el TreeSet del Key (longitud de la
				// palabra) del mapa tiene algun dato
				// Si tiene algun dato devuelve los datos, si no tiene datos el get() nos
				// devolvera null y por lo tanto el mapa
				// no tiene ningun TreeSet en ese Key y habra que crearlo para luego añadirle la
				// palabra

				TreeSet<String> TreeSetdecadaKey = mapa.get(longitudpalabra);

				System.out.println("el valor de TreeSetdecadaKey es " + TreeSetdecadaKey);

				// Si el TreeSet para un Key no existe nos devolvera null, por lo tando
				// tendremos que crear el TreeSet para ese Key

				// CASO 2 A 1 A: EL USUARIO INTRODUJO "Texto: " Y DESPUES INTRODUJO UNA PALABRA
				// ES DECIR TIENE UNA LONGITUD Y NOS
				// DEVUELVE NULL, ES PORQUE TODAVIA NO EXISTE EL TreeSet PARA ESE Key DEBEREMOS
				// CREARLO
				// NO SE CONTEMPLA EL CASO DE QUE SOLO ESPACIOS EN BLANCO NI QUE FUESEN VARIAS
				// PALABRAS CON ESPACIOS EN BLANCO LO
				// TRATA COMO UNA PALABRA

				if (TreeSetdecadaKey == null) {

					TreeSetdecadaKey = new TreeSet<String>();// creamos el TreeSet

					System.out.println("el valor de TreeSetdecadaKey DESPUES DE CREARLO es " + TreeSetdecadaKey);

					// Y en el mapa para ese indice le introducimos este TreeSet
					// longitudpalabra ES EL KEY
					// TreeSetdecadaKey ES EL UN NUEVO TreeSet

					mapa.put(longitudpalabra, TreeSetdecadaKey);

				}

				// ahora que ya sabemos que existe el TreeSet para ese Key, le añadimos la
				// palabra a ese TreeSet
				// habiamos definido el TreeSet <String> TreeSetdecadaKey como el valor del Key
				// mapa.get(longitudpalabra);

				TreeSetdecadaKey.add(palabra);

				// CASO 2 A 2: EL USUARIO INTRODUJO "Texto: " Y DESPUES NO INTRODUJO NADA ES
				// DECIR TIENE UNA LONGITUD DE 0
				// NO SE CONTEMPLA EL CASO DE QUE SOLO ESPACIOS EN BLANCO
			}
			if (longitudpalabra == 0) {
				System.out.println("Despues de 'texto: ' debe introduccir una palabra");
			}

			// CASO 2 B :EL USUARIO INTRODUJO AL INICIO "lista n"
		} else if (comando.toLowerCase().equals("lista"))

		{
			try {
				int n = s.nextInt();// Captura el primer numero entero introducido en la linea

				// CASO 2 B 1: SI NO HAY NINGUN VALOR PARA KEY (INTRODUCIDO LONGITUD) DEL MAPA,
				// DEVUELVE NULL Y POR LO TANTO ES QUE NO ALMACENO
				// NINGUNA PALABRA DE ESA LONGITUD
				if (mapa.get(n) == null) {
					System.out.println("No hay ninguna palabra almacenada con esa longitud");

					// CASO 2 B 2: SI NO DEVOLVIO NULL ES PORQUE TIENE PALABRAS PARA ESE KEY Y
					// DECIMOS QUE NOS IMPRIMA
					// EL VALOR QUE TIENE ESE KEY, QUE SERAN LAS PALABRAS ALMACENADAS EN EL TreeSet
					// para ese KEY

				} else {
					System.out.println("Las palabras almacenadas con esa longitud son: \n" + mapa.get(n));
				}

			} catch (NoSuchElementException e) {
				System.out.println("Error, se esperaba una longitud");
			}
		} else

			System.out.println("Error, se esperaba un comando");

		return false;
	}

}
