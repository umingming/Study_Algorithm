package designpattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    interface Observer {
        void update(String news);
    }

    interface Subject {
        void registerObserver(Observer o);
        void removeObserver(Observer o);
        void notifyObserver();
    }

    static class NewsAgency implements Subject {
        private List<Observer> observerList = new ArrayList<>();
        private String news;

        public void setNews(String news) {
            this.news = news;
            notifyObserver();
        }

        @Override
        public void registerObserver(Observer o) {
            observerList.add(o);
        }

        @Override
        public void removeObserver(Observer o) {
            observerList.remove(o);
        }

        @Override
        public void notifyObserver() {
            observerList.stream().forEach(observer -> observer.update(news));
        }
    }

    static class NewsChannel implements Observer {
        private String news;

        @Override
        public void update(String news) {
            this.news = news;
            System.out.println("news = " + news);
        }
    }

    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        newsAgency.registerObserver(new NewsChannel());
        newsAgency.registerObserver(new NewsChannel());

        newsAgency.setNews("속보입니다. 옵저버 패턴이 유행하고 있습니다.");
    }

}
