package zzw.serializable.study;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * transient 关键字的作用是控制变量的序列化，在变量声明前加上该关键字，可以阻止该变量被序列化到文件中，
 * 在被反序列化后，transient 变量的值被设为初始值，如 int 型的是 0，对象型的是 null。
 * @author 黄
 * 也可继承实现Externlizable接口，此接口继承Serializable接口，是其扩展。
 * http://blog.csdn.net/endlu/article/details/51178143
 */
public class SerializableStudy {

	public static void main(String[] args) {
		Person p = new Person("1", "Alice", "20");
		String path = System.getProperty("user.dir") + "/file/person.txt";
		File file = new File(path);
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// Person对象序列化过程
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(p);
			System.out.println(p);
			oos.flush();
			oos.close();
			fos.close();

			// Person对象反序列化过程
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Person p1 = (Person) ois.readObject();
			System.out.println("id = " + p1.getId());
			System.out.println("name = " + p1.getName());
			System.out.println("age = " + p1.getAge());
			ois.close();
			fis.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
