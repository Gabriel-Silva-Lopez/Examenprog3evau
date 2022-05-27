package Ejercicio2;

import java.io.File;
import java.util.Scanner;
public class Ejercicio2 {

	/**Ejercicio 2: Disponemos del fichero Divorcios.csv, que contiene la información sobre los divorcios
	en España según exista o no separación previa, separado por localidades y años (estos datos
	pertenecen al Instituto Nacional de Estadística). Queremos desarrollar un programa Java que sea
	capaz de mostrar por pantalla:
		1. El número total de divorcios CON separación previa en el año 2019.
		2. El número total de divorcios SIN separación previa en el año 2018.
	3. La localidad cuyo número de divorcios (suma de ambos) desde 2013 hasta 2019 haya sido mayor.**/
	
	
	public static void main(String[] args) {
		divorcios("C:/examenprog3evau/Divorcios.csv");
	}
	
	public static void divorcios (String fichero) {
		try {
			File file = new File(fichero);
			divorcios2019s(file);
			divorcios2018n(file);
		} catch (Exception e) {
			
		}
	}
	
	public static void divorcios2019s (File file) {
		try {
			int num = 0;
			Scanner f = new Scanner(file);
			f.nextLine(); // salto linea
			while(f.hasNextLine()) {
				String linea = f.nextLine().trim();
				String separacion  = linea.split(";")[1];
				String total  = linea.split(";")[3];
				if(separacion.equalsIgnoreCase("Si")) {
					int personas = Integer.parseInt(total);
					num = num + personas;
				}
			}
			System.out.println("El número total de divorcios CON separación previa en el año 2019" + num);
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void divorcios2018n (File file) {
		try {
			int num = 0;
			Scanner f = new Scanner(file);
			f.nextLine(); // salto linea
			while(f.hasNextLine()) {
				String linea = f.nextLine().trim();
				String separacion  = linea.split(";")[1];
				String total  = linea.split(";")[3];
				if(separacion.equalsIgnoreCase("No")) {
					int personas = Integer.parseInt(total);
					num = num + personas;
				}
			}
			System.out.println("El número total de divorcios SIN separación previa en el año 2018:" + num);
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
