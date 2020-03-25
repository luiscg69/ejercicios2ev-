package unidad5;

import java.util.ArrayList;
import java.util.Random;

public class Mazo {

	private static Random r = new Random();
	
	ArrayList<Naipe> naipes = new ArrayList<>();

	public Mazo() {
		this(1);
	}
	
	public Mazo(int n) {
		for (int i=0; i<n; i++)
			for (Palo palo: Palo.values()) 
				for (Rango rango: Rango.values()) 
					naipes.add(new Naipe(palo, rango));
	}
	
	public void add(Naipe naipe) {
		naipes.add(naipe);
	}
	
	public Naipe remove() {
		return naipes.remove(r.nextInt(naipes.size()));
	}
	
	@Override
	public String toString() {
		return naipes.toString();
	};
	
}
