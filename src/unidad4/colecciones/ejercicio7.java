package unidad4.colecciones;

import java.util.*;

public class ejercicio7 
{

	public static void main(String[] args) 
	{

		Scanner sc=new Scanner(System.in);

		Map<String,Integer>jugadores_puntuacion=new HashMap<>();
		Map<String,Integer>rangos_valor=new HashMap<>();
		Map<String,Integer>palos_valor=new HashMap<>();

		rangos_valor.put("2", 2);
		rangos_valor.put("3", 3);
		rangos_valor.put("4", 4);
		rangos_valor.put("5", 5);
		rangos_valor.put("6", 6);
		rangos_valor.put("7", 7);
		rangos_valor.put("8", 8);
		rangos_valor.put("9", 9);
		rangos_valor.put("10", 10);
		rangos_valor.put("J", 11);
		rangos_valor.put("Q", 12);
		rangos_valor.put("K", 13);
		rangos_valor.put("A", 14);

		palos_valor.put("S", 4);
		palos_valor.put("H", 3);
		palos_valor.put("D", 2);
		palos_valor.put("C", 1);

		boolean leer_datos=true;


		while(leer_datos==true) 
		{
			System.out.println("ingrese datos:");			
			String entrada=sc.nextLine();

			if (!entrada.equals("fin"))
			{
				tratar_entrada(jugadores_puntuacion,entrada,rangos_valor,palos_valor);
			}
			else 
			{
				leer_datos=false;
				System.out.println(jugadores_puntuacion.toString());
			}

		}




	}


	public static void tratar_entrada(Map<String,Integer>jugadores_puntuacion,String entrada,Map<String,Integer>rangos_valor,Map<String,Integer>palos_valor)
	{
		entrada=entrada.toUpperCase();
		String[]jugador_cartas=entrada.split(":");//saco el jugador y todas las cartas
		String[]cartas=jugador_cartas[1].split(" ");//saco las cartas
		Set<String>cartas_no_repetidas=new HashSet();
		Integer suma_jugada=0;
		for(int i=0;i<cartas.length;i++) 
		{
			if (cartas[i].equals(""))//si empieza con espacio pasamos al siguiente.
			{
				i++;
			}
			if(cartas_no_repetidas.add(cartas[i])!=false)//.add devuelve false si el valor está repetido, y no lo añade
			{

				suma_jugada=suma_jugada+contar_mano(cartas[i],rangos_valor, palos_valor);

			}

		}

		if(jugadores_puntuacion.containsKey(jugador_cartas[0]))
		{
			Integer puntuacion=jugadores_puntuacion.get(jugador_cartas[0]);
			puntuacion=puntuacion+suma_jugada;
			jugadores_puntuacion.put(jugador_cartas[0], puntuacion);
		}
		else 
		{
			jugadores_puntuacion.put(jugador_cartas[0], suma_jugada);
		}
	}

	public static Integer contar_mano(String carta,Map<String,Integer>rangos_valor,Map<String,Integer>palos_valor)
	{

		Integer valor=0;

		String rango=Character.toString(carta.charAt(0));

		valor=valor+rangos_valor.get(rango);
		String palo=Character.toString(carta.charAt(1));
		valor=valor*(palos_valor.get(palo));

		return valor;

	}


}