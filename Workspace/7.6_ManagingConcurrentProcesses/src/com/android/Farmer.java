package com.android;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

public class Farmer {
	
	//static int counter = 0;
	
	private void removeAnimals() {
		System.out.println("removing animals "); // + counter);
	}
	
	private void cleanPen() {
		System.out.println("cleaning pen "); // + counter);
	}
	
	private void addAnimals() {
		System.out.println("adding animals "); // + counter);
	}
	
	public void performTasks(CyclicBarrier c1, CyclicBarrier c2) {
		//counter++;
		
		
		try {
			removeAnimals(); //all 4 threads call this method
			
			c1.await(); //only when ALL 4 threads have finished removeAnimals() AND called c1.await(), will cleanPen be called on any thread.
			
			cleanPen();
			
			/*
			 * ONLY when all 4 threads have checked in with await() will the farmers progress onto addAnimals().
			 * Also as soon as the 4 threads check uinto c2, will the Runnable object fire, printing ("pen cleaned")
			 */
			c2.await(); 
			
			addAnimals();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
