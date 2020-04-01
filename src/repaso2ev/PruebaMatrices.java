package repaso2ev;

import java.util.Scanner;
import java.util.Random;

//Ejercicio de Repaso 2ª Evaluación - Matrices CIFP Avilés 1º DAW
	// Programación PruevaMatrices
	//  
	// Created by Luis Cortes. Date 26-03-2020



public class PruebaMatrices {

	static Scanner input = new Scanner(System.in);
	static Random r = new Random();

	public static void main(String[] args) {
		int dimension;
		
		//Prueba "Metodo Cuadrada1
		System.out.print("Metodo Cuadrada1, introduzca numero como dimensión de la matriz: ");
		dimension = Integer.valueOf(input.nextLine());

		int[][] mimatrizcuadrada1 = Matrices.cuadrada1(dimension); // llamaamos al metodo que nos devuelve la matriz
		
		// recorremos la matriz devuelta y la imprimimos por consola
		for (int i = 0; i < mimatrizcuadrada1.length; i++) {
			for (int j = 0; j < mimatrizcuadrada1[i].length; j++) {
				System.out.print(mimatrizcuadrada1[i][j] + " "); // Imprime Matriz
			}
			System.out.println(); // Imprime salto de línea
		}
        
		//Prueba "Metodo Cuadrada2
		System.out.println(); // Imprime salto de línea
		System.out.print("Metodo Cuadrada2, introduzca numero como dimensión de la matriz: ");
		dimension = Integer.valueOf(input.nextLine());

		int[][] mimatrizcuadrada2 = Matrices.cuadrada2(dimension); //llamamos al metodo y nos retorna la matriz
		
		// recorremos la matriz devuelta y la imprimimos por consola
		for (int i = 0; i < mimatrizcuadrada2.length; i++) {
			for (int j = 0; j < mimatrizcuadrada2[i].length; j++) {
				System.out.print(mimatrizcuadrada2[i][j] + " "); // Imprime Matriz
			}
			System.out.println(); // Imprime salto de línea
		}

		
		//Prueba "Metodo Palindromo
		System.out.println(); // Imprime salto de línea
		System.out.println("Metodo palindromo:");
		
		//Pedimos el numero de filas y columnas advertimos de que no se puede exceder deciertos valores
		//Pero no hacemos nada sino se cumplen para que el metodo nos devuelva el valor null si procede
		System.out.println("El numero de filas y columnas debe ir entre 1 y 26, y su suma no puede ser superior a 27");
		System.out.print("Introduzca el número de filas de la Matriz: ");
		int nfilas = Integer.valueOf(input.nextLine());

		System.out.print("Introduzca el número de columnas de la Matriz: ");
		int ncolumnas = Integer.valueOf(input.nextLine());

		String[][] mimatrizpalindromo = Matrices.palindromo(nfilas, ncolumnas);// Llamamos al metodo 

		//Si nos retorno null
		if (mimatrizpalindromo == null) {

			System.out.println("La matriz con palindromos no se puede realizar "); // Imprime salto de línea

		} else {
        //Sino retorn0 null, nos devolvio una matriz con palindronos.
			
			// recorremos la matriz devuelta y la imprimimos por consola
			for (int i = 0; i < mimatrizpalindromo.length; i++) {
				for (int j = 0; j < mimatrizpalindromo[i].length; j++) {
					System.out.print(mimatrizpalindromo[i][j] + " "); // Imprime Matriz
				}
				System.out.println(); // Imprime salto de línea
			}
		}
				
		//Prueba Metodo max3x3sum
		System.out.println(); // Imprime salto de línea
		System.out.println("Metodo max3x3sum: ");
		int Nfilas;
		int Mcolumnas;
		
		
		//Vamos a solitar el numero de filas hasta que sea un número mayor o igual a 3
		do {
		System.out.print("Introduzca número mayor o igual a 3 como filas de la matriz: ");
		Nfilas = Integer.valueOf(input.nextLine());
		} while(!(Nfilas>=3));
		
		
		//Vamos a solitar el numero de columnas hasta que sea un número mayor o igual a 3
		do {
		System.out.print("Introduzca número mayor o igual a 3 como columnas de la matriz: ");
		Mcolumnas = Integer.valueOf(input.nextLine());
		} while(!(Mcolumnas>=3));
		
		//Cremaos una matriz con la filas y columnas introduccidas anteriromente
		int[][] matrizNxM = new int [Nfilas][Mcolumnas];
		
		// Para este ejemplo la matriz se llena mediante un metodo donde rellena la matriz
		//Con numeros aleatorios desde el 0 hasta el 99
		
		
		llenarMatriz (matrizNxM);
		
		// recorremos la matriz original creada y la imprimimos por consola
		for (int i = 0; i < matrizNxM.length; i++) {
			for (int j = 0; j < matrizNxM[i].length; j++) {
				System.out.print(matrizNxM[i][j] + " "); // Imprime Matriz
					
			}
			System.out.println(); // Imprime salto de línea
		}
		
		//llamamos al metodo y nos devuelve la mayor suma que se obtiene de todos los resultados, sumando los elementos de cada matriz de 3 x 3 que contiene la matriz original
		int SumMax =  Matrices.max3x3sum(matrizNxM);
		
		// Imprimimimos el valor maximo 
		System.out.println("La mayor suma de todos los elementos de cada una de las matrices de 3x3 contenidas en esta matriz es = "+ SumMax); 
		
	    
	}
	
// Metodo que rellena una matriz de cualquier dimension con valores de numeros aleatorios entre el 0 y 99	
  static void llenarMatriz (int [][] m) {
	for (int i=0; i<m.length; i++)
		for(int j=0; j<m[i].length; j++)
		m[i][j] = r.nextInt(100);
	
 }
}
