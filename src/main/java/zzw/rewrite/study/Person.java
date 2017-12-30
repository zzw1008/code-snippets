package zzw.rewrite.study;

import java.util.Objects;

public class Person {
	private String id;

	private String name;

	public String age;

	// 构造函数1
	public Person() {

	}

	// 构造函数2
	public Person(String id) {
		this.id = id;
	}

	// 构造函数3
	public Person(String id, String name, String age) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * 静态方法
	 */
	public static void update() {

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		if (this.getName() == other.getName() && this.getAge() == other.getAge())
			return true;
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
//		return id.hashCode();
		return Objects.hash(id, name, age);
	}
}
