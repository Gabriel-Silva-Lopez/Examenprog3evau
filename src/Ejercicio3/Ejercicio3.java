package Ejercicio3;

public class Ejercicio3 {
	
	/*Ejercicio 3: Partiendo de la implementación de una Lista Simple Enlazada vista en clase (con nodos
			cuyo contenido sea de tipo entero), diseña un nuevo método llamado eliminarMayor() que se
			encargue de eliminar el nodo cuyo contenido tenga el número mayor de la lista.*/
	
	/**
	 * Pre:-----------
	 * Post: Metodo main que crea una lista de nodos y elmina el mayor
	 */
	public static void main(String[] args) {
		Simplelinkedlist l = new Simplelinkedlist();
		Node n1 = new Node(40, null);
		l.add(n1);
		l.show();
		System.out.println("----------------");
		Node n2 = new Node(80, null);
		l.add(n2);
		l.show();
		System.out.println("----------------");
		Node n3 = new Node(10, null);
		l.add(n3);
		l.show();
		System.out.println("----------------");
		Node n4 = new Node(75, null);
		l.add(n4);
		l.show();
		System.out.println("----------------");
		l.eliminarMayor();
		l.show();
		System.out.println("----------------");
		l.eliminarMayor();
		l.show();
	}
}
