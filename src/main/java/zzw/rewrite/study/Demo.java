package zzw.rewrite.study;

/**
 * 测试重写的equals方法和hashCode方法
 * @author 黄
 *
 */
public class Demo {

	public static void main(String[] args) {
		Person p1 = new Person("1","zs","29");
		Person p2 = new Person("2","zs","29");
		Person p3 = new Person("2","zs1","29");
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
	}

}
