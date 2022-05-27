package Ejercicio1;

public class Palabra {
	private String str;
	private int linea;
	

	public Palabra(String str, int linea) {
		this.str = str;
		this.linea = linea;
	}
	
	public Palabra() {}

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
