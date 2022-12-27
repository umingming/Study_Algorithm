package baekjoon.b200;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * [문제]
 * 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
 * <p>
 * 명령은 총 여덟 가지이다.
 * <p>
 * push_front X: 정수 X를 덱의 앞에 넣는다.
 * push_back X: 정수 X를 덱의 뒤에 넣는다.
 * pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 덱에 들어있는 정수의 개수를 출력한다.
 * empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
 * front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * <p>
 * [풀이]
 * 1. ArrayList 선언
 * 2. 버퍼 선언해서 얼마나 받을지 count 변수 할당
 * 3. for문 볼면서 count만큼 돌아줌
 * 3. input값이 무엇인지 확인 위해 split으로 잘라줌
 * > inputArr[0]이
 * > push_front일 때 = 리스트의 0번째에 inputArray[1]을 넣어준다
 * > push_back일 때 = inputArray[1]을 넣어준다
 */
public class Q10866 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> deque = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; ++i) {
            String[] inputArray = reader.readLine().split(" ");

            if (inputArray[0].equals("push_front")) {
                deque.add(0, Integer.parseInt(inputArray[1]));
            } else if (inputArray[0].equals("push_back")) {
                deque.add(Integer.parseInt(inputArray[1]));
            } else if (inputArray[0].equals("pop_front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.get(0));
                    deque.remove(0);
                }
            } else if (inputArray[0].equals("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.get(deque.size() - 1));
                    deque.remove(deque.size()-1);
                }
            } else if (inputArray[0].equals("size")) {
                System.out.println(deque.size());
            } else if (inputArray[0].equals("empty")) {

                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }

            } else if (inputArray[0].equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.get(0));
                }
            } else if (inputArray[0].equals("back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.get(deque.size()-1));
                }

            }

        }
    }
}
