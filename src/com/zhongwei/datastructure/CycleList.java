package com.zhongwei.datastructure;

import java.util.List;

import com.google.common.collect.Lists;

public class CycleList<T> {

	private final int len;
	private int head = 0;
	private int tail = 0;
	private int curLen = 0;

	private final List<T> array = Lists.newArrayList();
	private final int[] fArray;

	public boolean enQueue(T t) throws Exception {
		if (!full()) {
			fArray[tail] = 1;
			array.add(tail, t);
			tail = (tail + 1) % len;
			curLen++;
			return true;
		} else {
			throw new Exception("the list is full");
		}
	}

	public T deQueue() throws Exception {
		if (!empty()) {
			T t = array.get(head);
			fArray[head] = 0;
			head = (head + 1) % len;
			curLen--;
			return t;
		} else {
			throw new Exception("the list do not contain any element");
		}
	}

	public boolean full() {
		return curLen == len;
	}

	public boolean empty() {
		return curLen == 0;
	}

	public void traverse() {
		int i = 0, j = head;
		while (i < curLen) {
			System.out.println(array.get(j));
			j = (j + 1) % len;
			i++;
		}
	}
	
	public CycleList(int l) {
		super();
		len = l;
		fArray = new int[len];
	}

	public static void main(String[] args) throws Exception {
		CycleList<Integer> cycleList = new CycleList<Integer>(3);
		cycleList.enQueue(2);
		cycleList.enQueue(3);
		cycleList.enQueue(4);
		cycleList.traverse();
	}
	

}
