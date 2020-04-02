package repaso2ev;

//Ejercicio de Repaso 2ª Evaluación - Automóviles CIFP Avilés 1º DAW

//Programación Clase Automovil
//
//Created by Luis Cortes. Date 26-03-2020
//Modified final 1 by Luis Cortes. Date 28-03-2020
//Modified final 2 by Luis Cortes. Date 30-03-2020
//Modified final 3 by Luis Cortes. Date 01-04-2020
//Modified final 4 by Luis Cortes. Date 02-04-2020 FINAL

public class Automovil {

	// Definimos los atributos de la clase como privados.
	private String modelo;
	private float capacidadDeposito;
	private float combustibleEnDeposito;
	private float consumo;
	private float distanciaRecorrida;
	private float combustibleConsumido;

	// Primer constructor de la clase se tiene que llamar Automovil como la clase, y
	// tiene 4 parametros
	public Automovil(String modelo, float capacidadDeposito, float combustibleEnDeposito, float consumo) {

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

	// Segundo constructor de la clase se tiene que llamar Automovil como la clase,
	// y
	// tiene 3 parametros
	public Automovil(String modelo, float capacidadDeposito, float consumo) {

		// iniciamos los atributos unos los iniciamos con sus parametros y otros con el
		// valor 0
		// this.modelo nos referimos al modelo de esta clase
		// this.capacidadDeposito nos referimos a la capacidad de esta clase
		// this.. es para referenciar a los atributos de esta clase y no confundirlos
		// con los posibles atributos de otras clase con el mismo nombre

		this.modelo = modelo;
		this.capacidadDeposito = capacidadDeposito;
		this.consumo = consumo;
		this.combustibleEnDeposito = capacidadDeposito; // Iniciamos la cantidad en el depostito como la capacidad del
														// deposito
		this.distanciaRecorrida = 0;
		this.combustibleConsumido = 0;

	}

	// Como definimos los atributos como privados definimos los metodos publicos
	// Setters para poder cambiar o dar el valor inicial del valor de los atributos
	// Getters para poder obtener su valor por otro metodo

	public String getmodelo() {
		return this.modelo;
	}

	public float getcapacidadDeposito() {
		return this.capacidadDeposito;
	}

	public float getcombustibleEnDeposito() {
		return this.combustibleEnDeposito;
	}

	public float getconsumo() {
		return this.consumo;
	}

	public float getdistanciaRecorrida() {
		return this.distanciaRecorrida;
	}

	public float getcombustibleConsumido() {
		return this.combustibleConsumido;
	}

	public void setmodelo(String modelo) {
		this.modelo = modelo;
	}

	public void setcapacidadDeposito(float capacidadDeposito) {
		this.capacidadDeposito = capacidadDeposito;
	}

	public void setcombustibleEnDeposito(float combustibleEnDeposito) {
		this.combustibleEnDeposito = combustibleEnDeposito;
	}

	public void setconsumo(float consumo) {
		this.consumo = consumo;
	}

	public void setdistanciaRecorrida(float distanciaRecorrida) {
		this.distanciaRecorrida = distanciaRecorrida;
	}

	public void setcombustibleConsumido(float combustibleConsumido) {
		this.combustibleConsumido = combustibleConsumido;
	}

	// Metodo de la clase Automovil "desplazase" donde se van introduciendo los Km
	// de cada desplazamiento

	public boolean desplazarse(float km) {

		// valoramos si los Km que quermos deplazarnos podemos hacerlo
		// si los kilometros que queremos deplazarnos son menores a los que podemos
		// desplazarnos con el comustibkle que tenemos entonces podemos desplazarnos

		if (km <= ((this.combustibleEnDeposito) / (this.consumo))) {

			// Si nos podemos desplazar entonces cambiamos el valor de ciertos atributos del
			// objeto creado

			this.distanciaRecorrida = this.distanciaRecorrida + km; // La distancia total recorrida sera la ya recorrida
																	// + la realizada por este recorrido
			this.combustibleConsumido = this.distanciaRecorrida * this.consumo; // El combustible total consumido, es la
																				// distancia total recorrida por el
																				// consumo
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

	// ****metodo sobrecargado llenardeposito

	// Version 1 metodo llenardeposito sin parametros, lo ejecuta y llena el
	// deposito es decir los
	// litros en deposito son iguales a la capacidad del deposito
	public void llenardeposito() {

		this.combustibleEnDeposito = this.capacidadDeposito;
	}

	// Version 2 metodo llenardeposito con 1 parametro, que son los litros con los
	// que queremos
	// llenar el deposito y retorna la cantidad de litros sobrantes.

	public float llenardeposito(float combustiblesaechar) {

		// si la cantidad de combustible que hay en el deposito más la que queremos
		// echar, es superior a la capacidad del deposito. retornaremos la cantidad
		// sobrante una vez lleno el deposito es decir, la cantidad sobrante es la
		// difererencia de cantidad de combustible que hay en el deposito más la que
		// queremos
		// echar menos la capacidad del depososito. Y la cantidad de Combustible en el
		// deposito queda lleno

		if ((this.combustibleEnDeposito + combustiblesaechar) > this.capacidadDeposito) {

			float sobrante = (this.combustibleEnDeposito + combustiblesaechar - this.capacidadDeposito);

			this.combustibleEnDeposito = this.capacidadDeposito;

			return sobrante;

		} else

			// sino se cumplio la primera condición es porque la cantidad que queremos echar
			// + la que ya teniamos en el deposito entra en el deposito, actualizamos los
			// litros que tenemos nos quedan en el deposito y por lo tanto no
			// sobra nada, retornamos 0.

			return 0;
	}

}
