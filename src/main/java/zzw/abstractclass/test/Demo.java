package zzw.abstractclass.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {

	public static void main(String[] args) {
		Class<?> cat =null;
		try {
			cat=Class.forName("zzw.abstractclass.test.Cat");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        Class<?> temp=cat.getSuperclass();
        System.out.println("继承的父类为：   "+temp.getName());
        //调用Person类中的sayChina方法
        Method method;
		try {
			method = cat.getMethod("bark");
	        method.invoke(cat.newInstance());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}

	}

}
