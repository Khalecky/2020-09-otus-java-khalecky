package my.homeworks.hw05.ioc.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

public class MyInvocationHandler implements InvocationHandler {

    private final Object wrappedObject;
    private final List<Method> wrappedMethods;

    public MyInvocationHandler(Object wrappedObject, List<Method> wrappedMethods) {
        this.wrappedObject = wrappedObject;
        this.wrappedMethods = wrappedMethods;
    }

    public Object getWrappedObject() {
        return wrappedObject;
    }

    protected boolean isMethodWrapped(Method method) {

        return wrappedMethods
                .stream()
                .filter(wrappedMethod -> isSame(wrappedMethod, method))
                .count() > 0;
    }

    private boolean isSame(Method method1, Method method2) {
        return getMethodHash(method1).equals(getMethodHash(method2));
    }

    private String getMethodHash(Method method) {
        String hash = method.getReturnType().getName();
        hash += method.getName();
        for (Parameter parameter: method.getParameters()) {
            hash += parameter.getType().getName();
        }
        return hash;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (isMethodWrapped(method)) {
            log(method, args);
        }
        return method.invoke(getWrappedObject(), args);
    }

    private void log(Method method, Object[] args) {
        String output = "Executed method: " + method.getName() + "; ";
        int i = 0;
        for (Parameter parameter: method.getParameters()) {
            if (i > 0) {
                output += ", ";
            }
            output += parameter.getName() + ": " + args[i++].toString();
        }
        System.out.println(output);
    }
}
