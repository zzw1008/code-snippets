package zzw.copy.study;

/**
 * 深拷贝（深复制、深克隆）：被复制对象的所有变量都含有与原来的对象相同的值，除去那些引用其他对象的变量。那些引用其他对象的变量将指向被复制过的新对象，而不再是原有的那些被引用的对象。即深拷贝把要复制的对象所引用的对象都复制了一遍。
 * 自定义类对象
 * @author 黄
 *
 */
public class DeepCopy {

	public static void main(String[] args) throws CloneNotSupportedException {
		Teacher teacher = new Teacher();
		teacher.setName("Teacher Zhang");
		teacher.setAge(40);

		Student2 student1 = new Student2();
		student1.setName("ZhangSan");
		student1.setAge(20);
		student1.setTeacher(teacher);

		Student2 student2 = (Student2) student1.clone();
		System.out.println("拷贝得到的信息");
		System.out.println(student2.getName());
		System.out.println(student2.getAge());
		System.out.println(student2.getTeacher().getName());
		System.out.println(student2.getTeacher().getAge());
		System.out.println("-------------");

		// 修改老师的信息
		teacher.setName("Teacher Zhang has changed");
		System.out.println(student1.getTeacher().getName());
		System.out.println(student2.getTeacher().getName());

		// 两个引用student1和student2指向不同的两个对象
		// 但是两个引用student1和student2中的两个teacher引用指向的是同一个对象
		// 所以说明是浅拷贝
	}

}

class Teacher implements Cloneable {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
/**
 * 复制对象
 * Teacher类作为Student的成员变量
 * @author zzw
 *
 */
class Student2 implements Cloneable {
	private String name;
	private int age;
	private Teacher teacher;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// 浅复制时：源对象和拷贝对象，指向同一个Teacher类实例
        // Object object = super.clone();
        // return object;

        // 改为深复制：源对象和拷贝对象对应的不同的Teacher类实例
        Student2 student = (Student2) super.clone();
        // 本来是浅复制，现在将Teacher对象复制一份并重新set进来
        student.setTeacher((Teacher) student.getTeacher().clone());
        return student;
	}

}
