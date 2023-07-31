package designpattern;

/**
 * 해당 로직은 getInstance 메소드에서 하나의 스레드만 접근할 수 있도록 한 것이다.
 * Eager Loading 처리하여 private static Singleton instace  = new Singleton(); 의 형태로
 * 실행 시점에 바로 Instance를 사용하게 하는 방법도 있다.
 */
public class Singleton {
    private static Singleton instance;
    private boolean darkMode = false;
    private int fontSize = 200;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}