package zzw.collection.study;

import java.util.HashSet;
import java.util.Iterator;

//HashSet是采用hash表来实现的。其中的元素没有按顺序排列，add()、remove()以及contains()等方法都是复杂度为O(1)的方法。
//TreeSet是采用树结构实现(红黑树算法)。元素是按顺序进行排列，但是add()、remove()以及contains()等方法都是复杂度为O(log (n))的方法。它还提供了一些方法来处理排序的set，如first(), last(), headSet(), tailSet()等等。
//LinkedHashSet介于HashSet和TreeSet之间。它也是一个hash表，但是同时维护了一个双链表来记录插入的顺序。基本方法的复杂度为O(1)。
public class SetStudy {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("1");
		hs.add("2");
		hs.add("3");
		Iterator<String> it1 = hs.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
	}

}
