package my.homeworks.hw05;

import my.homeworks.hw05.ioc.Ioc;
import my.homeworks.hw05.mylib.MyClass;
import my.homeworks.hw05.mylib.MyClassImpl;

public class App {
    public static void main(String[] args) throws Exception {
        MyClass myClass = (MyClass) Ioc.buildInstance(MyClassImpl.class);
        System.out.println(myClass.add(2,2));
        System.out.println(myClass.add());
    }
}
