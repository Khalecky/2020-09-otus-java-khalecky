package my.homeworks.hw03.my_framework;

public class TestItem {

    private boolean success = true;

    private Handler handler;

    public TestItem(Handler handler) {
        this.handler = handler;
    }

    public void run() {

        try {
            handler.handle();
        } catch (Exception exception) {
            success = false;
        }

    }

    public boolean isSuccess() {
        return success;
    }

}
