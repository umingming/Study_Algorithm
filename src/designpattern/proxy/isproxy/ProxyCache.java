package designpattern.proxy.isproxy;

public class ProxyCache implements Subject {
    Subject subject;

    String cacheValue;

    public ProxyCache(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String publish() {
        if (cacheValue == null) {
            cacheValue = subject.publish();
        }

        return cacheValue;
    }
}
