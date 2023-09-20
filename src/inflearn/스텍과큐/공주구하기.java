package inflearn.스텍과큐;

import java.util.LinkedList;
import java.util.Queue;

public class 공주구하기 {

    public void solution(int member, int num) {
        Queue<Integer> queue1 = new LinkedList<>();

        init(queue1, member);

        int count = 1;

        while(queue1.size() != 1) {
            if (count == num) {
                queue1.poll();
                count = 1;
            } else {
                queue1.add(queue1.poll());
                count++;
            }
        }

        System.out.println(queue1.poll());

    }

    public void init(Queue<Integer> queue, int count) {
       for(int i=1; i<=count; ++i) queue.add(i);
    }

    public static void main(String[] args) {
       공주구하기 solution = new 공주구하기();
       solution.solution(8, 3);
    }

}
