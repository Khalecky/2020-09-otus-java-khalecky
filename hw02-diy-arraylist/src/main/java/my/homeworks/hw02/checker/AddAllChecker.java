package my.homeworks.hw02.checker;

import java.util.ArrayList;
import java.util.List;

public class AddAllChecker extends Checker
{

    public AddAllChecker(List<String> diy) {
        super(diy);
    }

    @Override
    public void check()
    {
        getDiy().addAll(getOtherCollection());
        printDiy();
    }

    private List<String> getOtherCollection()
    {
        List<String> c = new ArrayList<>();

        final int sz = 20;
        for (int i = 0; i < sz; ++i) {
            c.add("B".repeat(i + 1));
        }
        return c;
    }
}
