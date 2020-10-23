package hw01.gradle;

import com.google.common.base.*;

class HelloOtus
{
    public static void main(String[] strings)
    {
        (new HelloOtus()).tryCallGuava();
    }

    public void tryCallGuava()
    {
        String[] arr = {"1","2","3"};

        String str = Joiner.on(',').join(arr);
        System.out.println(str);
    }
}
