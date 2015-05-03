package junit4Demo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 1.更改默认的测试运行器
 * 2.声明变量来存放预期值和结果值
 * 3.声明一个返回值为Collection的公共静态方法，并使用@Parameters来进行修饰
 * 4.为测试类声明一个带有参数公共构造函数，并在其中为之声明变量初始化
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
