package my.homeworks.hw05.mylib;

import my.homeworks.hw05.ioc.Log;

public class MyClassImpl implements MyClass {


    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Log
    @Override
    public int add(int x) {
        return ++x;
    }

    @Log
    @Override
    public int add() {
        return 100;
    }

}
