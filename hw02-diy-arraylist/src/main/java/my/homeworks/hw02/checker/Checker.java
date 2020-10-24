package my.homeworks.hw02.checker;

import my.homeworks.hw02.DiyArrayList.DiyArrayList;

import java.util.Arrays;

abstract public class Checker<String>
{
    protected DiyArrayList<String> diy;

    public Checker(DiyArrayList<String> diy)
    {
        this.diy = diy;
    }

    abstract public void check();

    protected void printArray(String[] arr)
    {
        System.out.println(Arrays.toString(arr));
    }
}
