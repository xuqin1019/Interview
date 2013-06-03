package jp.co.wap.exam;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * The Queue class represents an immutable first-in-first-out(FIFO) queue of objects.
 *@param <E>
 * 
 */

public class PersistentQueue<E> {
	private final Stack<E> s1;
	private final Stack<E> s2;
	
	public PersistentQueue() {
		//modify this constructor if necessary , but do not remove it
		s1=new Stack<E>();
		s2=new Stack<E>();
	}
	
	private PersistentQueue(Stack<E> s1 , Stack<E> s2) {
		//modify or remove this constructor if necessary
		this.s1 = s1;
		this.s2 = s2;
	}
	
	//add other constructor if necessary
	public PersistentQueue<E> enqueue(E e) {
		//TODO: make this method faster
		if(e==null) {
			throw new IllegalArgumentException();
		}
		Stack<E> cloneS1 = (Stack<E>) s1.clone();
		cloneS1.push(e);
		return new PersistentQueue<E>(cloneS1,s2);
	}
	
	public PersistentQueue<E> dequeue() {
		//TODO: make this method faster
		if(s1.empty() && s2.empty()) {
			throw new NoSuchElementException();
		}
		if(!s2.empty()) {
			Stack<E> cloneS2 = (Stack<E>) s2.clone(); 
			cloneS2.pop();
			return new PersistentQueue<E>(s1, cloneS2);
		}
		Stack<E> cloneS1 = (Stack<E>) s1.clone();
		Stack<E> cloneS2 = (Stack<E>) s2.clone();
		while(!cloneS1.empty()) {
			cloneS2.push(cloneS1.pop());
		}
		cloneS2.pop();
		return new PersistentQueue<E>(cloneS1,cloneS2);
	}
	
	public E peek() {
		//modify this method if needed
		if(s1.isEmpty() && s2.empty()) {
			throw new NoSuchElementException();
		}
		
		if(!s2.empty()) {
			return s2.peek();
		}
		Stack<E> cloneS1 = (Stack<E>) s1.clone();
		Stack<E> cloneS2 = (Stack<E>) s2.clone();
		while(!cloneS1.empty()) {
			cloneS2.push(cloneS1.pop());
		}
		return cloneS2.peek();
	}
	
	public int size() {
		//modify this method if necessary
		return s1.size() + s2.size();
	}
}
