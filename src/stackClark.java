package p1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class stackClark<Item> implements Iterable<Item> {
	public int id;
	private int nsize;
	private Node top;

	class Node {
		double price;
		Item item;
		int id;
		Node next;
	}

	public stackClark() {
		top = null;
		nsize = 0;

	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return nsize;
	}

	public void push(Item item, double price) {
		Node oldfirst = top;
		top = new Node();
		top.item = item;
		if (id > 0) {
			id++;
		} else {
			id = 1;
		}
		top.id = id;
		top.price = price;
		top.next = oldfirst;
		nsize++;
	}

	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("list is empteh");
		Item item = top.item;
		top = top.next;
		nsize--;

		return item;
	}

	void remove(int key) {

		Node temp = top, prev = null;
		if (temp != null && temp.id == key) {
			return;
		}
		while (temp != null && temp.id != key) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return;
		prev.next = temp.next;
	}

	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("list es empteh");
		return top.item;
	}

	public String Find(int idd) {
		StringBuilder boot = new StringBuilder();
		Node current = top;

		for (Item item : this) {

			if (current.id == (idd)) {
				boot.append(
						"[id=" + current.id + ", PRICE = $" + current.price + ", Item =" + current.item + "]" + "\n");

			}
			item = current.item;
			current = current.next;
		}
		return boot.toString();

	}
	
	public double findD(double key) {
	
		Node current = top;

		for (Item item : this) {

			if (current.id == (key)) {
				return current.price;

			}
			item = current.item;
			current = current.next;
		}
		return current.price;

	}
	
	

	public String toString() {
		StringBuilder doot = new StringBuilder();
		Node current = top;

		for (Item item : this) {
			doot.append("[id=" + current.id + ", PRICE = $" + current.price + ", Item =" + current.item + "]" + "\n");
			item = current.item;
			current = current.next;
		}
		System.out.println();
		return doot.toString();
	}

	public void sort() {

		Node current = top;
		Node previous = null;
		Node next = top.next;

		 
	
		while (next != null) {
			if (current.id > next.id) {

				if (previous != null) {
					Node sig = next.next;

					previous.next = next;
					next.next = current;
					current.next = sig;
				} else {
					Node sig = next.next;

					top = next;
					next.next = current;
					current.next = sig;
				}

				previous = next;
				next = current.next;
			} else {
				previous = current;
				current = next;
				next = next.next;
			}
		}
	}
	

	public stackClark<Item>.Node addcheckout(int id) {

		Node current = top;

		for (Item item : this) {

			if (current.id == (id)) {
			return current;
				
			}
			item = current.item;
			current = current.next;
		}
		
		
		return current;
		
		
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = top;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}
