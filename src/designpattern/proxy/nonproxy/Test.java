package designpattern.proxy.nonproxy;

public class Test {

    public static void main(String[] args) {
        Client client = new Client(new SubjectImpl());
        System.out.println(client.publish());
        System.out.println(client.publish());
        System.out.println(client.publish());
    }

}
