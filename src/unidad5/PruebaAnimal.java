package unidad5;

import java.time.LocalDate;

public class PruebaAnimal {

	public static void main(String[] args) {
		Animal animal;
		animal = new Animal("Elefante");
		System.out.println(animal.getFecha());
		animal.setNombre("Pepe");
		
		Animal animal2 = new Animal("Iker", LocalDate.of(2010, 5, 15));
		System.out.println(animal2);
	}

}
