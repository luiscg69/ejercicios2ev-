package unidad5;

import java.util.ArrayList;

public class PruebaLibro {

	public static void main(String[] args) {
		ArrayList<Autor> autores = new ArrayList<>();
		autores.add(new Autor("María", "maria@gmail.com", Genero.FEMENINO));
		autores.add(new Autor("Fernando", "fernando@gmail.com", Genero.MASCULINO));
		Libro libro = new Libro("Programación en Java", autores, 20f, 5);
		System.out.println(libro);
	}

}
