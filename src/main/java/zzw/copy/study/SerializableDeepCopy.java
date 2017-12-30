package zzw.copy.study;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 序列化做深拷贝
 * @author 黄
 *
 */
public class SerializableDeepCopy
{
    public static void main(String[] args) throws Exception
    {
        Teacher3 t = new Teacher3();
        t.setName("Teacher Wang");
        t.setAge(50);

        Student3 s1 = new Student3();
        s1.setAge(20);
        s1.setName("ZhangSan");
        s1.setTeacher(t);

        Student3 s2 = (Student3) s1.deepClone();

        System.out.println("拷贝得到的信息:");
        System.out.println(s2.getName());
        System.out.println(s2.getAge());
        System.out.println(s2.getTeacher().getName());
        System.out.println(s2.getTeacher().getAge());
        System.out.println("---------------------------");

        // 将复制后的对象的老师信息修改一下：
        s2.getTeacher().setName("New Teacher Wang");
        s2.getTeacher().setAge(28);

        System.out.println("修改了拷贝对象的教师后：");
        System.out.println("拷贝对象的教师：");
        System.out.println(s2.getTeacher().getName());
        System.out.println(s2.getTeacher().getAge());
        System.out.println("原来对象的教师：");
        System.out.println(s1.getTeacher().getName());
        System.out.println(s1.getTeacher().getAge());

        // 由此证明序列化的方式实现了对象的深拷贝

    }

}

class Teacher3 implements Serializable
{
    /**
	 * 序列号ID
	 */
	private static final long serialVersionUID = -3393602253223607827L;
	private String name;
    private int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

}

class Student3 implements Serializable
{
    /**
	 * 序列号ID
	 */
	private static final long serialVersionUID = -2682129392060987784L;
	private String name;
    private int age;
    private Teacher3 teacher;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Teacher3 getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher3 teacher)
    {
        this.teacher = teacher;
    }

    public Object deepClone() throws Exception
    {	
        // 序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeObject(this);

        // 反序列化
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        return ois.readObject();
    }

}
