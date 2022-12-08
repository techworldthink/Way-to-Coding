package com.learn.thread;

import java.util.ArrayList;
import java.util.List;

public class Adding implements Runnable {
	
	private  List<Integer> list;
	
	public Adding() {
		list = new ArrayList<Integer>();
	}

	
	public Adding(List<Integer> list) {
		super();
		this.list = list;
	}

	@Override
	public synchronized void run() {
		
		

		
		for(int i=1; i<=100; i++)
		{
			list.add(i);
		}
		
		
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	

}
