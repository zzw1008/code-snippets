package zzw.reflect.study;

import java.lang.reflect.*;

/**
 * 反射：程序可以访问，检测和修改它本身状态或行为的一种能力，并能根据自身行为的状态和结果，调整或修改应用所描述行为的状态和相关的语义。
 * http://www.cnblogs.com/zhaoyanjun/p/6074887.html
 * 
 * @author 黄
 *
 */
public class ReflectStudy {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 调用反射的三种方法
		@SuppressWarnings("unused")
		Class<?> class1 = Person.class;
		@SuppressWarnings("unused")
		Class<?> class2 = new Person().getClass();
		// 推荐第三种
		try {
			Class<?> class3 = Class.forName("reflect.study.Person");
			System.out.println(class3);
			// 获取所有公共方法
			System.out.println("输出所有公共方法：");
			Method[] methods = class3.getMethods();
			for (Method method : methods) {
				System.out.println(method);
			}

			// 创建实例化：相当于 new 了一个对象
			Object object;
			try {
				object = class3.newInstance();
				// 向下转型
				Person person = (Person) object;
				person.read();
				person.setName("zs");
				person.setAge("20");
				System.out.println(person.getName());
				System.out.println(person.getAge());

				Method write = class3.getDeclaredMethod("write");
				System.out.println("访问私有方法");
				write.setAccessible(true);
				write.invoke(person);

			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

			// 获取所有的接口
			Class<?>[] interS = class3.getInterfaces();
			for (Class<?> class4 : interS) {
				System.out.println(class4);
			}

			// 获取所有的构造函数
			Constructor<?>[] constructors = class3.getConstructors();

			for (Constructor<?> constructor : constructors) {
				System.out.println(constructor);
			}

			// 取得本类的全部属性
			Field[] field = class3.getDeclaredFields();

			for (Field field2 : field) {
				System.out.println(field2);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// 修改数组
        int temp[] = {1,2,3} ;// 声明一整型数组  
        Class<?> c = temp.getClass().getComponentType() ; // 取得数组的Class对象  
        System.out.println("类型：" + c.getName()) ;   // 取得数组类型名称  
        System.out.println("长度：" + Array.getLength(temp)) ;  
        System.out.println("第一个内容：" + Array.get(temp,0)) ;  
        Array.set(temp,0,6) ;  
        System.out.println("第一个内容：" + Array.get(temp,0)) ;  
        System.out.println("第二个内容：" + Array.get(temp,1)) ;  

	}

}
