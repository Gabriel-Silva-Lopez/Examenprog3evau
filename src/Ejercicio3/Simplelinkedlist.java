package Ejercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simplelinkedlist {
	private Node first;
	//private Node last;
	private int size;
	
	public Simplelinkedlist () {
		this.first = null;
		this.size = 0;
	}
	
	public Simplelinkedlist (Node first) {
		this.first = first;
		this.size = 1;
	}

	public Node getFirst() {
		return first;
	}

	public void setFirst(Node first) {
		this.first = first;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public boolean add(Node node) {
		try {
			if(size == 0) {
				first = node;
			} else {
				Node p = first;
				for(int i = 1; i < size; i++) {
					p = p.getNext();
				}
				p.setNext(node);
			}
			size++;
			//last.setNext(node);
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean add(int position, Node node) {
		try {
			if(position == 0) {
				node.setNext(first);
				first = node;
			} 
			else if (position == size) {
				return add(node);
			} else {
				Node p = first;
				for (int i = 1; i < position; i++) {
					p = p.getNext();
				}
				node.setNext(p.getNext());
				p.setNext(node);
			}
			size++;
			return true;
		} catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public boolean delete(int position) {
		try {
			Node p = first;
			if(position == 0) {
				first = p.getNext();
			} 
			else if(position == size) {
				for(int i = 0; i < size; i++) {
					p = p.getNext();
				}
			} else {
				for(int i = 1; i < position; i++) {
					p = p.getNext();
				}
				 p.setNext(p.getNext().getNext());
			}
				size--;
			return true;	
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;
		}
	}
	
	public Node get(int position) {
		try {

			if(position >= 0 && position < size) {
				Node p = first; 
				for(int i = 1; i <= position; i++) {
					p = p.getNext();
				}
				System.out.println("[ " + (position+1) + " ] -> " + p.getContent());
				return p;
			}
			return null;
		} catch(Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	public void show() {
		Node p = first;
		for(int i = 0; i < size; i++) {
			System.out.println("[ " + i + " ] -> " + p.getContent());
			p = p.getNext();
		}
	}
	
	public void eliminarMayor () {
		Node p = first;
		ArrayList <Integer> enteros = new ArrayList<Integer>();
		if(size > 0) {
			for(int i = 0; i < size; i++) {
						enteros.add(p.getContent());
						p = p.getNext();
			}
			Collections.sort(enteros);
			for(int i = 0; i < size; i++) {
				if(p.getContent() == enteros.get(0)) {
					delete(i);
				}
			}
		}
	}

}
