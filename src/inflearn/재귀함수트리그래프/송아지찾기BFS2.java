package inflearn.재귀함수트리그래프;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 설명
 *
 * 현수는 송아지를 잃어버렸다. 다행히 송아지에는 위치추적기가 달려 있다.
 * 현수의 위치와 송아지의 위치가 수직선상의 좌표 점으로 주어지면 현수는 현재 위치에서 송아지의 위치까지 다음과 같은 방법으로 이동한다.
 * 송아지는 움직이지 않고 제자리에 있다.
 * 현수는 스카이 콩콩을 타고 가는데 한 번의 점프로 앞으로 1, 뒤로 1, 앞으로 5를 이동할 수 있다.
 * 최소 몇 번의 점프로 현수가 송아지의 위치까지 갈 수 있는지 구하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 직선의 좌표 점은 1부터 10,000까지이다.
 *
 * 출력
 */
public class 송아지찾기BFS2 {

    public static int BFS(int source, int target) {
        int result = 0;

        int LV = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; ++i) {
                int peek = queue.poll();
                if (peek == target) {
                    result = LV;
                    return result;
                } else {
                    queue.add(peek+1);
                    if (peek - 1 > 0) {
                        queue.add(peek-1);
                    }
                    queue.add(peek+5);
                }
            }

            LV++;
        }

        return result;
    }


    public static void main(String[] args) {
        int source = 5;
        int target = 14;

        System.out.println(BFS(source, target));
    }

}
