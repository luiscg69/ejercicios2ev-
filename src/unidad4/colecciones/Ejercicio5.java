package unidad4.colecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Ejercicio5 {

	static Map<String, Set<Integer>> contactos = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("> ");
		} while (ejecutarComando(in.readLine()));
		in.close();
	}

	static boolean ejecutarComando(String linea) {
		/*
		 * no es necesario utilizar la clase Scanner para todo, a veces 
		 * se pueden resolver los problemas de una forma más sencilla.
		 * 
		 */
		String [] tokens = linea.split(":");
		String cmd = tokens[0].toLowerCase().trim();
		if (tokens[0].equals("buscar")) {
			if (tokens.length != 2)
				System.out.println("error: comando incorrecto");
			else {
				String contacto = tokens[1].trim();
				Set<Integer> telefonos = contactos.get(contacto);
				if (telefonos == null)
					System.out.printf("%s: contacto no encontrado\n", contacto);
				else
					System.out.printf("%s: \n" + telefonos, contacto);
			}
		}
		else if (tokens[0].equals("eliminar")) {
			if (tokens.length != 2)
				System.out.println("error: comando incorrecto");
			else {
				String contacto = tokens[1].trim();
				Set<Integer> telefonos = contactos.get(contacto);
				if (telefonos == null)
					System.out.printf("%s: contacto no encontrado\n", contacto);
				else {
					contactos.remove(contacto);
					System.out.printf("%s: " + telefonos + " - contacto eliminado\n", contacto);
				}
			}
		}
		else if (tokens[0].equals("contactos")) {
			if (tokens.length != 1)
				System.out.println("error: comando incorrecto");
			else
				contactos.forEach((contacto, telefonos) -> System.out.printf("%s: " + telefonos + "\n", contacto));
		}
		else if (tokens[0].equals("salir")) {
			if (tokens.length != 1)
				System.out.println("error: comando incorrecto");
			else
				return false;
		}
		else {
			if (tokens.length != 2)
				System.out.println("error: comando incorrecto");
			else {
				Integer telefono = null;
				try {
					telefono = Integer.valueOf(tokens[1].trim());
					/* aquí la variable cmd contiene el nombre de un contacto */
					Set<Integer> telefonos = contactos.get(cmd);
					if (telefonos == null) {
						telefonos = new HashSet<>();
						contactos.put(cmd, telefonos);
					}
					telefonos.add(telefono);
				} catch (NumberFormatException e) {
					System.out.printf("error: %d no es un teléfono válido\n", telefono);
				}
			}
		}
		return true;
	}
	
}
