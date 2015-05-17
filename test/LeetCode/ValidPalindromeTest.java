package LeetCode;

import static org.junit.Assert.*;

import org.junit.Test;

import LeetCode.ValidPalindrome;


public class ValidPalindromeTest {

	@Test
	public void test() {
		assertEquals(true,new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
	}
	
	@Test
	public void test2() {
		assertEquals(true,new ValidPalindrome().isPalindrome("a.a'"));
	}
}
