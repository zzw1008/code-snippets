package zzw.copy.study;

import java.time.LocalDateTime;

/**
 * 浅拷贝（浅复制、浅克隆）：被复制对象的所有变量都含有与原来的对象相同的值，而所有的对其他对象的引用仍然指向原来的对象。即浅拷贝仅仅复制所考虑的对象，而不复制它所引用的对象。
 * 基本数据类型和String类型
 * String类型比较特殊，拷贝的是地址，是个引用，但是在修改的时候，它会从字符串池（String Pool）中重新生成新的字符串，原有的字符串对象保持不变，此处可以认为String是个基本类型。
 * Java8中LocalDateTime等用final修饰的类和String处理相同，即final类处理方式同基本数据类型
 * @author zzw
 *
 */
public class ShallowCopy {
	public static void main(String[] args) throws CloneNotSupportedException {
		Student s1 = new Student();
		s1.setName("张三");
		s1.setAge(20);
		s1.setCreateTime(LocalDateTime.now());
		
		Student s2 = new Student();
		s2 = (Student)s1.clone();
		
		System.out.println("浅拷贝得到的信息：");
		System.out.println(s2.getName()+" "+s2.getAge()+" "+s2.getCreateTime());
		
		//修改拷贝对象的信息
		s2.setName("李四");
		s2.setAge(19);
		s2.setCreateTime(LocalDateTime.now().plusDays(3));
		
		//输出浅拷贝后的信息
		System.out.println("修改拷贝对象的属性后的信息：");
		System.out.println("源对象：");
		System.out.println(s1.getName()+" "+s1.getAge()+" "+s1.getCreateTime());
		System.out.println("拷贝对象：");
		System.out.println(s2.getName()+" "+s2.getAge()+" "+s2.getCreateTime());
	}
}
class Student implements Cloneable{
	private String name;
	
	private Integer age;
	
	private LocalDateTime createTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		Object object = super.clone();
		
		return object;	
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	
	
}
