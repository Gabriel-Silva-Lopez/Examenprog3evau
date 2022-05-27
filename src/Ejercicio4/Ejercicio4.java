package Ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
	/*
	Ejercicio 4: Implementa un método recursivo en Java llamado tablaMultiplicar() que muestre por
	pantalla la tabla de multiplicar (únicamente de los multiplicadores pares) del número solicitado
	(hasta multiplicar por 100).*/
	
	
	/**
	 * Pre:-----------
	 * Post: Metodo que muestra la tabla de multiplicar un numero hasta 100, saltando
	 * los impares
	 */
	private static int multiplicarPares(int n, int i) {
			if(i != 100) {
				if(i%2==0) {
					System.out.println(n + " x " + i + " = " + n*i);
					return multiplicarPares(n, i+1);
				} else {
					return multiplicarPares(n, i+1);	
				}
			} else {
				System.out.println(n + " x " + i + " = " + n*100);
				return 0;
			}			
	}
	
	/**
	 * Pre:-----------
	 * Post: Metodo que llama al private multiplicarPares para mostrar la lista de multiplicar
	 * de un numero
	 */
	public static void multiplicarPares(int n) {
		multiplicarPares(n, 0);
	}
	
	/**
	 * Pre:-----------
	 * Post: Metodo main que ejecuta el programa y permite al usuario ingresar un numero
	 */
	public static void main(String[] arg) {
		Scanner s = new Scanner(System.in);
		try {
			System.out.print("Dame un numero para ver la tabla de multiplicar:");
			multiplicarPares(Integer.parseInt(s.next()));
			s.close();	
		} catch (Exception e) {
			System.out.println("Has introducido mal los datos");
		}
	}

}
