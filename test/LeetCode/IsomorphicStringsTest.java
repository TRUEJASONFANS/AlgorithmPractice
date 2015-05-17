package LeetCode;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsomorphicStringsTest {

	@Test
	public void test() {
		assertEquals(true,new IsomorphicStrings().isIsomorphic("ab", "ca"));
		
	}
	@Test
	public void test2() {
		assertEquals(false,new IsomorphicStrings().isIsomorphic("ab", "aa"));
	}
	
}
