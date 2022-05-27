package Ejercicio3;

public class Node {
	/*Este es el puntero/nodo para la lista enlazada simple del ejercicio3*/
	private int content;
	private Node next;
	
	public Node(int content, Node next) {
		this.content = content;
		this.next = next;
	}

	public int getContent() {
		return content;
	}

	public void setContent(int content) {
		this.content = content;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	/**
	 * Pre:-----------
	 * Post: Metodo que pasa a string los datos de un nodo
	 */
	@Override
	public String toString() {
		return "Content = " + content + " Next = " + next;
	}
}
