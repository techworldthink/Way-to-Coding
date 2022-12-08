package com.learn.thread;

import java.util.ArrayList;
import java.util.List;

public class Listing implements Runnable{

	public static void main(String[] args) {
		
		
		Adding ad = new Adding();
		OddThread ot = new OddThread(ad.getList());
		EvenThread et = new EvenThread(ad.getList());
		
		Thread t1 = new Thread(ad);
		Thread t2 = new Thread(ot);
		Thread t3 = new Thread(et);
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("done");

	}

}
