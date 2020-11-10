package my.homeworks.hw05.ioc.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashSet;
import java.util.Set;

public class MyInvocationHandler implements InvocationHandler {

    private final Object wrappedObject;
    private final Set<String> wrappedMethodHashes = new HashSet<>();

    public MyInvocationHandler(Object wrappedObject, Set<Method> wrappedMethods) {
        this.wrappedObject = wrappedObject;
        for (Method method : wrappedMethods) {
            wrappedMethodHashes.add(getMethodHash(method));
        }
    }

    public Object getWrappedObject() {
        return wrappedObject;
    }

    protected boolean isMethodWrapped(Method method) {
        return wrappedMethodHashes.contains(getMethodHash(method));
    }

    private String getMethodHash(Method method) {
        String hash = method.getName();
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
