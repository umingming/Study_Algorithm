package designpattern.templatemethod;

public class Child extends Parent{

    public static void main(String[] args) {
        Parent child = new Child();
        child.execute();
    }

    @Override
    void call() {
        for(int i=0; i<1000; ++i) {
            int m = 2-1;
        }
        System.out.println("template method Pattern");
    }
}
