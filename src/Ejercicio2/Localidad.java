package Ejercicio2;

public class Localidad  implements Comparable <Localidad> {
	private String nombre;
	private int divorcios;
	
	/*
	 * Constructor para localidad
	 */
	
	public Localidad(String nombre, int divorcios) {
		this.nombre = nombre;
		this.divorcios = divorcios;
	}

	//Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDivorcios() {
		return divorcios;
	}

	public void setDivorcios(int divorcios) {
		this.divorcios = divorcios;
	}
	
	@Override
	public int compareTo(Localidad o) {
		if(o.getDivorcios() < divorcios){
            return -1;
        } else if(o.getDivorcios()==divorcios){
            return 0;
        } else{
            return 1;
        }
	}
}
