package jp.co.wap.exam;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The Queue class represents an immutable first-in-first-out(FIFO) queue of objects.
 *@param <E>
 * 
 */

public class PersistentQueue1<E> {
	private final List<E> s1;
	private final List<E> s2;
	
	public PersistentQueue1() {
		//modify this constructor if necessary , but do not remove it
		s1=new ArrayList<E>();
		s2=new ArrayList<E>();
	}
	
	private PersistentQueue1(List<E> s1 , List<E> s2) {
		//modify or remove this constructor if necessary
		this.s1 = s1;
		this.s2 = s2;
	}
	
	//add other constructor if necessary
	public PersistentQueue1<E> enqueue(E e) {
		//TODO: make this method faster
		if(e==null) {
			throw new IllegalArgumentException();
		}
		List<E> cloneS1 = new ArrayList<E>(s1);
		cloneS1.add(e);
		return new PersistentQueue1<E>(cloneS1,s2);
	}
	
	public PersistentQueue1<E> dequeue() {
		//TODO: make this method faster
		if(s1.isEmpty() && s2.isEmpty()) {
			throw new NoSuchElementException();
		}
		if(!s2.isEmpty()) {
			List<E> cloneS2 = new ArrayList<E>(s2); 
			cloneS2.remove(cloneS2.size()-1);
			return new PersistentQueue1<E>(s1, cloneS2);
		}
		List<E> cloneS1 =  new ArrayList<E>(s1);
		List<E> cloneS2 = new ArrayList<E>(s2);
		while(!cloneS1.isEmpty()) {
			cloneS2.add(cloneS1.remove(cloneS1.size()-1));
		}
		cloneS2.remove(cloneS2.size()-1);
		return new PersistentQueue1<E>(cloneS1,cloneS2);
	}
	
	public E peek() {
		//modify this method if needed
		if(s1.isEmpty() && s2.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		if(!s2.isEmpty()) {
			return s2.get(s2.size()-1);
		} else {
			return s1.get(0);
		}
		
	}
	
	public int size() {
		//modify this method if necessary
		return s1.size() + s2.size();
	}
}
