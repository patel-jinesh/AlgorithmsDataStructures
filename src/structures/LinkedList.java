package structures;

public class LinkedList<T> {
	private class Node {
		T value;
		Node next;
		
		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}
	
	public enum Insertion {
		HEAD,
		TAIL
	}
	
	private int size = 0;
	
	private Node head = null;
	private Node tail = null;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void insert(T value, Insertion location) {
		if (isEmpty()) {
			head = new Node(value, null);
			tail = head;
		} else if (location == Insertion.HEAD) {
			head = new Node(value, head);
		} else {
			Node n = new Node(value, null);
			tail.next = n;
			tail = n;
		}
		size++;
	}
	
	public void insert(T value, int n) {
		if (n > size)
			throw new IllegalArgumentException();
		
		Node point = head;
		
		for (; n > 0; n--)
			point = point.next;
		
		point.next = new Node(value, point.next);
	}
	
	public void delete(T value) {
		
	}
	
	public void delete(int n) {
		
	}
	
	public void delete(Insertion location) {
		
	}
}
