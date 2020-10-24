package my.homeworks.hw02.checker;

import my.homeworks.hw02.DiyArrayList.DiyArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class CopyChecker extends Checker
{

    public CopyChecker(DiyArrayList<String> diy) {
        super(diy);
    }

    @Override
    public void check()
    {
        ArrayList<String> dest = getDest(diy.size());
        Collections.copy(dest, diy);

        System.out.println(dest);
    }

    private ArrayList<String> getDest(int size)
    {
        ArrayList<String> dest = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            dest.add("");
        }
        return dest;
    }
}
