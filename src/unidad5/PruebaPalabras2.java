package unidad5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PruebaPalabras2 {

	static Palabras2 p = new Palabras2();
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	static String leerComando() throws IOException {
		System.out.print("> ");
		return in.readLine();
	}

	public static void main(String[] args) throws IOException {
		String cmd;
		while (!(cmd = leerComando().toLowerCase().trim()).equals("fin"))
			System.out.println(p.parseCMD(cmd));
		in.close();
	}

}
