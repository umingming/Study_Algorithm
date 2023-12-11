package inflearn.재귀함수트리그래프;

import java.util.*;

/**
 * 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
 *
 * 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
 *
 * 송아지는 움직이지 않고 제자리에 있다.
 *
 * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
 * 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
 */
public class 송아지찾기BFS {

    public static Optional<Integer> BFS(int now, int target) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(now);
        visited.add(now);

        int L = 0;
        int[] moves = {-1, 1, 5};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                int num = queue.poll();

                if (num == target) {
                    return Optional.of(L);
                }

                for (int move : moves) {
                    int nextNum = num + move;
                    if (!visited.contains(nextNum)) {
                        queue.offer(nextNum);
                        visited.add(nextNum);
                    }
                }
            }

            L++;
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        Optional<Integer> result = BFS(5, 14);
        System.out.println(result.orElse(-1));
    }

}
