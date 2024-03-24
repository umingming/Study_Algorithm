package designpattern.proxy.nonproxy;

public class SubjectImpl implements Subject {

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
