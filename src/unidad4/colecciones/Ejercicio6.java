package unidad4.colecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio6 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		System.out.print("> ");
		Scanner s = new Scanner(in.readLine());
		try {
			int n = s.nextInt();
			int m = s.nextInt();
			if (s.hasNext()) {
				s.close();
				System.out.println("error: la primera línea debe contener exactamente dos números enteros");
			}
			else {
				s.close();
				System.out.print("> ");
				s = new Scanner(in.readLine());
				for (int i=0; i<n; i++)
					a.add(s.nextInt());
				for (int i=0; i<m; i++)
					b.add(s.nextInt());
				if (s.hasNext())
					System.out.printf("error: la primera línea debe contener exactamente %d números enteros\n", n + m);
				else {
					Set<Integer> c = new HashSet<>(a);
					c.retainAll(b);
					System.out.println(c);
				}
				s.close();
			}
		} catch (InputMismatchException e) {
			s.close();
			System.out.printf("error: '%s' no es un número entero\n", s.next());
		}
		in.close();
	}

}
