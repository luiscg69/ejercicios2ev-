package unidad4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int [][] a;
		
		int n = Integer.valueOf(in.readLine());
		a = new int[n][];
		for (int i=0; i<n; i++) {
			int m = Integer.valueOf(in.readLine());
			a[i] = crearVector(m, in.readLine());
		}
		
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[i].length; j++)
				System.out.printf("%5d", a[i][j]);
			System.out.println();
		}
	}

	static int [] crearVector(int n, String c) {
		Scanner in = new Scanner(c);
		int [] v = new int[n];
		for (int i=0; i<n; i++) 
			v[i] = in.nextInt();
		in.close();
		return v;
	}
	
}
