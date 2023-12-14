package programmers.lv2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.
 *
 * x에 n을 더합니다
 * x에 2를 곱합니다.
 * x에 3을 곱합니다.
 * 자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
 */
public class 숫자변환하기 {

    public static int solution(int x, int y, int n) {
        if (x > y) return -1;

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(x);
        visited.add(x);

        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; ++i) {
                int current = queue.poll();

                if (current == y) {
                    return depth;
                }

                int plusN = current + n;
                int multiply2 = current * 2;
                int multiply3 = current * 3;

                if (plusN <= y && !visited.contains(plusN)) {
                    queue.offer(plusN);
                    visited.add(plusN);
                }

                if (multiply2 <= y && !visited.contains(multiply2)) {
                    queue.offer(multiply2);
                    visited.add(multiply2);
                }

                if (multiply3 <= y && !visited.contains(multiply3)) {
                    queue.offer(multiply3);
                    visited.add(multiply3);
                }
            }

            depth++;
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(solution(10, 40, 5));
    }
}
