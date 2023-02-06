package baekjoon.b200_start;

import java.util.LinkedList;
import java.util.Queue;

/**
 * [문제]
 * 요세푸스 문제는 다음과 같다.
 *
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
 * 이제 순서대로 K번째 사람을 제거한다.
 * 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
 * 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
 * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
 *
 * 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 *
 * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
 *
 * [풀이]
 *
 * 1. BufferedReader, String으로 값 받음 Queue(Integer) 선언
 * 2. int n int k 나눈다
 * 3. k가 n보다 클 경우 exception 처리
 * 4.
 */
public class Q1158_2 {
    public static void main(String[] args) throws Exception {

        Queue<Integer> queue = new LinkedList<>();

        String input = "(7, 3)";
        StringBuilder result = new StringBuilder("<");

        int n = Integer.parseInt(input.substring(1, input.indexOf(",")));
        int k = Integer.parseInt(input.substring(input.indexOf(" ")+1, input.indexOf(")")));
        if (k > n) {
            System.out.println("k가 n보다 크면 안됨.");
            throw new Exception();
        }

        for(int i=1; i<n+1; ++i) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {

            int pointer = 1;


            for(int i=0; i<k; ++i) {
                if (pointer == k) {
                    result.append(queue.poll()).append(",");
                } else {
                    startFromEnd(queue);
                }

                ++pointer;

            }
        }

        result.delete(result.length()-1, result.length());
        result.append(">");

        System.out.println(result);

    }

    public static void startFromEnd(Queue<Integer> queue) {
        queue.add(queue.poll());
    }
}
