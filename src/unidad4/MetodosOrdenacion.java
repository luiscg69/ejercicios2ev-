package unidad4;

public class MetodosOrdenacion {

	public static void insercionDirecta(int [] v) {
		for (int i=1; i<v.length; i++) {
			int j = 0;
			while (j < i && v[i] > v[j])
				j++;
			if (j < i) {
				int aux = v[i];
				for (int k=i; k>j; k--)
					v[k] = v[k - 1];
				v[j] = aux;
			}
		}
	}
	
	public static void seleccionDirecta(int [] v) {
		for (int i=0; i<v.length - 1; i++) {
			int min = i;
			for (int j=i+1; j<v.length; j++)
				if (v[j] < v[min])
					min = j;
			if (min != i) {
				int aux = v[i];
				v[i] = v[min];
				v[min] = aux;
			}
		}
	}

	public static void intercambioDirecto(int [] v) {
		for (int i=0; i<v.length - 1; i++) {
			for (int k=v.length - 1; k>i; k--) {
				if (v[k] < v[k - 1]) {
					int aux = v[k];
					v[k] = v[k - 1];
					v[k - 1] = aux;
				}
			}
		}
	}
	
}
