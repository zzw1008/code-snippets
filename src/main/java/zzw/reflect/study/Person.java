package zzw.reflect.study;

public class Person  implements IAction {

    private String id ;

    private String name ;

    public String age ;
    
    //构造函数1
    public Person( ){

    }

    //构造函数2
    public Person( String id ){
        this.id = id ;
    }

    //构造函数3
    public Person( String id  , String name ){
        this.id = id ;
        this.name = name ;
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
    public static void update(){

    }

	@Override
	public void read() {
		System.out.println("reading...");
	}
	
	private void write() {
		System.out.println("writing...");
	}
}
