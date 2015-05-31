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
		
		
		//���в�������Ԫ�ص�����˳��
		System.out.println();
		for(GregorianCalendar date:pq) {
			System.out.println(date.get(Calendar.YEAR));
		}
		
		//ɾ������ɾ�����ȼ���С���Ǹ�
		System.out.println("removing elements:");
		while(!pq.isEmpty()){
			System.out.println(pq.remove().get(Calendar.YEAR));
		}
	}

}
