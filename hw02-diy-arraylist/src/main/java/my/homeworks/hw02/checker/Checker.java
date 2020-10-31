package my.homeworks.hw02.checker;

import java.util.Arrays;
import java.util.List;

abstract public class Checker
{
    private List<String> diy;

    public Checker(List<String> diy)
    {
        this.diy = diy;
    }

    abstract public void check();

    protected List<String> getDiy()
    {
        return diy;
    }

    protected void printDiy()
    {
        System.out.println(Arrays.toString(diy.toArray()));
    }

}
