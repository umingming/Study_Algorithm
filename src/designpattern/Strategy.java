package designpattern;

/**
 * 전략 패턴
 *
 */
public class Strategy {

    public class SearchButton {
        private MyProgram myProgram;

        public SearchButton (MyProgram myProgram) {
            this.myProgram = myProgram;
        }

        private SearchStrategy strategy = new SearchStrategyAll();

        public void setStrategy (SearchStrategy strategy) {
            this.strategy =  strategy;
        }

        public void onClick() {
            strategy.search();
        }
    }

    interface SearchStrategy {
        public void search ();
    }

    class MyProgram {
        MyProgram myProgram = new MyProgram();

        SearchButton searchButton = new SearchButton(this);
    }

    class SearchStrategyAll implements SearchStrategy {
        @Override
        public void search() {
            System.out.println("Search All");
        }
    }

    class SearchStrategyIMAGE implements SearchStrategy {
        @Override
        public void search() {
            System.out.println("Search IMAGE");
        }
    }

    class SearchStrategyNEWS implements SearchStrategy {
        @Override
        public void search() {
            System.out.println("Search NEWS");
        }
    }

    class SearchStrategyMAPS implements SearchStrategy {
        @Override
        public void search() {
            System.out.println("Search MAPS");
        }
    }


}


