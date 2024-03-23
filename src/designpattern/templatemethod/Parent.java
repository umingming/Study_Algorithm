package designpattern.templatemethod;


import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Parent {

    public void execute() {
        LocalDateTime now = LocalDateTime.now();

        call();

        System.out.println(Duration.between(now, LocalDateTime.now()));
    }

    abstract void call();

}
