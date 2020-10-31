package my.homeworks.hw02.checker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CopyChecker extends Checker
{

    public CopyChecker(List<String> diy) {
        super(diy);
    }

    @Override
    public void check()
    {
        List<String> diy = getDiy();
        List<String> dest = getDest(diy.size());
        Collections.copy(dest, diy);

        System.out.println(dest);
    }

    private List<String> getDest(int size)
    {
        List<String> dest = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            dest.add("");
        }
        return dest;
    }
}
