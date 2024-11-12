package stack;

public class LinkedStack<Type> {

private SinglyLinkedList<Type> list = new SinglyLinkedList<Type>();
	
	public LinkedStack() {
		
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void push(Type element) {
		list.addFirst(element);
	}
	
	public Type top() {
		return list.first();
	}
	
	public Type pop() {
		return list.removeFirst();
	}
}
