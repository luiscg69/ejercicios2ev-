package unidad5;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Hucha {

	private Map<Dinero, Integer> dinero;
	private String password = "";
	private boolean abierta = true;

	public Hucha() {
		dinero = new TreeMap<>();
	}

	public Hucha(int uno, int dos, int cinco, int diez, int veinte, int cincuenta) {
		this();
		add(Dinero.UNO, uno);
		add(Dinero.DOS, dos);
		add(Dinero.CINCO, cinco);
		add(Dinero.DIEZ, diez);
		add(Dinero.VEINTE, veinte);
		add(Dinero.CINCUENTA, cincuenta);
	}

	public Hucha(int euros) {
		this();
		int cantidad;
		for (Dinero d: Dinero.values()) {
			if (euros >= d.getValor()) {
				cantidad = euros / d.getValor();
				euros %= d.getValor();
				dinero.put(d, cantidad);
			}
		}
	}
	
	public Hucha(String password) {
		this();
		this.password = password;
		abierta = false;
	}
	
	public Hucha(String password, int uno, int dos, int cinco, int diez, int veinte, int cincuenta) {
		this(uno, dos, cinco, diez, veinte, cincuenta);
		this.password = password;
		abierta = false;
	}
	
	public Hucha(String password, int euros) {
		this(euros);
		this.password = password;
		abierta = false;
	}

	public boolean add(Dinero d, int cantidad) {
		if (!abierta || cantidad <= 0)
			return false;
		dinero.put(d, cantidad + dinero.get(d));
		return true;
	}

	public boolean abrir(String password) {
		if (this.password.equals(password))
			abierta = true;
		return abierta;
	}

	public void cerrar() {
		abierta = false;
	}

	public boolean cambiarPassword(String anterior, String nueva) {
		if (this.password.equals(anterior)) {
			this.password = nueva;
			return true;
		}
		return false;
	}

	public Integer getEuros() {
		if (abierta) {
			Set<Entry<Dinero, Integer>> s = dinero.entrySet();
			int total = 0;
			for (Entry<Dinero, Integer> entry : s)
				total += entry.getKey().getValor() * entry.getValue();
			return total;
		}
		return null;
	}

	public int retirar(Dinero d, int cantidad) {
		if (abierta) {
			int h = dinero.get(d);
			if (h < cantidad) {
				dinero.remove(d);
				return h;
			}
			else {
				dinero.put(d, h - cantidad);
				return cantidad;
			}
		}
		return 0;
	}

	public boolean isAbierta() {
		return abierta;
	}

	public Map<Dinero, Integer> retirar(int euros) {
		Map<Dinero, Integer> aux = new TreeMap<>();
		for (Dinero d: Dinero.values()) {
			int n = euros / d.getValor();
			if (n > 0 && dinero.containsKey(d)) {
				int hucha = dinero.get(d);
				if (hucha > 0) {
					if (n > hucha)
						n = hucha;
					aux.put(d, n);
					euros -= n * d.getValor();
				}
			}
		}
		if (euros > 0)
			return null;
		else {
			aux.forEach((v, c) -> retirar(v, c));
			return aux;
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Hucha(");
		if (abierta) {
			if (dinero.size() == 0)
				sb.append("vacía");
			else {
				Set<Entry<Dinero, Integer>> s = dinero.entrySet();
				int total = 0;
				for (Entry<Dinero, Integer> entry : s) {
					int v = entry.getKey().getValor();
					int c = entry.getValue();
					if (sb.length() > 6)
						sb.append(", ");
					sb.append(v);
					sb.append("€: ");
					sb.append(c);
					total += v * c;
				}
				sb.append(" = ");
				sb.append(total);
				sb.append("€");
			}
		}
		else
			sb.append("cerrada");
		sb.append(")");
		return sb.toString();
	}
	
}
