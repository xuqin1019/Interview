/**
 * 
 */
package jp.co.wap.exam.test;

import jp.co.wap.exam.PersistentQueue;
import jp.co.wap.exam.PersistentQueueSample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;
/**
 * @author xuqin
 *
 * 
 */
@RunWith(JUnit4.class)
public class PersistentQueueTest {
	@Test 
	public void test() {
		int time = 0;
		PersistentQueue<Integer> persistentQueue = new PersistentQueue<Integer>();
//		for(int i=0;i<10;++i) {
//			persistentQueue=persistentQueue.enqueue(i);
//			time+=persistentQueue.getTimes();
//		}
//		assertEquals(10,persistentQueue.size());
//		for(int i=0;i<10;++i) {
//		//	assertTrue(persistentQueue.peek()==i);
//			persistentQueue = persistentQueue.dequeue();
//			time+=persistentQueue.getTimes();
//		}
//		assertEquals(0,persistentQueue.size());
		
		for(int i=0;i<10;++i) {
			for(int j=0;j<10;++j) {
				persistentQueue=persistentQueue.enqueue(j);
				time+=persistentQueue.getTimes();
			}
			for(int k=0;k<5;++k) {
				persistentQueue = persistentQueue.dequeue();
				time+=persistentQueue.getTimes();
			}
		}
		
		System.out.println(time);
	}
	
	@Test
	public void testSample() {
		int time = 0;
		PersistentQueueSample<Integer> persistentQueue = new PersistentQueueSample<Integer>();
//		for(int i=0;i<10;++i) {
//			persistentQueue=persistentQueue.enqueue(i);
//			time+=persistentQueue.getTimes();
//		}
//		assertEquals(10,persistentQueue.size());
//		for(int i=0;i<10;++i) {
//			assertTrue(persistentQueue.peek()==i);
//			persistentQueue = persistentQueue.dequeue();
//			time+=persistentQueue.getTimes();
//		}
//		assertEquals(0,persistentQueue.size());
		for(int i=0;i<10;++i) {
			for(int j=0;j<10;++j) {
				persistentQueue=persistentQueue.enqueue(j);
				time+=persistentQueue.getTimes();
			}
			for(int k=0;k<5;++k) {
				persistentQueue = persistentQueue.dequeue();
				time+=persistentQueue.getTimes();
			}
		}
		System.out.println(time);
	}
	
}
