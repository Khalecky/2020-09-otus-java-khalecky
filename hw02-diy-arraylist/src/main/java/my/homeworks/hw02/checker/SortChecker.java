package my.homeworks.hw02.checker;

import my.homeworks.hw02.DiyArrayList.DiyArrayList;

import java.util.Collections;

public class SortChecker extends Checker
{

    public SortChecker(DiyArrayList<String> diy) {
        super(diy);
    }

    @Override
    public void check()
    {
        Collections.sort(diy, Collections.reverseOrder());
        printArray(diy.toArray());
    }
}
