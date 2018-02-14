package structures;

public class Stack<T> {
	private class Node<Item> {
		private Item value;
		private Node<Item> next;
		
		public Node(Item value) {
			this.value = value;
		}
		
		public Node(Item value, Node<Item> next) {
			this.value = value;
			this.next = next;
		}
		
		public Item getValue() {
			return this.value;
		}
		
		public void setValue(Item value) {
			this.value = value;
		}
		
		public Node<Item> getNext() {
			return this.next;
		}
		
		public void setNext(Node<Item> next) {
			this.next = next;
		}
	}
	
	private Node<T> head = null;
	private int size = 0;
	
	public void push(T value) {
		Node<T> node = new Node<T>(value, this.head);
		this.head = node;
		size++;
	}
	
	public T pop() throws Exception {
		if (isEmpty())
			throw new Exception("Empty stack.");
		
		Node<T> node = head;
		T value = head.getValue();
		head = node.getNext();
		node = null;
		size--;
		return value;
	}
	
	public T peek() throws Exception {
		if (isEmpty())
			throw new Exception("Empty stack.");
		
		return head.getValue();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
}
