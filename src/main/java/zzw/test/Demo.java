package zzw.test;

public class Demo {

	private String name;

	private String sex;

	public Demo(String name, String sex){
		this.name = name;
		this.sex = sex;
	}

	public int add(int a, int b){
		return  a + b;
	}

	public int minus(int a, int b){
		return  a - b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
