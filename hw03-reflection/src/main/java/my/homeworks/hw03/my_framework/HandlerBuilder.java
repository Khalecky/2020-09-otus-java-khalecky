package my.homeworks.hw03.my_framework;

import my.homeworks.hw03.my_framework.annotation.*;
import my.homeworks.hw03.my_framework.exceptions.AnnotationNotExistsException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class HandlerBuilder {

    private AnnotationProcessor annotationProcessor;
    private Class<?> clazz;

    HandlerBuilder(AnnotationProcessor annotationProcessor, Class<?> clazz)
    {
        this.annotationProcessor = annotationProcessor;
        this.clazz = clazz;
    }

    public List<Handler> buildHandlers() throws
            AnnotationNotExistsException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException
    {
        List<Handler> handlers = new ArrayList<>();
        for (Method testMethod : annotationProcessor.getTestMethods()) {
            handlers.add(buildHandler(testMethod));
        }
        return handlers;
    }

    private Handler buildHandler(Method testMethod)
            throws
            AnnotationNotExistsException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException
    {
        Object testedInstance = clazz.getConstructor().newInstance();
        Handler testHandler = new Handler(testMethod, testedInstance);
        Handler after = buildCommonHandle(After.class, testedInstance);
        Handler before = buildCommonHandle(Before.class, testedInstance);

        before.setNextHandler(testHandler);
        testHandler.setNextHandler(after);

        return before;
    }

    private Handler buildCommonHandle(Class<?> clazz, Object testedInstance) throws AnnotationNotExistsException {
        return new Handler(
                annotationProcessor.getCommonMethod(clazz.getName()),
                testedInstance
        );
    }
}
