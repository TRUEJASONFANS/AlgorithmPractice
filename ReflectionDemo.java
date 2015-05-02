package com.me.multiplethread;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

 /**
 * @author jason
 *
 */
public class ReflectionDemo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		classUtils.printMethodsInfos("sb");
		A a  = new A();
		Class<? extends Object> c = A.class;
		Method m = c.getDeclaredMethod("print", int.class,int.class);
		m.invoke(a, 3,5);
		
		
		ArrayList list = new ArrayList();
		ArrayList<String> list1 = new ArrayList<String>(); //list1去泛型化
		list1.add("1123");
		list.add("123");
		list.add(1);//
	
		Class<? extends Object> c1 = list1.getClass();
		Method m1 = c1.getDeclaredMethod("add", Object.class);
		m1.invoke(list1, 2);//通过反射可以将去泛型化的list对象中加入int
		System.out.println(list1.size());
	}

}
class A {
	public void print(int a,int b){
		System.out.println(a+b);
	}
}
class classUtils{
	
	/**
	 * 三种方式得到类类型, String.class, obj.getclass,Class.forName("java.lang.String");
	 * @param obj
	 * @throws ClassNotFoundException 
	 */
	public static void printFieldInfos(Object obj) throws ClassNotFoundException{
		Class<? extends Object> c = Class.forName("java.lang.String");
		Field[] fields =  c.getDeclaredFields();
		for(Field f :fields){
			System.out.println("type:"+f.getType()+"\tname:"+f.getName());
		}
	}
	public static void printMethodsInfos(Object obj) {
		Class<? extends Object> c = obj.getClass();
		Method[] methods = c.getDeclaredMethods();
		for(Method m :methods){
			System.out.println("tname:"+m.getName());
		}
		
	}
	
}
