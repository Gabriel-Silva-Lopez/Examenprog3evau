package Ejercicio2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ejercicio2 {

	/**Ejercicio 2: Disponemos del fichero Divorcios.csv, que contiene la información sobre los divorcios
	en España según exista o no separación previa, separado por localidades y años (estos datos
	pertenecen al Instituto Nacional de Estadística). Queremos desarrollar un programa Java que sea
	capaz de mostrar por pantalla:
		1. El número total de divorcios CON separación previa en el año 2019.
		2. El número total de divorcios SIN separación previa en el año 2018.
	3. La localidad cuyo número de divorcios (suma de ambos) desde 2013 hasta 2019 haya sido mayor.**/
	
	/**
	 * Pre:-----------
	 * Post: Metodo que ejecuta el programa y pasa una direccion de file al metodo divorciados
	 */	
	public static void main(String[] args) {
		divorcios("C:/examenprog3evau/Divorcios.csv");
	}
	
	/**
	 * Pre:-----------
	 * Post: Metodo que pasa un file a los demas metodos para llevar acabo
	 * las funciones solicitadas
	 */
	public static void divorcios (String fichero) {
		try {
			File file = new File(fichero);
			divorcios2019s(file);
			divorcios2018n(file);
			divorcios2013a2019Localidad(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:-----------
	 * Post: Metodo que muestra el número total de divorcios CON separación previa en el año 2019
	 */
	public static void divorcios2019s (File file) {
		try {
			Integer num = 0;
			Scanner f = new Scanner(file);
			f.nextLine(); // salto linea
			while(f.hasNextLine()) {
				String linea = f.nextLine().trim();
				String separacion  = linea.split(";")[1];
				String total  = linea.split(";")[3];
				if(total.contains(".") && !total.substring(0,1).contains(".")) {
					total = linea.split(";")[3].substring(0,1);
				} else if (total.substring(0,1).contains(".")) {
					total = "0";
				}
				Integer personas = Integer.parseInt(total);
				if(separacion.equalsIgnoreCase("Si")) {
					num = num + personas;
				}
			}
			f.close();
			System.out.println("\nEl número total de divorcios CON separación previa en el año 2019: " + num);
		} catch (Exception e) {
			System.out.println("fallo");
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:-----------
	 * Post: Metodo que muestra el número total de divorcios SIN separación previa en el año 2018
	 */
	public static void divorcios2018n (File file) {
		try {
			int num = 0;
			Scanner f = new Scanner(file);
			f.nextLine(); // salto linea
			while(f.hasNextLine()) {
				String linea = f.nextLine().trim();
				String separacion  = linea.split(";")[1];
				String total  = linea.split(";")[3];
				if(total.contains(".") && !total.substring(0,1).contains(".")) {
					total = linea.split(";")[3].substring(0,1);
				} else if (total.substring(0,1).contains(".")) {
					total = "0";
				}
				if(separacion.equalsIgnoreCase("No")) {
					int personas = Integer.parseInt(total);
					num = num + personas;
				} else {
					
				}
			}
			System.out.println("\nEl número total de divorcios SIN separación previa en el año 2018: " + num);
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:-----------
	 * Post: Metodo que muestra la provincia con mas divorcios del 2013 al 2019
	 */
	public static void divorcios2013a2019Localidad (File file) {
		try {
			ArrayList<Localidad> l = new ArrayList<Localidad>();
			Scanner f = new Scanner(file);
			f.nextLine(); // salto linea
			while(f.hasNextLine()) {
				boolean contiene = false;
				String linea = f.nextLine().trim();
				String localidad  = linea.split(";")[0].substring(3);
				String periodo  = linea.split(";")[2];
				int ano = Integer.parseInt(periodo);
				String total  = linea.split(";")[3];
				if(ano >= 2013 && ano <= 2019) {
					if(total.contains(".") && !total.substring(0,1).contains(".")) {
						total = linea.split(";")[3].substring(0,1);
					} 
					else if (total.substring(0,1).contains(".")) {
						total = "0";
					}
					int personas = Integer.parseInt(total);
					for(int i = 0; i < l.size(); i++) {
						if(l.get(i).getNombre().equalsIgnoreCase(localidad)) {
							l.get(i).setDivorcios(l.get(i).getDivorcios() + personas);
							contiene = true;
						}
					}
					if(contiene == false) {
						l.add(new Localidad(localidad, personas));
					}
				}
			}
			Collections.sort(l);
			System.out.println("\nLa provincia con mas divorcios del 2013 al 2019: " + l.get(0).getNombre() +
					"con un total de " + l.get(0).getDivorcios());
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
