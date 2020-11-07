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
        List<Method> methods = getWrappedMethods(clazz);
        if (methods.isEmpty()) {
            return object;
        }
        return buildProxy(object, methods);
    }

    private List<Method> getWrappedMethods(Class<?> clazz)
    {
        List<Method> methods = new ArrayList<>();

        for (Method method: clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Log.class)) {
                methods.add(method);
            }
        }
        return methods;
    }

    private Object buildProxy(Object objectToWrap, List<Method> proxiedMethods) {

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(objectToWrap, proxiedMethods);

        return Proxy.newProxyInstance(
                Ioc.class.getClassLoader(),
                objectToWrap.getClass().getInterfaces(),
                myInvocationHandler
        );
    }

}
