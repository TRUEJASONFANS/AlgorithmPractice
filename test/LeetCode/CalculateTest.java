package LeetCode;

import static org.junit.Assert.*;
import junit4Demo.Calculate;

import org.junit.Test;

public class CalculateTest {

	
	@Test
	public void testAdd(){
		assertEquals(6,new Calculate().add(3,3));
	}
	@Test
	public void testSubtract(){
		assertEquals(3,new Calculate().subtract(5, 2));
	}
	@Test
	public void testMultiple(){
		assertEquals(6,new Calculate().multiple(2, 3));
	}
	@Test
	public void testDivide(){
		assertEquals(2,new Calculate().divide(6, 3));
	}
	
}
