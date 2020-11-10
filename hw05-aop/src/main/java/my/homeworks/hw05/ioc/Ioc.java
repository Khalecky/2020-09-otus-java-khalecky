package my.homeworks.hw05.ioc;

import my.homeworks.hw05.ioc.invocationHandler.MyInvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

public class Ioc {

    private final static Ioc instanceIoc = new Ioc();

    private Ioc() {
    }

    public static Object buildInstance(Class<?> clazz) throws Exception {
        return instanceIoc.createInstance(clazz);
    }

    private Object createInstance(Class<?> clazz) throws Exception {

        Object object = clazz.getConstructor().newInstance();
        Set<Method> methods = getWrappedMethods(clazz);
        if (methods.isEmpty()) {
            return object;
        }
        return buildProxy(object, methods);
    }

    private Set<Method> getWrappedMethods(Class<?> clazz)
    {
        Set<Method> methods = new HashSet<>();

        for (Method method: clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Log.class)) {
                methods.add(method);
            }
        }
        return methods;
    }

    private Object buildProxy(Object objectToWrap, Set<Method> proxiedMethods) {

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(objectToWrap, proxiedMethods);

        return Proxy.newProxyInstance(
                Ioc.class.getClassLoader(),
                objectToWrap.getClass().getInterfaces(),
                myInvocationHandler
        );
    }

}
