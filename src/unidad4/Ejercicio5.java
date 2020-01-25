package unidad4;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		/*
		 * Created by: Luis Cortés 
		 * Date:: 25-01-2020
		 */

		/*
		 * En el método main de una clase Java llamada ValidarNIF escribe  un programa que 
		 * lea desde el teclado una cadena que represente un NIF completo (número y letra) 
		 * y a continuación verifique que es correcto.
		 * Para obtener la letra de validación del N.I.F. se realiza la división entera 
		 * de la parte numérica entre 23 y el resto se utiliza como índice de la tabla siguiente:
		 * 
		 * 
		 * La validación consiste en comprobar que la letra obtenida en la tabla coincide 
		 * con la letra introducida por teclado.
		 */

		
		
		
		/*
		 * creamos un objeto de la clase Scanner que leera lo introduzca por consola el
		 * ususario
		 */
		
		
		Scanner input= new Scanner (System.in);
		
		/*
		 * Decimos al usuario que nos introduzca un DNI 
		 */
		
		System.out.print("Introduzca un DNI (numeros y letra), para que comprobar si la letra el valida: ");
		
		/* almacenamos en dni el dni introduccido por el ususario */
		
		
		String dni = input.nextLine();
		
		/*Del DNI introducido por el usuaruio almacenado en dni nos interesa separar
		 * la parte numerica y la letra, teniendo en cuenta que el resultado seguira siendo un string
		 */
		
		/* En primer lugar almacenamos la parte numerica que la almacenaremos en la variable String nsdni
		 * de tal forma que sera la parte del dni introducida desde el indice 0 (primer digito por la izquierda)
		 * hasta el indice, la longitud total del dni introducido menos 1 (el ultimo caracterer es la letra del DNI)
		 * 
		 *
		 * 
		 * utilizaremos substring(int beginIndex, int endIndex)
		 * 
		 * siendo,
		 * 
		 * int beginIndex: El inicial corresponde con la posición de la letra por la que queremos empezar
		 * int endIndex : El final es el que esta por la letra que está justo después de la última letra que queramos recuperar.
		 * 
		 * Por ejemplo
		 * 
		 * DNI     11423570E
		 * Indice  012345678
		 * 
		 * Longitud 9
		 * 
		 * Para la parte numerica nos interesa substring (0,8) porque extrae la cadena del digito 0 al 7
		 * es decir los indices del (0, a la longitud de la cadena(9) menos 1 = 8)
		 * 
		 * Le hacemos un trim para que en el caso que el usuario indujo un DNI con espacios en blanco los elimine
		 * 
		 * Ejemplo,
		 * 
		 * DNI 		 11423570 E
		 * Indice 	 0123456789
		 * 
		 * Extraemos la cadena sin la tetra
		 * 
		 * Numero 	 11423570      Notese que contiene un espacio al final
		 * Indice 	 012345678     	
		 * 
		 * Con trim eliminamos el psoible espacio del final
		 * 
		 * Numero 	 11423570      
		 * Indice 	 01234567     	
		 * 
		 * 	
		*/
		
		String nsdni = (dni.substring(0, (dni.length()-1))).trim();
		
		
		/*ahora nos interesa convertir estos numero que estan como String cadena de texto a enteros para
		 * poder saber cual es el resto al dividirlos por 23.
		*/
		int ndni = Integer.parseInt(nsdni);
		
		
		
		
		/*la letra es el ultimo caracter de la cadena por lo tanto sera la parte de subcadena 
		 * substring() con indices longitud de la cadena-1, longitud de la cadena , el resultado
		 * recordemos que los indices como empiezan en cero siempre tienen una correspondencia con la
		 * longitud-1 y la convertimos a mayusculas toUpperCase()
		 * 
		 */
		
		String ldni = (dni.substring((dni.length()-1),(dni.length()))).toUpperCase();
		
		
		
		/*Vamos a obtener el resto de dividir los digitos numericos del dni entre 23 lo almacenamos en la variable resto*/
		
		int resto = ndni % 23;
		
		 
		/*Ahora tenemos que validar si en la tabla de validacion
		 * Si la letra de la fila "letra" en el numero de columna donde 
		 * coincide en la fila "resto" el valor que contiene y el resto calculado
		 * 
		 * Nos damos cuenta que si creamos un array solo con las letras
		 * la posicion de cada elemento (letra) es coincidente con el resultado que
		 * nos tiene que dar el resto,
		  */
		
		/*creamos un array literal con las letras nos dan los datos en el enunciado*/
		
		String[] letra = {"T", "R", "W","A" ,"G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
		
		/* Guardamos el valor del elemento (letra) del array en el indice de numero el resto calculado, en la valiable cdni*/
		
		
		String cdni = letra [resto];
		
		/*sacamos por consola el resultado de la letra del arrays y si la letra del arrays coincide con la introduccida
		 * decimos que es correcta sino decimos que no es correcta
		 */
		
		System.out.println("La letra "+ldni+" del numero del DNI "+ nsdni+" introduccido: " + dni);
		
		
		/*Si las letras no son iguales es que porque la letra introduccida en el DNI es incorrecta,
		 * Nos sale por consola avisandonos y nos dice cual es la letra correcta
		 * 
		 */
		if (!ldni.equals(cdni)) {
		
		System.out.print("No es correcta, deberia ser la letra: "+ cdni);
		}
		
		/* Si no son distintas (son iguales) la letra introduccida en el DNI es igual a la calculada con el resto y 
		 * la tabla nos dice que es correcta
		 * 
		 */
		else {
			System.out.print("Es correcta");
			
		}
		
		
	/*
	 * Cerramos Scanner
	 */
	input.close();	
	
	}

}
