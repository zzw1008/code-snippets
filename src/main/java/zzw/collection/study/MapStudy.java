package zzw.collection.study;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;

//1、List（有序、可重复）
//List里存放的对象是有序的，同时也是可以重复的，List关注的是索引，拥有一系列和索引相关的方法，查询速度快。因为往list集合里插入或删除数据时，会伴随着后面数据的移动，所有插入删除数据速度慢。
//2、Set（无序、不能重复）
//Set里存放的对象是无序，不能重复的，集合中的对象不按特定的方式排序，只是简单地把对象加入集合中。
//3、Map（键值对、键唯一、值不唯一）
//Map集合中存储的是键值对，键不能重复，值可以重复。根据键得到值，对map集合遍历时先得到键的set集合，对set集合进行遍历，得到相应的值。

//HashMap 
//HashMap是最常用的Map，它根据键的HashCode值存储数据，根据键可以直接获取它的值，具有很快的访问速度，遍历时，取得数据的顺序是完全随机的。因为键对象不可以重复，所以HashMap最多只允许一条记录的键为Null，允许多条记录的值为Null，是非同步的
//
//Hashtable
//Hashtable与HashMap类似，是HashMap的线程安全版，它支持线程的同步，即任一时刻只有一个线程能写Hashtable，因此也导致了Hashtale在写入时会比较慢，它继承自Dictionary类，不同的是它不允许记录的键或者值为null，同时效率较低。
//
//ConcurrentHashMap
//线程安全，并且锁分离。ConcurrentHashMap内部使用段(Segment)来表示这些不同的部分，每个段其实就是一个小的hash table，它们有自己的锁。只要多个修改操作发生在不同的段上，它们就可以并发进行。
//
//LinkedHashMap
//LinkedHashMap保存了记录的插入顺序，在用Iteraor遍历LinkedHashMap时，先得到的记录肯定是先插入的，在遍历的时候会比HashMap慢，有HashMap的全部特性。
//
//TreeMap
//TreeMap实现SortMap接口，能够把它保存的记录根据键排序，默认是按键值的升序排序（自然顺序），也可以指定排序的比较器，当用Iterator遍历TreeMap时，得到的记录是排过序的。不允许key值为空，非同步的；

public class MapStudy {

	public static void main(String[] args) {
		System.out.println("HashMap");
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("1", "11");
		hm.put("2", "22");
		hm.put("3", "33");
		//对于keySet其实是遍历了2次，一次是转为iterator，一次就是从HashMap中取出key所对于的value。而entryset只是遍历了第一次，它把key和value都放到了entry中，所以快了。两种遍历的遍历时间相差还是很明显的。
		// 遍历Key
		Iterator<String> it1 = hm.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println(key+"---"+hm.get(key));
		}
		// 遍历Entry
		Iterator<Entry<String, String>> it2 = hm.entrySet().iterator();
		while (it2.hasNext()) {
			Entry<String, String> entry = it2.next();
			System.out.println(entry.getKey()+"---"+entry.getValue());
		}
		
		System.out.println("Hashtable");
		Hashtable<String, String> ht = new Hashtable<String, String>();
		ht.put("1", "11");
		ht.put("2", "22");
		ht.put("3", "33");
		// 遍历Key
		Iterator<String> it3 = ht.keySet().iterator();
		while (it3.hasNext()) {
			String key = it3.next();
			System.out.println(key+"---"+ht.get(key));
		}
		// 遍历Entry
		Iterator<Entry<String, String>> it4 = ht.entrySet().iterator();
		while (it4.hasNext()) {
			Entry<String, String> entry = it4.next();
			System.out.println(entry.getKey()+"---"+entry.getValue());
		}
	}

}
