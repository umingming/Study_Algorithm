package designpattern.전략;

public class Client {

    public static void main(String[] args) {
        Paper parent = new Paper(new SportSubject());
        parent.paper();
    }
}
