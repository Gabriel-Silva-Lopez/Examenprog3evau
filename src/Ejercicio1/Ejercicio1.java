package Ejercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
	
	/**Ejercicio 1: Queremos desarrollar un programa Java que sea capaz de analizar la información de un
	fichero de texto. El algoritmo recibe como parámetro la dirección de un fichero de texto junto a una
	letra del abecedario. El resultado debe mostrar por pantalla cada una de las palabras del texto que
	empiezan o terminan con dicha letra, junto a la l�nea en la que se encuentran.
	Con la finalidad de que la información mostrada por el algoritmo sea persistente, el programa
	deberá almacenarla en una Base de Datos formada por una única tabla, con la siguiente estructura:**/
	
	/**
	 * Pre:-----------
	 * Post: Metodo que ejecuta el programa y pregunta al usuario por una letra para buscar
	 * cuales empiezan y acaban por dicha letra
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		new File("C:\\examenprog3evau").mkdirs(); //creo la carpeta fexamenprog3evau
		System.out.print("dame una letra: ");
		String letra = s.next().substring(0, 1);
		direccion("C:/examenprog3evau/HablanosDelDon.txt", letra);
		s.close();
	}
	
	/**
	 * Pre:-----------
	 * Post: Metodo que pasado una letra y nos agrega a la base los que acaban y empiezan 
	 * por ella
	 */
	public static void direccion(String fichero, String letra) {
		MySQL sql = new MySQL();
		File file = new File(fichero);
		ArrayList<Palabra> lista = new ArrayList<Palabra>();
		try {
			Scanner f = new Scanner(file);
			int num = 0;
			while(f.hasNextLine()) {
				num++;
				String linea = f.nextLine().replaceAll(",", "").replaceAll("\\.", "").replaceAll("¿", "").replaceAll("\\?", "").trim();
				String[] palabras = linea.split(" ");
				for(int i = 0; i < palabras.length; i++) {
					if(palabras[i].substring(0, 1).equalsIgnoreCase(letra) ||
							palabras[i].substring(palabras[i].length()-1, palabras[i].length()).
							equalsIgnoreCase(letra)) {
						lista.add(new Palabra(palabras[i].trim(), num));
					} 
				}
			}
			for(Palabra p : lista) {
				try {
					sql.setDataBase(p);		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			f.close();
			try {
				sql.readDataBase();	
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + fichero + " no ha podido ser abierto.");
		}
	}
}
