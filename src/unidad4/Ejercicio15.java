package unidad4;

import java.util.Scanner;

public class Ejercicio15 {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String [] opciones = {
				"1 - Nota media de todos los alumnos",
				"2 - Nota media de un alumno",
				"3 - Notas por evaluación y nota final de todos los alumnos",
				"4 - Notas por evaluación y nota final de un alumno",
				"5 - Nota media de todo el curso",
				"6 - Notas máxima y mínima",
				"7 - Salir"
		};
		
		System.out.print("Número de alumnos: ");
		String [] alumnos = new String[Integer.valueOf(in.nextLine())];
		float [][] notas = new float[alumnos.length][4];
		leerDatos(alumnos, notas);
		int op;
		do {
			for (int i=0; i<opciones.length; i++)
				System.out.println(opciones[i]);
			System.out.print("Elige una opción: ");
			op = in.nextInt();
			if (op != 7)
				ejecutarOpcion(op, alumnos, notas);
		} while (op != 7);
		in.close();
	}
	
	static void leerDatos(String [] alumnos, float [][] notas) {
		for (int i=0; i<alumnos.length; i++) {
			System.out.printf("Nombre del alumno %d de %d: ", i + 1, alumnos.length);
			alumnos[i] = in.nextLine();
			System.out.print("Calificaciones (en una línea separadas por espacios): ");
			leerNotas(in.nextLine(), notas[i]);
		}
		System.out.println();
	}
	
	static void leerNotas(String linea, float [] notas) {
		// en la última posición se calculará la media
		Scanner s = new Scanner(linea);
		notas[3] = 0;
		for (int i = 0; i<3; i++) 
			notas[3] += notas[i] = s.nextFloat();
		notas[3] /= 3;
		s.close();
	}
	
	static int seleccionarAlumno(String [] alumnos) {
		int alumno;
		do {
			for (int i=0; i<alumnos.length; i++)
				System.out.printf("%d - %s\n", i + 1, alumnos[i]);
			System.out.print("Elige un alumno: ");
			alumno = in.nextInt();
			if (alumno <0 || alumno >= alumnos.length)
				System.out.println("Alumno incorrecto, inténtalo de nuevo.");
		} while (alumno < 1 || alumno > alumnos.length);
		System.out.println();
		return alumno - 1;
	}
	
	static void notasAlumno(String alumno, float [] notas) {
		System.out.printf("%-30s\t1EV: %5.2f\t2EV: %5.2f\t3EV: %5.2f\tFINAL: %5.2f\n",
			alumno, notas[0], notas[1], notas[2], notas[3]);
	}
		
	static void ejecutarOpcion(int op, String [] alumnos, float [][] notas) {
		System.out.println();
		switch (op) {
		case 1:
			opcion1(alumnos, notas);
			break;
		case 2:
			opcion2(alumnos, notas);
			break;
		case 3:
			opcion3(alumnos, notas);
			break;
		case 4:
			opcion4(alumnos, notas);
			break;
		case 5:
			opcion5(notas);
			break;
		case 6:
			opcion6(notas);
			break;
		default:
			System.out.println("Opción incorrecta");
		}
		System.out.println();
	}
	
	static void opcion1(String [] alumnos, float [][] notas) {
		System.out.println("NOTAS MEDIAS");
		for (int i=0; i<alumnos.length; i++)
			System.out.printf("%s: %5.2f\n", alumnos[i], notas[i][3]);
	}
		
	static void opcion2(String [] alumnos, float [][] notas) {
		System.out.println("NOTA MEDIA");
		int i = seleccionarAlumno(alumnos);
		System.out.printf("%s: %5.2f\n\n", alumnos[i], notas[i][3]);
	}
	
	static void opcion3(String [] alumnos, float [][] notas) {
		System.out.println("NOTAS");
		for (int i=0; i<alumnos.length; i++)
			notasAlumno(alumnos[i], notas[i]);
	}

	static void opcion4(String [] alumnos, float [][] notas) {
		System.out.println("NOTA");
		int i = seleccionarAlumno(alumnos);
		notasAlumno(alumnos[i], notas[i]);
	}
	
	static void opcion5(float [][] notas) {
		float media = 0;
		for (int i=0; i<notas.length; i++)
			media += notas[i][3];
		System.out.printf("NOTA MEDIA DEL CURSO: %5.2f\n", media / notas.length);
	}
	
	static void opcion6(float [][] notas) {
		float max = Integer.MIN_VALUE;
		float min = Integer.MAX_VALUE;
		for (int i=0; i<notas.length; i++) {
			for (int j=0; j<notas[i].length - 1; j++) {
				if (notas[i][j] > max)
					max = notas[i][j];
				if (notas[i][j] < min)
					min = notas[i][j];
			}
		}
		System.out.printf("NOTA MÁXIMA: %5.2f\n", max);
		System.out.printf("NOTA MÍNIMA: %5.2f\n", min);
	}
	
}
