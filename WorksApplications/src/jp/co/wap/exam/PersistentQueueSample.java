package jp.co.wap.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * The Queue class represents an immutable first-in-first-out(FIFO) queue of objects.
 *@param <E>
 * 
 */
public class PersistentQueueSample<E> {
	private List<E> queue;
	private int time=0;
	
	public int getTimes() {
		return time;
	}

	public void setTimes(int time) {
		this.time = time;
	}

	
	public PersistentQueueSample() {
		//modify this constructor if necessary , but do not remove it
		queue = new ArrayList<E>();
	}
	
	private PersistentQueueSample(List<E> queue) {
		//modify or remove this constructor if necessary
		this.queue = queue;
	}
	
	/**
	 * @param clone
	 * @param time2
	 */
	public PersistentQueueSample(List<E> clone, int time2) {
		// TODO Auto-generated constructor stub
		this.queue = clone;
		this.time=time2;
	}

	//add other constructor if necessary
	public PersistentQueueSample<E> enqueue(E e) {
		//TODO: make this method faster
		if(e==null) {
			throw new IllegalArgumentException();
		}
		List<E> clone = new ArrayList<E>(queue);
		time+=clone.size();
		clone.add(e);
		return new PersistentQueueSample<E>(clone,time);
	}
	
	public PersistentQueueSample<E> dequeue() {
		//TODO: make this method faster
		if(queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		List<E> clone = new ArrayList<E>(queue);
		time+=clone.size();
		clone.remove(0);
		return new PersistentQueueSample<E>(clone,time);
	}
	
	public E peek() {
		//modify this method if needed
		if(queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue.get(0);
	}
	
	public int size() {
		//modify this method if necessary
		return queue.size();
	}
}
