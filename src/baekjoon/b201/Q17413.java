package baekjoon.b201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * [문제] 17413
 * 문자열 S가 주어졌을 때, 이 문자열에서 단어만 뒤집으려고 한다.
 * <p>
 * 먼저, 문자열 S는 아래와과 같은 규칙을 지킨다.
 * <p>
 * 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
 * 문자열의 시작과 끝은 공백이 아니다.
 * '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다.
 * 태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다.
 * 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
 * <p>
 * [예제 입력]
 * baekjoon online judge
 * <problem>17413<is hardest>problem ever<end>
 * <p>
 * [예제 출력]
 * noojkeab enilno egduj
 * <problem>31471<is hardest>melborp reve<end>
 * <p>
 * [풀이]
 * 1. Deque, BufferedReader, String, StringBuilder 선언
 * 2. 모든 글자를 Deque에 순서대로 넣어준다 (lastPush)
 * 3. firstPeek을 해서 그게 "<"인지 판별한다
 * > 맞다면 ">"가 나올때까지 firstPop (반복문)
 * > 아니라면 lastPop
 */
public class Q17413 {
    public static void main(String[] args) {


        String input = "<ab cd>ef gh<ij kl>";
        Deque<Character> deque = new LinkedList<>();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputArray = input.split(" ");

        for (int i = 0; i < inputArray.length; ++i) {

            for (int j = 0; j < inputArray[i].length(); ++j) {
                deque.push(inputArray[i].charAt(j));
            }

            while (!deque.isEmpty()) {

                if (deque.getFirst().equals("<")) {

                    while (!deque.getFirst().equals(">")) {
                        sb.append(deque.getLast());
                        sb.append(deque.removeLast());
                    }

                    sb.append(deque.pop());

                } else {
                    sb.append(deque.getFirst());
                    deque.removeFirst();
                }

            }

            sb.append(" ");
        }


        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb);


    }
}
