package my.homeworks.hw03.my_framework;

import my.homeworks.hw03.my_framework.exceptions.AnnotationNotExistsException;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    private List<TestItem> testItems = new ArrayList<>();

    public Tester(Class<?> clazz) throws
            NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException, AnnotationNotExistsException {

        AnnotationProcessor annotationProcessor = new AnnotationProcessor(clazz);

        (new HandlerBuilder(annotationProcessor, clazz))
                .buildHandlers()
                .forEach(handler -> this.testItems.add(new TestItem(handler)));
    }

    public void run() {
        testItems.forEach(testItem -> testItem.run());
        outputResult();
    }

    private void outputResult() {
        long total = testItems.size();
        long success = testItems.stream().filter(testItem -> testItem.isSuccess()).count();

        System.out.println("Total tests count: " + total);
        System.out.println("Success: " + success);
        System.out.println("Fail: " + (total - success));

    }

}
