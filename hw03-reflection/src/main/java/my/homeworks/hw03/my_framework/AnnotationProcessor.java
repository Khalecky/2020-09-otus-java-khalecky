package my.homeworks.hw03.my_framework;

import my.homeworks.hw03.my_framework.annotation.*;
import my.homeworks.hw03.my_framework.exceptions.AnnotationNotExistsException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

public class AnnotationProcessor {

    private Class<?> clazz;

    private HashMap<String, Method> commonMethods = new HashMap<>();
    private ArrayList<Method> testMethods = new ArrayList<>();

    public AnnotationProcessor(Class<?> clazz) {
        this.clazz = clazz;
        parseFrameworksAnnotations();
    }

    private void parseFrameworksAnnotations()
    {
        for (var method: clazz.getDeclaredMethods()) {

            Arrays.stream(method.getAnnotations())
                    .filter(annotation -> isFrameworkAnnotation(annotation))
                    .forEach(annotation -> registerMethod(annotation, method));
        }
    }

    private boolean isFrameworkAnnotation(Annotation annotation) {
        return annotation.annotationType().isAnnotationPresent(MyFrameworkAnnotation.class);
    }

    private void registerMethod(Annotation annotation, Method method) {
        if (annotation instanceof Test) {
            testMethods.add(method);
        } else {
            commonMethods.put(
                    annotation.annotationType().getName(),
                    method
            );
        }
    }

    public Method getCommonMethod(String annotationClass) throws AnnotationNotExistsException
    {
        if (!commonMethods.containsKey(annotationClass)) {
            throw new AnnotationNotExistsException(annotationClass);
        }
        return commonMethods.get(annotationClass);
    }

    public ArrayList<Method> getTestMethods() {
        return testMethods;
    }
}
