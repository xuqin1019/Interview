/**
 * 
 */
package jp.co.wap.exam.test;

import jp.co.wap.exam.PersistentQueue1;
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
public class PersistentQueue1Test {
	@Test 
	public void test() {
		int time = 0;
		PersistentQueue1<Integer> PersistentQueue1 = new PersistentQueue1<Integer>();
		for(int i=0;i<10;++i) {
			PersistentQueue1=PersistentQueue1.enqueue(i);
			//time+=PersistentQueue1.getTimes();
		}
		assertEquals(10,PersistentQueue1.size());
		for(int i=0;i<10;++i) {
			assertTrue(PersistentQueue1.peek()==i);
			PersistentQueue1 = PersistentQueue1.dequeue();
		//	time+=PersistentQueue1.getTimes();
		}
		assertEquals(0,PersistentQueue1.size());
		
//		for(int i=0;i<10;++i) {
//			for(int j=0;j<10;++j) {
//				PersistentQueue1=PersistentQueue1.enqueue(j);
//				time+=PersistentQueue1.getTimes();
//			}
//			for(int k=0;k<5;++k) {
//				PersistentQueue1 = PersistentQueue1.dequeue();
//				time+=PersistentQueue1.getTimes();
//			}
//		}
//		
//		System.out.println(time);
	}
	
	@Test
	public void testSample() {
		int time = 0;
		PersistentQueueSample<Integer> PersistentQueue1 = new PersistentQueueSample<Integer>();
//		for(int i=0;i<10;++i) {
//			PersistentQueue1=PersistentQueue1.enqueue(i);
//			time+=PersistentQueue1.getTimes();
//		}
//		assertEquals(10,PersistentQueue1.size());
//		for(int i=0;i<10;++i) {
//			assertTrue(PersistentQueue1.peek()==i);
//			PersistentQueue1 = PersistentQueue1.dequeue();
//			time+=PersistentQueue1.getTimes();
//		}
//		assertEquals(0,PersistentQueue1.size());
//		for(int i=0;i<10;++i) {
//			for(int j=0;j<10;++j) {
//				PersistentQueue1=PersistentQueue1.enqueue(j);
//				time+=PersistentQueue1.getTimes();
//			}
//			for(int k=0;k<5;++k) {
//				PersistentQueue1 = PersistentQueue1.dequeue();
//				time+=PersistentQueue1.getTimes();
//			}
//		}
//		System.out.println(time);
	}
	
}
