package inflearn.재귀함수트리그래프;


import java.util.LinkedList;
import java.util.List;

public class 경로탐색연결리스트2 {

    static List<List<Integer>> graph;
    static int n;
    static int result;

    static int[] ch;

    public void solution(int v) {
        if (v == n) {
            result++;
        } else {
            for(int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    solution(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        경로탐색연결리스트2 solution = new 경로탐색연결리스트2();

        n = 5;
        ch = new int[n+1];
        graph = new LinkedList<>();

        for(int i=1; i<=n; ++i) {
            graph.add(new LinkedList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(4);
        graph.get(2).add(1);
        graph.get(2).add(3);
        graph.get(2).add(5);
        graph.get(3).add(4);
        graph.get(4).add(2);
        graph.get(4).add(5);

        ch[1] = 1;
        solution.solution(1);

        System.out.println(result);

    }

}
