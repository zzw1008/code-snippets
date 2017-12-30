package zzw.collection.study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

//1、List（有序、可重复）
//List里存放的对象是有序的，同时也是可以重复的，List关注的是索引，拥有一系列和索引相关的方法，查询速度快。因为往list集合里插入或删除数据时，会伴随着后面数据的移动，所有插入删除数据速度慢。
//2、Set（无序、不能重复）
//Set里存放的对象是无序，不能重复的，集合中的对象不按特定的方式排序，只是简单地把对象加入集合中。
//3、Map（键值对、键唯一、值不唯一）
//Map集合中存储的是键值对，键不能重复，值可以重复。根据键得到值，对map集合遍历时先得到键的set集合，对set集合进行遍历，得到相应的值。


//1、Vector、ArrayList都是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
//2、List中的元素有序、允许有重复的元素，Set中的元素无序、不允许有重复元素。
//3、Vector线程同步，ArrayList、LinkedList线程不同步。
//4、LinkedList适合指定位置插入、删除操作，不适合查找；ArrayList、Vector适合查找，不适合指定位置的插入、删除操作。
//5、ArrayList在元素填满容器时会自动扩充容器大小的50%，而Vector则是100%，因此ArrayList更节省空间。

public class ListStudy {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Java");
		al.add("Python");
		al.add("C#");
		Iterator<String> it1 = al.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("Java");
		ll.add("Python");
		ll.add("C#");
		Iterator<String> it2 = ll.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		Vector<String> v = new Vector<String>();
		v.add("Java");
		v.add("Python");
		v.add("C#");
		Iterator<String> it3 = v.iterator();
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}
	}
}
