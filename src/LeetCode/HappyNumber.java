package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public boolean isHappy(int n) {
		if (n < 1)
			return false;
		if (n == 1)
			return true;
		Set<Integer> set = new HashSet<Integer>();
		set.add(n);
		int temp = n, sum = 0;
		while(true) {
			sum = 0;
			while (temp > 0) {
				sum +=(temp % 10) * (temp % 10);
				temp /= 10;
			}
			if (sum == 1)
				return true;
			else {
				if(set.contains(sum))
					return false;
				else {
					temp = sum;
					set.add(sum);
					System.out.println(sum);
				}
			}
		}
	}

	public static void main(String[] args) {
		
	}

}
