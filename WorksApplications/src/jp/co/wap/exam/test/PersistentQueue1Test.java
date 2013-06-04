/**
 * 
 */
package jp.co.wap.exam.test;

import java.sql.Time;
import java.util.Random;

import jp.co.wap.exam.PersistentQueue;
import jp.co.wap.exam.PersistentQueueSample;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.xuqin.ImmutableList;
import com.xuqin.ImmutableQueue;

import static org.junit.Assert.*;
/**
 * @author xuqin
 *
 * 
 */
@RunWith(JUnit4.class)
public class PersistentQueue1Test {
	@Test 
	@Ignore
	public void test() {
		int time = 0;
		PersistentQueue<Integer> PersistentQueue1 = new PersistentQueue<Integer>();
//		for(int i=0;i<10;++i) {
//			PersistentQueue1=PersistentQueue1.enqueue(i);
//			//time+=PersistentQueue1.getTimes();
//		}
//		assertEquals(10,PersistentQueue1.size());
//		for(int i=0;i<10;++i) {
//			assertTrue(PersistentQueue1.peek()==i);
//			PersistentQueue1 = PersistentQueue1.dequeue();
//		//	time+=PersistentQueue1.getTimes();
//		}
//		assertEquals(0,PersistentQueue1.size());
		
		for(int i=0;i<10;++i) {
			for(int j=0;j<10;++j) {
				PersistentQueue1=PersistentQueue1.enqueue(j);
				time+=PersistentQueue1.getTimes();
			}
			for(int k=0;k<5;++k) {
				PersistentQueue1 = PersistentQueue1.dequeue();
				time+=PersistentQueue1.getTimes();
			}
		}
		
		for(int i=0;i<10;++i) {
			System.out.println(PersistentQueue1.size() + " " + PersistentQueue1.peek());
			PersistentQueue1 = PersistentQueue1.dequeue();
		}
		
		System.out.println(time);
	}
	
	@Test
	@Ignore
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
		
		
		for(int i=0;i<10;++i) {
			for(int j=0;j<10;++j) {
				PersistentQueue1=PersistentQueue1.enqueue(j);
				time+=PersistentQueue1.getTimes();
			}
			for(int k=0;k<5;++k) {
				PersistentQueue1 = PersistentQueue1.dequeue();
				time+=PersistentQueue1.getTimes();
			}
		}
		System.out.println(time);
	}
	
	@Test
	@Ignore
	public void Test1() {
		long start = System.currentTimeMillis();
		long time =0;
		Random r = new Random(System.currentTimeMillis());
		PersistentQueue<Integer> persistentQueue1 = new PersistentQueue<Integer>();
		for(int i=0;i<100000;++i) {
			int value = r.nextInt();
			if(value%2==0) {
				persistentQueue1 = persistentQueue1.enqueue(value);
				time+=persistentQueue1.getTimes();
			} else {
				if(persistentQueue1.size()>0) {
					persistentQueue1 = persistentQueue1.dequeue();
					time+=persistentQueue1.getTimes();
				}
			}
		}
		System.out.print(time);
		long end = System.currentTimeMillis();
		System.out.println("   cost:"+ (end-start));
		
		time=0;
		PersistentQueueSample<Integer> persistentQueueSample = new PersistentQueueSample<Integer>();
		for(int i=0;i<100000;++i) {
			int value = r.nextInt();
			if(value%2==0) {
				persistentQueueSample = persistentQueueSample.enqueue(value);
				time+=persistentQueueSample.getTimes();
			} else {
				if(persistentQueueSample.size()>0) {
					persistentQueueSample = persistentQueueSample.dequeue();
					time+=persistentQueueSample.getTimes();
				}
			}
		}
		System.out.println(time + "    cost:" + (System.currentTimeMillis()-end));
		
	//	ImmutableQueue<Integer> immutableQueue = new ImmutableQueue<Integer>(new ImmutableList<T>(head, tail));
	}
	
	@Test
	public void promote() {
		long costTime=0;
		Random r = new Random(System.currentTimeMillis());
		int TIMES=10000000;
		
		for(int j=0;j<10;++j) {
			long time =0;
			PersistentQueue<Integer> persistentQueue1 = new PersistentQueue<Integer>();
			long start = System.currentTimeMillis();
			for(int i=0;i<TIMES;++i) {
				int value = r.nextInt();
				if(value%2==0) {
					persistentQueue1 = persistentQueue1.enqueue(value);
					time+=persistentQueue1.getTimes();
				} else {
					if(persistentQueue1.size()>0) {
						persistentQueue1 = persistentQueue1.dequeue();
						time+=persistentQueue1.getTimes();
					}
				}
			}
		//	System.out.println(time);
			costTime += (System.currentTimeMillis()-start);
		}
		
		System.out.println("cost average : " + costTime/10.0);
		
				
		long costTime1=0;
		Random r1 = new Random(System.currentTimeMillis());
		
		for(int j=0;j<10;++j) {
			long time =0;
			PersistentQueueSample<Integer> persistentQueue1 = new PersistentQueueSample<Integer>();
			long start = System.currentTimeMillis();
			for(int i=0;i<TIMES;++i) {
				int value = r1.nextInt();
				if(value%2==0) {
					persistentQueue1 = persistentQueue1.enqueue(value);
					time+=persistentQueue1.getTimes();
				} else {
					if(persistentQueue1.size()>0) {
						persistentQueue1 = persistentQueue1.dequeue();
						time+=persistentQueue1.getTimes();
					}
				}
			}
	//		System.out.println(time);
			costTime1 += (System.currentTimeMillis()-start);
		}
		
		System.out.println("cost average : " + costTime1/10.0);
		
	}
	
	
}
