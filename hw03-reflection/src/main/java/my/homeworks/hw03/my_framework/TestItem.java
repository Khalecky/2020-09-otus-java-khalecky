package my.homeworks.hw03.my_framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class TestItem {

    private boolean success = true;

    private final List<Method> methods;
    private final Class<?> clazz;

    public TestItem(List<Method> methods, Class<?> clazz) {
        this.methods = methods;
        this.clazz = clazz;
    }

    public void run() {

        try {
            execute();
        } catch (Exception exception) {
            success = false;
        }

    }

    private void execute()
            throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException, InstantiationException {

        Object instanceForTest = clazz.getConstructor().newInstance();
        for (Method method: methods) {
            method.setAccessible(true);
            method.invoke(instanceForTest);
        }
    }

    public boolean isSuccess() {
        return success;
    }

}
