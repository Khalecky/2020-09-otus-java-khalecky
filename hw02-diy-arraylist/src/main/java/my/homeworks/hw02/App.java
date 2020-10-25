/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package my.homeworks.hw02;
import my.homeworks.hw02.DiyArrayList.DiyArrayList;
import my.homeworks.hw02.checker.*;

import java.util.ArrayList;
import java.util.List;

public class App
{
    private List<Checker> checkers = new ArrayList<>();

    App()
    {
        checkers.add(new CopyChecker(createDiy()));
        checkers.add(new SortChecker(createDiy()));
        checkers.add(new AddAllChecker(createDiy()));
    }

    public static void main(String[] args)
    {
        new App().run();
    }

    private void run()
    {
        for (Checker checker: checkers) {
            System.out.println("------");
            checker.check();
        }
    }

    private List<String> createDiy()
    {
        final int listSize = 40;
        List<String> diy = new DiyArrayList<>();
        for (int i = 0; i < listSize; ++i) {
            String r = "A".repeat(i+1);
            diy.add(r);
        }
        return diy;
    }

}
