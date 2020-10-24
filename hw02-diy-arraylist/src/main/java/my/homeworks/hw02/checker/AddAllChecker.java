package my.homeworks.hw02.checker;

import my.homeworks.hw02.DiyArrayList.DiyArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class AddAllChecker extends Checker
{
    public AddAllChecker(DiyArrayList diy) {
        super(diy);
    }

    @Override
    public void check() {
        ArrayList<String> c = getOtherCollection();
        diy.addAll(c);
        printArray(diy.toArray());
    }

    private ArrayList<String> getOtherCollection()
    {
        ArrayList<String> c = new ArrayList<>();

        final int sz = 20;
        for (int i = 0; i < sz; ++i) {
            c.add("B".repeat(i + 1));
        }
        return c;
    }
}
