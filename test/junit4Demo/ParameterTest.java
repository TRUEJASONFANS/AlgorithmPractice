package junit4Demo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 1.����Ĭ�ϵĲ���������
 * 2.�������������Ԥ��ֵ�ͽ��ֵ
 * 3.����һ������ֵΪCollection�Ĺ�����̬��������ʹ��@Parameters����������
 * 4.Ϊ����������һ�����в����������캯������������Ϊ֮����������ʼ��
 * @author jason
 *
 */
@RunWith(Parameterized.class)
public class ParameterTest {
	int expected = 0;
	int input1 = 0;
	int input2 = 0;

	@Test
	public void test() {
		fail("Not yet implemented");
		
	}
	@Parameters
	public static Collection<Object[]> t(){
		return Arrays.asList(new Object[][]{
				{3,1,2},
				{5,2,3}
		});
	}
	public ParameterTest(int e,int a,int b) {
		this.expected = e;
		this.input1 = a;
		this.input2 = b;
		
	}
	@Test
	public void testAdd(){
		assertEquals(expected, new Calculate().add(input1, input2));
	}
}
