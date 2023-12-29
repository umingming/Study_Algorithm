package inflearn.재귀함수트리그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * [트리]
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 *
 *
 * [풀이]
 * 1. ArrayList내에 ArrayList를 만들어 인접 리스트를 만들어준다.
 * 2. DFS를 돌아준다.
 *  2.1. 파라미터로 들어온 값의 리스트를 쭉 돈다.
 *  2.2. 만약 그 값이 n이면 result를 1 더해준다.
 *  2.3. 아니면 방문 체크를 하고 그 수를 DFS로 넣어준다.
 *  2.4. 방문 체크를 해제한다.
 *
 * [리스트로 넣었을 때]
 * 1 -> 2, 3, 4
 * 2 -> 1, 3, 5
 * 3 -> 4
 * 4 -> 2, 5
 */
public class 경로탐색연결리스트 {

    static int n = 5;

    static int[] ch;

    static int result = 0;

    static List<List<Integer>> graph;

    public static void DFS(int v) {

        if (v == 5) {
            result++;
        } else {
            for(int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        graph = new LinkedList<>();
        ch = new int[n+1];

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
        DFS(1);

        System.out.println(result);

    }

}
