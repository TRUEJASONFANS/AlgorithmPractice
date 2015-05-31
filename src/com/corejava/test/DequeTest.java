package com.corejava.test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Properties;

import com.google.common.collect.Lists;

public class DequeTest {
		
	public static void main(String args[]) {
		
		Deque<String> deque = new LinkedList<String>();
		ArrayList<String> tmpList = Lists.newArrayList("aaa","bbb","ccc");
		String values[] = tmpList.toArray(new String[0]);
		System.out.println(tmpList.hashCode());
		System.out.println(values.hashCode());
		
		Hashtable<String,String> hashTable = new Hashtable<String,String> ();
		hashTable.put("jason", "zhongwie");
		Enumeration<String> enumeration = hashTable.keys();
		
		Properties properties = new Properties();
		properties.put("jason", "zhongwie");
		
	}
}
