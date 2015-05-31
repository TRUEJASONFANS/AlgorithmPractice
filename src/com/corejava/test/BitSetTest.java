package com.corejava.test;

import java.util.BitSet;

public class BitSetTest {
	static int max_num = 2000000;
	static BitSet bitSet = new BitSet(max_num+1);
	static int prim[] = new int[max_num];
 	static int cnt;
	
	public static void main(String[] args) {
		bitSet.set(0);
		bitSet.set(1);
		for(int i=2;i<max_num;i++) {
			if(!bitSet.get(i)) {
				prim[cnt++] = i;
			}
			for(int j = 0; j<cnt&&i*prim[j]<max_num;j++) {
				bitSet.set(i*prim[j]);
				if(i%prim[j]==0)//如果i是合数,避免重复去除
					break;
			}
		}
		System.out.println(cnt);
//		for(int i=0;i<cnt;i++) {
//			System.out.println(prim[i]);
//		}
	}

}
