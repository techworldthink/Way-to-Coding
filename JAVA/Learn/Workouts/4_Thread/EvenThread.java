package com.learn.thread;

import java.util.List;

public class EvenThread implements Runnable {
	
List<Integer> list;
	
	public EvenThread() {
		
	}

	public EvenThread(List list) {
		super();
		this.list = list;
	}
	
	@Override
	public synchronized void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(int num: list)
		{
			if(num%2 == 0)
			{
				System.out.println("Even Thread : "+num);
			}
		}
		
	}

}
