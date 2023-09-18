import java.io.PrintStream;
import java.util.NoSuchElementException; 

public class IntQueueImpl<M> implements IntQueue<M> {
	
	private Node head,tail;
	private M item;
	private int currentSize;
	
	private class Node
	{
		M item;
		Node next;
		Node(M item)
		{
			this.item = item;
			next = null;
		}
	}
	
	public IntQueueImpl()
	{
		currentSize = 0;
		head = null;
		tail = null;
	}
	
	public boolean isEmpty()
	{
		return (head == null);
	}
	
	public void put(M item)
	{
		Node integer = new Node(item);
		currentSize++;
		if(isEmpty())
		{
			tail = integer;
			head = tail;
		}
		else
		{
			tail.next = integer;
			tail = integer;	
		}
			
	}
	
	public M get() throws NoSuchElementException
	{
		if(isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		
		Node integer = head;
		if(head == tail)
		{
			head = tail = null;
		}
		else
		{
			head = head.next;
		}
		currentSize--;
		return integer.item;
	}
	
	public M peek() throws NoSuchElementException
	{
		if(isEmpty())
			throw new NoSuchElementException("Underflow Exception");
		
		return head.item;
	}
	
	public void printQueue(PrintStream stream)
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
