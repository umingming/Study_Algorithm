package inflearn.정렬과이분검색과결정알고리즘;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 좌표정렬 {

    public static void solution(List<Point> arr) {
        Collections.sort(arr);
    }

    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        /**
         * 2 7
         * 1 3
         * 1 2
         * 2 5
         * 3 6
         */
        list.add(new Point(2, 7));
        list.add(new Point(1, 3));
        list.add(new Point(1,2));
        list.add(new Point(2,5));
        list.add(new Point(3, 6));

        solution(list);

        for (Point point : list) {
            System.out.print(point.x + " " + point.y + "\n");
        }
    }


    public static class Point implements Comparable<Point>{

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
    }
}
