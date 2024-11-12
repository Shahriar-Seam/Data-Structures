package stack;

public class SinglyLinkedList<Type> {

	private Node<Type> head;
	private Node<Type> tail;
	private int size;
	
	public SinglyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Type first() {
		if(isEmpty()) {
			return null;
		}
		return head.getElement();
	}
	
	public Type last() {
		if(isEmpty()) {
			return null;
		}
		return tail.getElement();
	}
	
	public void addFirst(Type element) {
		head = new Node<Type>(element, head); 
		if(size == 0) {
			tail = head;
		}
		size++;
	}
	
	public void addLast(Type element) {
		Node<Type> newest = new Node<Type>(element, null);
		if(isEmpty()) {
			head = newest;
		}
		else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	
	public Type removeFirst() {
		if(isEmpty()) {
			return null;
		}
		Type answer = head.getElement();
		head = head.getNext();
		size--;
		if(size == 0) {
			tail = null;
		}
		return answer;
	}
		
	public void showList() {
		Node<Type> temp = head;
		for(int i = 0; i < size; i++) {
			System.out.print(temp.getElement() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}
}
