package inflearn.재귀함수트리그래프;

import java.sql.PreparedStatement;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS로 그래프 최단거리 돌기
 *
 * [이걸 풀고, 이제 리턴값을 배열로 반환해보자 3번부터 끝까지 for문을 감싸면 될 듯]
 * 1. 값 초기화 (그래프, 체크 배열)
 * 2. BFS 메소드를 선언하여 그 내부에서 로직을 돌아준다
 * 3. Queue에 최초 들어온 값 1을 넣어준다.
 * 4. while문을 돌면서 BFS를 타준다.
 *  4.1. size를 뽑고, size만큼 루프를 돈다
 *  4.2. 해당 수가 end와 같은지 확인한다.
 *      4.2. 같다면 LV 리턴
 *      4.5. 다르다면 해당 수의 노드들을 Queue에 넣는다.
 *  4.2. 해당 수의 ch 배열이 0인지 확인한다. (1이면 안감)

 */
public class 그래프최단거리 {

    static int[] ch;

    static List<List<Integer>> graph;

    static int n;

    static int[] result;

    public static void BFS() {
        int Lv = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i=2; i<=n; ++i) {
            queue.add(1);

            while (!queue.isEmpty()) {
                int size = queue.size();

                for(int j=0; j<size; ++j) {
                    Integer poll = queue.poll();

                    if (ch[poll] == 0) {
                        if (poll == i) {
                            ch[poll] = 1;
                            result[i] = Lv;
                        } else {
                            ch[poll] = 1;
                            for(int lv : graph.get(poll)) {
                                queue.add(lv);
                            }
                        }
                    }
                }

                Lv++;
            }

            Lv = 0;

            for(int j=1; j< ch.length; ++j) {
                ch[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        n = 6;

        ch = new int[n+1];
        result = new int[n+1];

        graph = new LinkedList<>();

        for(int i=1; i<=n+1; ++i) {
            graph.add(new LinkedList<>());
        }

        graph.get(1).add(3);
        graph.get(1).add(4);
        graph.get(2).add(1);
        graph.get(2).add(5);
        graph.get(3).add(4);
        graph.get(4).add(5);
        graph.get(4).add(6);
        graph.get(6).add(5);
        graph.get(6).add(2);
        BFS();

        for(int i=0; i<result.length; ++i) {
            System.out.println(i + "번째 간선 까지의 거리 = " + result[i]);
        }


    }

}
