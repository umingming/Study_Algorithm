package baekjoon.b200;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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
 * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 *
 * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
 *
 * [풀이]
 * 1. Queue 선언
 * 2. input을 받는다
 *  > K가 N보다 크면 익셉션 발생
 *  > int n = (부터 ,까지의 숫자가 배열에 들어갈 총 수
 *  > int k = " "부터 )까지의 숫자가 건너띄는 수
 * 3. for문을 N번 돌며 Queue에 1부터 N까지 차례로 넣어준다
 *  * 1, 2, 3, 4, 5, 6, 7
 * 4. k-1번째까지는 수를 뒤로 보내주고, k번째에는 StringBuffer에 넣어준다.
 *
 */
public class Main {
    public static void main(String[] args) throws Exception {

        Queue<Integer> queue = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        StringBuilder result = new StringBuilder("<");

        int n = Integer.parseInt(input.substring(input.indexOf("(")+1, input.indexOf(",")));
        int k = Integer.parseInt(input.substring(input.indexOf(" ")+1, input.indexOf(")")));

        inputNumberValidation(n, k);

        addValueFromQueue(queue, n);

        while(!queue.isEmpty()) {

            int pointer = 1;
            josephusLogic(queue, result, k, pointer);
        }

        resultFormatting(result);

        System.out.println(result);
    } // main

    private static void resultFormatting(StringBuilder result) {
        result.delete(result.length()-2, result.length());
        result.append(">");
    }

    private static void josephusLogic(Queue<Integer> queue, StringBuilder result, int k, int pointer) {
        for(int i = 1; i< k +1; ++i) {
            if (pointer == k) {
                result.append(queue.poll()).append(", ");
            } else {
                moveFirstFromBehind(queue);
            }
            ++pointer;
        }
    }

    private static void addValueFromQueue(Queue<Integer> queue, int n) {
        for(int i = 1; i< n +1; ++i) {
            queue.add(i);
        }
    }

    private static void inputNumberValidation(int n, int k) throws Exception {
        if (k > n) {
            System.out.println("k가 n보다 크면 안됩니다.");
            throw new Exception();
        }
    }

    public static void moveFirstFromBehind(Queue<Integer> queue) {
        queue.add(queue.poll());
    }
}
