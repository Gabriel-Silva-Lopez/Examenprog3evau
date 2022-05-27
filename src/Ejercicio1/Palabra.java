package Ejercicio1;

public class Palabra {
	/*Este es el objeto palabra que contiene la palabra y su linea para ser añadidas
	 * en la base de datos*/
	
	private String str;
	private int linea;
	
	//Constructores
	public Palabra(String str, int linea) {
		this.str = str;
		this.linea = linea;
	}
	
	public Palabra() {}

	//Getters y setters
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}
}
