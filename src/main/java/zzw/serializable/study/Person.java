package zzw.serializable.study;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 序列化uid
	 */
	private static final long serialVersionUID = 1L;

	private transient String id;

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
		this.age = age;
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
}
