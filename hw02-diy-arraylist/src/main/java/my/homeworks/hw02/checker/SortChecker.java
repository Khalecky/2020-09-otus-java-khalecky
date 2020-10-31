package my.homeworks.hw02.checker;

import java.util.Collections;
import java.util.List;

public class SortChecker extends Checker
{

    public SortChecker(List<String> diy) {
        super(diy);
    }

    @Override
    public void check()
    {
        Collections.sort(getDiy(), Collections.reverseOrder());
        printDiy();
    }
}

