package designpattern.proxy.isproxy;

public class RealSubject implements Subject {

    @Override
    public String publish() {
        sleep();
        return "data";
    }

    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
