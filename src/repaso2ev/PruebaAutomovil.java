package repaso2ev;

//Ejercicio de Repaso 2ª Evaluación - Prueva Automóviles CIFP Avilés 1º DAW

//Programación Clase PruevaAutomovil
//
//Created by Luis Cortes. Date 26-03-2020
//Modified final 1 by Luis Cortes. Date 28-03-2020
//Modified final 2 by Luis Cortes. Date 30-03-2020
//Modified final 3 by Luis Cortes. Date 01-04-2020
//Modified final 4 by Luis Cortes. Date 02-04-2020 FINAL

import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class PruebaAutomovil {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);// Creamos un objeto de la clase Scanner que cogera los datos introduccidos
											// por consola

		// N tomara el valor de la lo metido por consola y como es un String lo
		// convertimos a un entero N será el numero de automoviles
		int N = Integer.parseInt(in.nextLine());

		// Para introduccir los datos de los automoviles utilizaremos un TreeMap del
		// tipo Key, Value (objeto de la clase Automovil)
		// Donde el Key será el modelo de vehiculo y no permitimos valores nulos
		// (TreeMap no admite valores nulos para la clave)
		// El valor será un objeto de la clase Automovil

		Map<String, Automovil> DatosAutomovil = new TreeMap<String, Automovil>();

		// Ahora vamos a meter datos de Modelos de coches tantas veces como habiamos
		// dicho que valia N
		// Para ello utilizaremos un bucle for que va a iteratuar desde 0 hasta que N-1
		// (<N), en cada iteración le sumaremos 1

		for (int i = 0; i < N; i = i + 1) {

			// Introducimos en una sola linea los datos del automovil (modelo, capacidad del
			// deposito, litros en el deposito, y consumo.
			// Esta cadena mediante el metodo Sting.split la divideremos en pequeños trozos
			// (tokens) el separador es uno o varios espacios en blanco

			String[] tokens = in.nextLine().split("\\s+");

			// Declaramos las variables y cada una de ellas le damos el valor de cada
			// trocito (token), teniendo en cuenta que cada token es un String
			// Por lo tanto haremos una conversion de tipo para aquellos String que lo
			// requieran

			String modelo = tokens[0];
			float capacidadDeposito = Float.parseFloat(tokens[1]);
			float combustibleEnDeposito = Float.parseFloat(tokens[2]);
			float consumo = Float.parseFloat(tokens[3]);

			// introduzco en el TreeMap como clave el valor de modelo, y como valor un nuevo
			// objeto de la clase Automovil siendo sus parametros los datos obtenidos
			// anteriormente

			DatosAutomovil.put(modelo, new Automovil(modelo, capacidadDeposito, combustibleEnDeposito, consumo));

		}

		// Declaro una variable de tipo String "desplazamientos" que va ser igual a lo
		// introduccido por consola que es cada desplazamiento de cada Automvil
		// Se ejecutara un codigo mientras el texto introduccido por consola sea
		// distinto de fin

		String desplazamientos;
		while (!"fin".equals(desplazamientos = in.nextLine())) {

			// Como lo introduccido por consola no fue fin y fueron los datos en una sola
			// linea del deplazamiento: <texto> <modelo> <kilometros>
			// Divido esta liena en trocitos (tokens), separador uno o varios espacios en
			// blanco

			String[] tokens = desplazamientos.split("\\s+");

			// el primer trozo introducido será desplazar como viene en el enunciado o Drive
			// como viene en los ejemplo, no se tiene en cuenta. solamente que sea un texto

			// el segundo trozo es el modelo de coche,
			String modelo1 = tokens[1];

			// el tercer trozo son los kilometros que supuestamente se va a desplazar
			float Kilometros = Float.parseFloat(tokens[2]);

			/**
			 * llamo al metodo de la clase Automovil desplazarse como parametro los Km para
			 * el Automovil como modelo el introducido y me devuelve true o false si se
			 * puede desplazar (true) o no (False) Si se pudo desplazar porque tenia
			 * bastante conbustible se actualizan todos los datos de ese automovil Distancia
			 * total reorrida Combustible total Consumido Comustible que queda en el
			 * deposito
			 * 
			 */
			boolean posibledeslazamiento = DatosAutomovil.get(modelo1).desplazarse(Kilometros);
			// guardado en el mapa con la clave (auto), que devuelve un valor

			if (posibledeslazamiento == false) // sino es posible desplazamiento devolvio false
			{
				System.out.println("Combustible insuficiente para este desplazamiento");
			} else // fue posible el deplazamiento
			{
				/**
				 * Saco por pantalla formateado Voy al TreeHash y busco el indice el modelo de
				 * Automovil, y como en valor de este tengo el objeto de ese mismo Automvil,
				 * atraves del getter cojo los valores que necesito que serán los ultimos que ha
				 * tenido cada uno de los modelos de automvil. Para el modelo cojo el modelo
				 * (aunque podria haber puesto el propio modelo1 o el indice de TreeMap) de esta
				 * manerá pruebo el getter Para el combustible en el deposito cojo la cantidad
				 * através de su getter Para el consumo de este viaje, cojo el consumo de este
				 * modelo de coche atraves de su getter y lo multiplico por los Kilometros de
				 * este viaje.
				 * 
				 */
				System.out.printf("%s %.2f %.2f%n", DatosAutomovil.get(modelo1).getmodelo(),
						DatosAutomovil.get(modelo1).getcombustibleEnDeposito(),
						(DatosAutomovil.get(modelo1).getconsumo() * Kilometros));
			}

		}

		System.out.println("--------------------------------"); // Imprimimos las rallitas

		// Cuando se escribio "fin" vamos a imprimir los datos que nos piden de cada uno
		// de los modelos de coche que tenemos en el TreeHash
		// Para cada una de las key de TreeMap
		for (String keymodelo : DatosAutomovil.keySet()) {
			// imprimimos modelo, combsutible en el deposito, distancia recorrida y
			// combustible consumido
			System.out.printf("%s %.2f %.0f %.2f%n", DatosAutomovil.get(keymodelo).getmodelo(),
					DatosAutomovil.get(keymodelo).getcombustibleEnDeposito(),
					DatosAutomovil.get(keymodelo).getdistanciaRecorrida(),
					DatosAutomovil.get(keymodelo).getcombustibleConsumido());
		}
		in.close();

	}
	/**
	 * 
2
AudiA4 80 23 0.3
BMW-M2 75 45 0.42
desplazar AudiA4 5
desplazar BMW-M2 56
desplazar AudiA4 13
fin
	 * 
	 * AudiA4 21.50 1.50
	 * 
	 * BMW-M2 21.48 23.52
	 * 
	 * AudiA4 17.60 3.90
	 * 
	 * -------------------
	 * 
	 * AudiA4 17.60 18 5.40
	 * 
	 * BMW-M2 21.48 56 23.52
	 * 
	 * 
	 * 
3
AudiA4 80 18 0.34
BMW-M2 75 33 0.41
Ferrari-488Spider 70 50 0.47
desplazar Ferrari-488Spider 97
desplazar AudiA4 85
desplazar Ferrari-488Spider 35
desplazar AudiA4 50
fin
     
     * 
     * 
     * Ferrari-488Spider 4.41 45.59
	 * 
	 * Combustible insuficiente para este desplazamiento
	 * 
	 * AudiA4 1.00 17.00
	 * 
	 * Combustible insuficiente para este desplazamiento
	 * 
	 * --------------------------------
	 * 
	 * AudiA4 1.00 50 17.00
	 * 
	 * BMW-M2 33.00 0 0.00
	 * 
	 * Ferrari-488Spider 4.41 97 45.59
	 * 
	 */
}