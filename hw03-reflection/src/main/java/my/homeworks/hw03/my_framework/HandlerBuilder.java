package my.homeworks.hw03.my_framework;

import my.homeworks.hw03.my_framework.annotation.*;
import my.homeworks.hw03.my_framework.exceptions.AnnotationNotExistsException;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class HandlerBuilder {

    private AnnotationProcessor annotationProcessor;
    private Object testedInstance;

    HandlerBuilder(AnnotationProcessor annotationProcessor, Object testedInstance)
    {
        this.annotationProcessor = annotationProcessor;
        this.testedInstance = testedInstance;
    }

    public List<Handler> buildHandlers() throws AnnotationNotExistsException {
        List<Handler> handlers = new ArrayList<>();
        for (Method testMethod : annotationProcessor.getTestMethods()) {
            handlers.add(buildHandler(testMethod));
        }
        return handlers;
    }

    private Handler buildHandler(Method testMethod) throws AnnotationNotExistsException {
        Handler testHandler = new Handler(testMethod, testedInstance);
        Handler after = buildCommonHandle(After.class);
        Handler before = buildCommonHandle(Before.class);

        before.setNextHandler(testHandler);
        testHandler.setNextHandler(after);

        return before;
    }

    private Handler buildCommonHandle(Class<?> clazz) throws AnnotationNotExistsException {
        return new Handler(
                annotationProcessor.getCommonMethod(clazz.getName()),
                testedInstance
        );
    }
}
