package repaso2ev;

//Ejercicio de Repaso 2ª Evaluación - Automóviles CIFP Avilés 1º DAW

//Programación Clase Automovil
//
//Created by Luis Cortes. Date 26-03-2020
//Modified final 1 by Luis Cortes. Date 28-03-2020
//Modified final 2 by Luis Cortes. Date 30-03-2020
//Modified final 3 by Luis Cortes. Date 03-04-2020

public class Automovil {

	// Definimos los atributos de la clase como privados.
	private String modelo;
	private double capacidadDeposito;
	private double combustibleEnDeposito;
	private double consumo;
	private double distanciaRecorrida;
	private double combustibleConsumido;

	// Primer constructor de la clase se tiene que llamar Automovil como la clase, y
	// tiene 4 parametros
	public Automovil(String modelo, double capacidadDeposito, double combustibleEnDeposito, double consumo) {

		// iniciamos los atributos unos los iniciamos con sus parametros y otros con el
		// valor 0
		// this.modelo nos referimos al modelo de esta clase
		// this.capacidadDeposito nos referimos a la capacidad de esta clase
		// this.. es para referenciar a los atributos de esta clase y no confundirlos
		// con los posibles atributos de otras clase con el mismo nombre

		this.modelo = modelo;
		this.capacidadDeposito = capacidadDeposito;
		this.combustibleEnDeposito = combustibleEnDeposito;
		this.consumo = consumo;
		this.distanciaRecorrida = 0;
		this.combustibleConsumido = 0;
	}

	// Como definimos los atributos como privados definimos los metodos publicos
	// Setters para poder cambiar o dar el valor inicial del valor de los atributos
	// Getters para poder obtener su valor por otro metodo

	public String getmodelo() {
		return this.modelo;
	}

	public double getcapacidadDeposito() {
		return this.capacidadDeposito;
	}

	public double getcombustibleEnDeposito() {
		return this.combustibleEnDeposito;
	}

	public double getconsumo() {
		return this.consumo;
	}

	public double getdistanciaRecorrida() {
		return this.distanciaRecorrida;
	}

	public double getcombustibleConsumido() {
		return this.combustibleConsumido;
	}

	public void setmodelo(String modelo) {
		this.modelo = modelo;
	}

	public void setcapacidadDeposito(double capacidadDeposito) {
		this.capacidadDeposito = capacidadDeposito;
	}

	public void setcombustibleEnDeposito(double combustibleEnDeposito) {
		this.combustibleEnDeposito = combustibleEnDeposito;
	}

	public void setconsumo(double consumo) {
		this.consumo = consumo;
	}

	public void setdistanciaRecorrida(double distanciaRecorrida) {
		this.distanciaRecorrida = distanciaRecorrida;
	}

	public void setcombustibleConsumido(double combustibleConsumido) {
		this.combustibleConsumido = combustibleConsumido;
	}

	// Metodo de la clase Automovil "desplazase" donde se van introduciendo los Km
	// de cada desplazamiento

	public boolean desplazarse(double km) {

		// valoramos si los Km que quermos deplazarnos podemos hacerlo
		// si los kilometros que queremos deplazarnos son menores a los que podemos
		// desplazarnos con el comustibkle que tenemos entonces podemos desplazarnos

		if (km <= ((this.combustibleEnDeposito) / (this.consumo))) {

			// Si nos podemos desplazar entonces cambiamos el valor de ciertos atributos del
			// objeto creado

			this.distanciaRecorrida = this.distanciaRecorrida + km; // La distancia total recorrida sera la ya recorrida
																	// + la realizada por este recorrido
			this.combustibleConsumido = this.distanciaRecorrida * this.consumo; // El combustible total consumido, es la
																				// distancia to
			this.combustibleEnDeposito = this.combustibleEnDeposito - (km * this.consumo); // El combustible en el
																							// deposito es el comustible
																							// que tenia menos lo que
																							// consumido en este
																							// desplazamiento

			return true; // devuelvo true
		}
		// Sino se pudo realizar el desplazamiento devuelvo false
		return false;// devuelvo false no puedo realizar este desplazamiento
	}
}
