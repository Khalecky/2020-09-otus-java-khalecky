package my.homeworks.hw03.test;

import my.homeworks.hw03.my_framework.annotation.*;

public class MyClassTest {

    public MyClassTest() {}

    @Before
    public void prepare() {
        System.out.println("prepare");
    }

    @Test
    public void test1() {
        System.out.println("start test1");
    }

    @Test
    public void test2() throws Exception {
        System.out.println("start test2");
        throw new Exception("123");
    }

    @After
    public void finish() {
        System.out.println("finish");
    }



}
