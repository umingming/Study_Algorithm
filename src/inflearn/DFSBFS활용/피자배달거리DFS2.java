package inflearn.DFSBFS활용;

import java.util.ArrayList;
import java.util.List;

/**
 * 설명
 *
 * N×N 크기의 도시지도가 있습니다. 도시지도는 1×1크기의 격자칸으로 이루어져 있습니다.
 * 각 격자칸에는 0은 빈칸, 1은 집, 2는 피자집으로 표현됩니다. 각 격자칸은 좌표(행번호, 열 번호)로 표현됩니다.
 *
 * 행번호는 1번부터 N번까지이고, 열 번호도 1부터 N까지입니다.
 * 도시에는 각 집마다 “피자배달거리”가 았는데 각 집의 피자배달거리는 해당 집과 도시의 존재하는
 * 피자집들과의 거리 중 최소값을 해당 집의 “피자배달거리”라고 한다.
 *
 * 집과 피자집의 피자배달거리는 |x1-x2|+|y1-y2| 이다.
 *
 *
 * (1, 2)에 있는 집과 (2, 3)에 있는 피자집과의 피자 배달 거리는 |1-2| + |2-3| = 2가 된다.
 *
 * 최근 도시가 불경기에 접어들어 우후죽순 생겼던 피자집들이 파산하고 있습니다.
 * 도시 시장은 도시에 있는 피자집 중 M개만 살리고 나머지는 보조금을 주고 폐업시키려고 합니다.
 * 시장은 살리고자 하는 피자집 M개를 선택하는 기준으로 도시의 피자배달거리가 최소가 되는 M개의 피자집을 선택하려고 합니다.
 *
 * 도시의 피자 배달 거리는 각 집들의 피자 배달 거리를 합한 것을 말합니다.
 *
 * [풀이]
 * 0. x값과 y값을 저장하기 위한 커스텀 클래스인 Point를 만든다.
 *  0.1. 멤버 변수는 int x, int y이다.
 * 1. 배열을 순회하며 houseList와 PizzaList를 저장한다.
 * 2. 조합 리스트인 dis 배열을 생성한다.
 * 3. DFS를 돌면서 조합 리스트를 담아준다
 *  3.1. DFS 마지막부에 조합들을 뽑아서 계산해준다.
 *  3.2. 집 값 기준으로 최소 sum값 구하기
 *      3.2.1. 즉 이 문제의 핵심은 각 집에서 가장 가까운 피자집과의 거리를 구한다.
 *      3.2.2. 위 사항을 모두 더하면 도시의 거리이다.
 *  3.3. resultSum과 비교한다.
 */

public class 피자배달거리DFS2 {

    //0. x값과 y값을 저장하기 위한 커스텀 클래스인 Point를 만든다.
    static class Point {

        int x;

        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int M = 4;

    static List<Point> houseList = new ArrayList<>();

    static List<Point> pizzaList = new ArrayList<>();

    static int[] results;

    static int resultSum = Integer.MAX_VALUE;

    public static void main(String[] args) {
        피자배달거리DFS2 solution = new 피자배달거리DFS2();

        int[][] arr = new int[][] {
                { 0, 1, 2, 0 }
                , { 1, 0, 2, 1 }
                , { 0, 2, 1, 2 }
                , { 2, 0, 1, 2 }
        };

        results = new int[M];

        //1. 배열을 순회하며 houseList와 PizzaList를 저장한다.
        solution.setPizzaAndHouseList(arr);

        solution.DFS(0, 0);
        System.out.println(resultSum);
    }

    private void setPizzaAndHouseList(int[][] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[0].length; ++j) {
                if (arr[i][j] == 1) {
                    houseList.add(new Point(i, j));
                } else if (arr[i][j] == 2) {
                    pizzaList.add(new Point(i, j));
                }
            }
        }
    }

    public void DFS(int L, int s) {
        if (L == M) {
            int sum = 0;
            for (Point house : houseList) {
                int dis = Integer.MAX_VALUE;
                for (int result : results) {
                    Point pizza = pizzaList.get(result);
                    dis = Math.min(dis, (Math.abs(house.x - pizza.x) + Math.abs(house.y - pizza.y)));
                }
                sum += dis;
            }
            resultSum = Math.min(resultSum, sum);
        } else {
            for (int i = s; i < pizzaList.size(); ++i) {
                results[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}
