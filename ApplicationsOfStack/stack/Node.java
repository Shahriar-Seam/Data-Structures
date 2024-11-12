package stack;

public class Node<Type> {

	private Type element;
	private Node<Type> next;
	
	public Node(Type element, Node<Type> next) {
		this.element = element;
		this.next = next;
	}
	
	public Type getElement() {
		return element;
	}
	
	public Node<Type> getNext() {
		return next;
	}
	
	public void setNext(Node<Type> node) {
		this.next = node;
	}
}
