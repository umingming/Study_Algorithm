package technical;

public class DeadLock {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();


        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("[t1] get lock1");
                synchronized (lock2) {
                    System.out.println("[t1] get lock2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("[t2] get lock2");
                synchronized (lock1) {
                    System.out.println("[t2] get lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }

}
