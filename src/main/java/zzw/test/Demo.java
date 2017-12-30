package zzw.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Demo {

	public static void main(String[] args) {
		/** 获得当前方法名称 */
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(methodName);
		LocalDate ld = LocalDate.now();
	}

}
