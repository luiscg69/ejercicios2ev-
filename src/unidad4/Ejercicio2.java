package unidad4;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		/*2. En el método main de una clase Java llamada Cadenas2 
		 * escribe un programa que lea una cadena desde el teclado 
		 * y la muestre invertida en la consola.
		 */
		
		/* Creamos un nuevo objeto de la clase Scanner*/
		Scanner input = new Scanner (System.in);
		
		/* declaramos la variable cadenaO como cadena de texto que es la que va a introducir el usuario*/
		
		String cadenaO;
		
		/* declaramos la variable cadenaI como cadena de texto que sera la cadena invertida
		 * y la iniciamos como vacia */
		String cadenaI="";
		
		/*Pedimos al usuario que introduzca un texto*/
		System.out.println("Introduce un texto: ");
		
		
		/*almacenamos la cadena de texto introducida previamente 
		 * mediante el objeto creado previamente de la Scanner input
		 */
		cadenaO = input.nextLine();
		
		
		
		
		
		/* ahora de la cadenaO haremos un bucle for 
		 * que ira recorriendo la cadena de texto 
		 * desde la ultima posición de la cadena de texto (length()-1)
		 * hasta la primera posicion de la cadena 0
		 * 
		 * Y en cada ciclo ira almacenando y añadiendo en la objeto cadenaI
		 * cada caracter que va leyendo de la cadena O 
		 * desde el final hasta el principio
		 * 
		 * 
		 */
		
		for (int j=(cadenaO.length())-1; j>=0; j--) {
			
			
			cadenaI  = cadenaI + cadenaO.charAt(j);
					
			
		}
			
		System.out.println("El texto invertido es: " + cadenaI);	
			
			
				
				
				
input.close();
	}

}
