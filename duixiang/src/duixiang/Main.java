package duixiang;


import java.io.*;
//将对象所包含的全部数据写出文件里并读入
class Student implements Serializable{//Serializable可串行化
    private String name;
    private int age;
    private String Sex;

    public Student(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.Sex = sex;
    }

    @Override
    public String toString() {
        return name+" "+age+" "+Sex;
    }
}
public class Main {
    public static void main(String[] args) {
        Student s=new Student("pang",28,"男");
        System.out.println(s);
        try {
            ObjectOutputStream out =new ObjectOutputStream(new
                    FileOutputStream("select.dat"));
            out.writeObject(s);
            out.close();
            ObjectInputStream in =new ObjectInputStream(new
                    FileInputStream("select.dat"));
            Student b=(Student) in.readObject();//cast向上新构造一个Student对象
            System.out.println(b);
            in.close();
            System.out.println(s==b);//比较两个对象的管理者，虽然内容一样，可是不同的对象管理者

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
