package LeetCode;

import java.math.BigInteger;


public class ReverseBitsOfInteger {

	/**
	 * like reversing a string.
	 * we swap the bits in (0,N-1),(1,N-2)......
	 * we do it with XOR
	 * 
	 */
	public static void main(String[] args) {
		int y = 0x01010101;
		int z = reverseBits(y);//z=ox80808080
		System.out.printf("%b\n%b", y, z);

	}

	public static int reverseBits(int y) {
		// INT_SIZE=32 in general
		int INT_SIZE = Integer.SIZE;

		for (int i = 0; i < INT_SIZE / 2; i++) {
			int j = INT_SIZE - 1 - i;

			int low = (y >> i) & 1;
			int high = (y >> j) & 1;

			int A = 1 << i;
			int B = 1 << j;

			if ((high ^ low) == 1) {//不相同则需要交换
				y = y ^ (A | B);
			}
		}
		return y;
	}
}
