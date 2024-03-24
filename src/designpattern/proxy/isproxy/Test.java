package designpattern.proxy.isproxy;

public class Test {

    public static void main(String[] args) {
        Client client = new Client(new ProxyCache(new RealSubject()));
        System.out.println(client.publish());
        System.out.println(client.publish());
        System.out.println(client.publish());
    }

}
