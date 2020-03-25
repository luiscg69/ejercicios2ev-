package unidad4.colecciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

/*
  
ROB-15;SS2-10;NX8000-3
08:00:00
disco duro
procesador
memoria RAM
placa base
fin 
  
 */

public class Ejercicio8 {

	public static void main(String[] args) throws IOException {
		LinkedList<Robot> activos = new LinkedList<>();
		LinkedList<Robot> inactivos = new LinkedList<>();
		LinkedList<String> productos = new LinkedList<>();
		LocalTime hora = leerDatos(inactivos, productos);
		while (!productos.isEmpty()) {
			hora = hora.plusSeconds(1);
			procesar(activos, inactivos);
			String producto = productos.remove();
			if (inactivos.isEmpty())
				productos.add(producto);
			else {
				Robot robot = inactivos.remove();
				robot.addProducto(producto);
				activos.add(robot);
				System.out.println(robot.getNombre() + " - " + producto + " - " + hora);
			}
		}
	}
	
	static LocalTime leerDatos(LinkedList<Robot> inactivos, LinkedList<String> productos) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		for (String s: in.readLine().split(";")) {
			String[] datosRobot = s.split("-");
			inactivos.add(new Robot(datosRobot[0], Integer.parseInt(datosRobot[1])));
		}
			
		LocalTime hora = LocalTime.parse(in.readLine(), DateTimeFormatter.ISO_TIME);
		
		String linea;
		while (!(linea = in.readLine()).trim().toLowerCase().equals("fin"))
			productos.add(linea);
		
		return hora;
	}
	
	static void procesar(LinkedList<Robot> activos, LinkedList<Robot> inactivos) {
		Iterator<Robot> i = activos.iterator();
		while (i.hasNext()) {
			Robot robot = i.next();
			if (!robot.procesar()) {
				i.remove();
				inactivos.add(robot);
			}
		}
	}
	
}
