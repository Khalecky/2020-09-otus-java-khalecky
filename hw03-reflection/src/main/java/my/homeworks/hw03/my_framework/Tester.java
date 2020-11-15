package my.homeworks.hw03.my_framework;

import my.homeworks.hw03.my_framework.exceptions.AnnotationNotExistsException;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    private List<TestItem> testItems = new ArrayList<>();
    private final Class<?> clazz;

    public Tester(Class<?> clazz) {
        this.clazz = clazz;
    }

    public void run() throws AnnotationNotExistsException {
        buildTestItems().executeTests().outputResult();
    }

    private Tester buildTestItems() throws AnnotationNotExistsException {

        AnnotationProcessor annotationProcessor = new AnnotationProcessor(clazz);
        Method before = annotationProcessor.getMethodBefore();
        Method after = annotationProcessor.getMethodAfter();

        for (Method testMethod : annotationProcessor.getTestMethods()) {
            List<Method> methods = new ArrayList<>();

            methods.add(before);
            methods.add(testMethod);
            methods.add(after);

            testItems.add(new TestItem(methods, clazz));
        }
        return this;
    }

    private Tester executeTests() {
        testItems.forEach(testItem -> testItem.run());
        return this;
    }

    private void outputResult() {
        long total = testItems.size();
        long success = testItems.stream().filter(testItem -> testItem.isSuccess()).count();

        System.out.println("Total tests count: " + total);
        System.out.println("Success: " + success);
        System.out.println("Fail: " + (total - success));

    }

}
