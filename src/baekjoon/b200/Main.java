package baekjoon.b200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * [문제]
 * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 *
 * 명령은 총 여섯 가지이다.
 *
 * push X: 정수 X를 큐에 넣는 연산이다.
 * pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 큐에 들어있는 정수의 개수를 출력한다.
 * empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
 * front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 *
 * [풀이]
 * 1. 선언 필요 자료형
 *  > LinkedList BufferedReader String int StringBuilder
 * 2. spin이라는 int 변수에 몇 번 루프를 돌지 받아준다.
 * 3. for문을 돌아준다.
 * 4. 분기를 나눈다
 *  > push일 때 = LinkedList 제일 앞에 값을 넣어준다.
 *  > pop일 때 =
 *  >
 *
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int spin = getRepeatCount(reader);

        for (int i = 0; i < spin; ++i) {
            String input = reader.readLine();

            inputHandling(list, sb, input);
        }

        System.out.println(sb);

    }

    private static void inputHandling(List<String> list, StringBuilder sb, String input) {
        if (input.startsWith("push")) {
            push(list, input);
        } else if (input.equals("pop")) {
            pop(list, sb);
        } else if (input.equals("size")) {
            sb.append(list.size()).append("\n");
        } else if (input.equals("empty")) {
            empty(list, sb);
        } else if (input.equals("front")) {
            front(list, sb);
        } else if (input.equals("back")) {
            back(list, sb);
        }
    }

    private static void back(List<String> list, StringBuilder sb) {
        if (list.size() == 0) sb.append(-1);
        else sb.append(list.get(list.size() - 1)).append("\n");
    }

    private static void front(List<String> list, StringBuilder sb) {
        if (list.size() == 0) sb.append(-1).append("\n");
        else sb.append(list.get(0)).append("\n");
    }

    private static void empty(List<String> list, StringBuilder sb) {
        if (list.size() == 0 ) sb.append(1+"\n");
        else sb.append(0).append("\n");
    }

    private static void pop(List<String> list, StringBuilder sb) {
        if (list.size() == 0) sb.append(-1).append("\n");
        else {
            sb.append(list.get(0)).append("\n");
            list.remove(0);
        }
    }

    private static void push(List<String> list, String input) {
        list.add(input.substring(input.indexOf(" ") + 1));
    }

    private static int getRepeatCount(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}
