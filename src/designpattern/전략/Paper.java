package designpattern.전략;

public class Paper {

    Subject subject;

    public Paper(Subject subject) {
        this.subject = subject;
    }

    void paper() {
        System.out.println("오늘의 토픽은");
        subject.topic();
    }

}
