import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl<M> implements StringStack<M> {
	
	private Node head;
	private M item;
	private int currentSize;
	
	private class Node {
		M item;
		Node next;
		public Node(M item) {
			this.item = item;
			next = null;
		}
	}
	
	public StringStackImpl() {
		currentSize = 0;
		head = null;
						
	}
	
	public boolean isEmpty() {
		return currentSize == 0;
	}
	
	public void push(M item) {
		Node newString = new Node(item);
		if (head == null) {
			head = newString;
		} else {
			newString.next = head;
			head = newString;
		}
		currentSize++;
	}
	
	public M pop() {
		
		if(isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		
		
		Node n = head;
		head = head.next;
		currentSize--;
		
		return n.item;
	}
	
	
	public M peek() throws NoSuchElementException
	{
		if(isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		
		return head.item;
	}
	
	public void printStack(PrintStream stream)
	{
		for(Node i=head; i != null; i=i.next)
		{
			stream.print(i.item);
		}
	}
	
	public int size(){
		return currentSize;
	}

}
