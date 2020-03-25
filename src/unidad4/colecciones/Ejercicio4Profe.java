package unidad4.colecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio4Profe {

	static Map<Integer, Set<String>> palabras = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		boolean fin = false;
		while (!fin) {
			System.out.print("> ");
			String linea = in.readLine();
			fin = parseLinea(linea.toLowerCase().trim());
		}
		in.close();
	}

	static boolean parseLinea(String linea) {
		Scanner scanner = new Scanner(linea);
		String cmd = null;
		try {
			cmd = scanner.skip("fin$|texto:|lista\\s+|lista$").match().group().trim();
			if (cmd.equals("texto:")) {
				scanner.useDelimiter("\\W+");
				while (scanner.hasNext()) {
					String palabra = scanner.next();
					Set<String> set = palabras.get(palabra.length());
					if (set == null)
						palabras.put(palabra.length(), set = new TreeSet<String>());
					set.add(palabra.toLowerCase());
				}
			} else if (cmd.equals("lista")) {
				try {
					int n = scanner.nextInt();
					if (scanner.hasNext())
						System.out.printf("error: no se esperaba \"%s\"\n", scanner.next());
					else {
						Set<String> set = palabras.get(n);
						System.out.println(set == null ? String.format("no hay palabras de longitud %d", n) : set.toString());
					}
				} catch (InputMismatchException e) {
					System.out.printf("error: \"%s\" no es un número entero\n", scanner.next());
				} catch (NoSuchElementException e) {
					System.out.println("error: se esperaba un número entero");
				}
			}
		} catch (NoSuchElementException e) {
			System.out.printf("error: \"%s\" no es un comando válido\n", 
					linea.length() > 10 ? linea.substring(0, 9) + "..." : linea);
		}
		scanner.close();
		return cmd != null && cmd.equals("fin");
	}

}
