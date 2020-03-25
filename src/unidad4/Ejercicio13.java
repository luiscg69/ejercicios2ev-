package unidad4;

import java.util.Random;

public class Ejercicio13 {

	public static void main(String[] args) {
		Random r = new Random();
		int [][] m = new int[r.nextInt(18) + 2][r.nextInt(18) + 2];
		for (int i=0; i<m.length; i++)
			for (int j=0; j<m[i].length; j++)
				m[i][j] = r.nextInt(100);
		int [] sumaFilas = sumaFilas(m);
		int [] sumaColumnas = sumaColumnas(m);
		
		for (int i=0; i<m.length; i++)
			System.out.println(vectorToString(m[i]) + "  " + sumaFilas[i]);
		System.out.println();
		System.out.println(vectorToString(sumaColumnas));
	}
	
	static int [] sumaFilas(int [][] m) {
		int [] v = new int[m.length];
		for (int f=0; f<m.length; f++) {
			v[f] = 0;
			for (int c=0; c<m[f].length; c++)
				v[f] += m[f][c];
		}
		return v;
	}
	
	static int [] sumaColumnas(int [][] m) {
		int [] v = new int[m[0].length];
		for (int c=0; c<m[0].length; c++) {
			v[c] = 0;
			for (int f=0; f<m.length; f++)
				v[c] += m[f][c];
		}
		return v;
	}
	
	static String vectorToString(int [] v) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i=0; i<v.length; i++) {
			sb.append(String.format("%4d", v[i]));
			if (i < v.length - 1)
				sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}

}
