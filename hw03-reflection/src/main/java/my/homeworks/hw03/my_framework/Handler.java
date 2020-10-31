package my.homeworks.hw03.my_framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Handler {

    private Method method;
    private Object instanceForTest;

    private Handler nextHandler = null;

    public Handler(Method method, Object instanceForTest) {
        this.method = method;
        this.instanceForTest = instanceForTest;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle() throws InvocationTargetException, IllegalAccessException {
        method.setAccessible(true);
        method.invoke(instanceForTest);

        if (nextHandler != null) {
            nextHandler.handle();
        }
    }

}
