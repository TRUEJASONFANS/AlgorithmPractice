package com.corejava.test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		PriorityQueue<GregorianCalendar> pq = new PriorityQueue();
		pq.add(new GregorianCalendar(1998,Calendar.DECEMBER,9));
		pq.add(new GregorianCalendar(1992,Calendar.NOVEMBER,19));
		pq.add(new GregorianCalendar(2007,Calendar.JULY,19));
		pq.add(new GregorianCalendar(1992,Calendar.APRIL,19));
		
		
		//排列并不按照元素的排列顺序
		System.out.println();
		for(GregorianCalendar date:pq) {
			System.out.println(date.get(Calendar.YEAR));
		}
		
		//删除总是删除优先级最小的那个
		System.out.println("removing elements:");
		while(!pq.isEmpty()){
			System.out.println(pq.remove().get(Calendar.YEAR));
		}
	}

}
