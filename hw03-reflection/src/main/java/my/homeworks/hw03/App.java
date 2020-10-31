package my.homeworks.hw03;

import my.homeworks.hw03.my_framework.Tester;
import my.homeworks.hw03.my_framework.exceptions.AnnotationNotExistsException;
import my.homeworks.hw03.test.MyClassTest;

import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args)
            throws InvocationTargetException, NoSuchMethodException,
            InstantiationException, AnnotationNotExistsException, IllegalAccessException {

        Class testedClass = MyClassTest.class;

        Tester tester = new Tester(testedClass);
        tester.run();
    }
}
