
/**
 * 
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).  
 * @author you
 *
 */


import java.util.NoSuchElementException;

public class Queue<T> {

	//TODO:  You need some data to store the queue.  Put the attributes here.
	private QueueElement<T> head;
	private QueueElement<T> tail;
	
	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
	    //TODO: Write the Queue constructor
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
	    //TODO:  Needs to return true when empty and false otherwise
	    return ((this.head == null) && (this.tail == null));
	}
	
	
	/**
	 * Returns the element at the head of the queue
	 */
	public T peek () throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("The queue is empty");
		}
		else {
			return this.head.getElement();
		}
		
	}
	
	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
	    if(isEmpty()) {
	    	throw new NoSuchElementException("The queue is empty");
	    }
	    else if (this.head == this.tail){
	    	this.head = null;
	    	this.tail = null;
	    }
	    else {
	    	this.head = this.head.getNext();
	    }
	}
	
	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (T element) {
	    //Enqueue code is needed here
		QueueElement<T> newElem = new QueueElement<T>(element, null);
		if(isEmpty()) {
			newElem.setNext(this.head);
			this.head = newElem;
			this.tail = newElem;
			this.tail.setNext(null);
		}
		else {
			this.tail.setNext(newElem);
			this.tail = newElem;
			this.tail.setNext(null);
		}
	}
	
	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print(){
		
		if(!isEmpty()) {
			QueueElement<T> tempHead = this.head;
			QueueElement<T> tempTail = this.tail;
			while(tempHead != tempTail) {
				System.out.println(tempHead.getElement().toString());
				tempHead = tempHead.getNext();
			}
			
			System.out.println(tempTail.getElement().toString() + "\n");
		}
	}
}
