package inflearn.DFSBFS활용;

import java.util.ArrayList;
import java.util.List;

import inflearn.재귀함수트리그래프.DFS;

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
 * 1. hs와 pz를 나누어 저장한다.
 * 2. 조합을 구하는 메소드를 만든다.
 * 3. 집을 돈다.
 * 4. 조합에서 나온 결과를 피자집에서 들고온다.
 * 5. 그 결과들을 더한다.
 * 6. 집집별로 테스트
 */
public class 피자배달거리DFS {

    static class Point {

        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int M = 4;

    static int resultSum = Integer.MAX_VALUE;

    static List<Point> houseList = new ArrayList<>();

    static List<Point> pizzaList = new ArrayList<>();

    private int[] results = new int[M];

    public static void main(String[] args) {
        피자배달거리DFS solution = new 피자배달거리DFS();

        int[][] arr = new int[][] {
                { 0, 1, 2, 0 }
                , { 1, 0, 2, 1 }
                , { 0, 2, 1, 2 }
                , { 2, 0, 1, 2 }
        };

        //1. hs와 pz를 나누어 저장한다.
        solution.setHouseAndPizza(arr);
        solution.DFS(0, 0);

        System.out.println(resultSum);
    }

    private void setHouseAndPizza(int[][] arr) {
        for(int i=0; i<arr.length; ++i) {
            for(int j=0; j<arr[i].length; ++j) {
                int point = arr[i][j];
                if (point == 1) {
                    houseList.add(new Point(i, j));
                } else if (point == 2) {
                    pizzaList.add(new Point(i, j));
                }
            }
        }
    }

    private void DFS(int L, int s) {
        if (L == M) {
            int sum = 0;
            for(Point house : houseList) {
                int dis = Integer.MAX_VALUE;
                for(int result : results) {
                    Point pizza = pizzaList.get(result);
                    dis = Math.min(dis, (Math.abs(house.x - pizza.x) + Math.abs(house.y - pizza.y)));
                }
                sum += dis;
            }
            resultSum = Math.min(resultSum, sum);
        } else {
            for(int i=s; i<pizzaList.size(); ++i) {
                results[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

}
