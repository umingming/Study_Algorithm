package designpattern.proxy.nonproxy;

public class Client {

    Subject subject;

    public Client(Subject subject) {
        this.subject = subject;
    }

    public String publish() {
        return subject.publish();
    }
}
