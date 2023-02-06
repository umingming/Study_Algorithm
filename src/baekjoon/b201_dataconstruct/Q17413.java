package baekjoon.b201_dataconstruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

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
 * [예제 출력]
 * noojkeab enilno egduj
 * [풀이]
 * 1. Stack, String 선언
 * 2. flag 선언
 * 3. 한글자씩 끊어서 그 글자가 무엇인지 판별
 *  > "<"일 시
 *      > stack의 값 전부 pop하여 append
 *      > isBracket Flag True로 변경
 *  > ">"일 시
 *      > 해당 값 append
 *      > isBracket Flag false로 변경
 *  > "플래그 판정"
 *  > " "일 시
 *      > 해당 값 append
 *  > else
 *      > stack에 push
 */
public class Q17413 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean isBracket = false;

        for (int i=0; i<input.length(); ++i) {

            char c = input.charAt(i);

            if (c == '<') {
                isBracket = true;
                printStack(stack);
                System.out.print(c);
            } else if (c == '>') {
                isBracket = false;
                System.out.print(c);
            } else if (isBracket) {
                System.out.print(c);
            } else if (c == ' ') {
                printStack(stack);
                System.out.print(c);
            } else {
                stack.push(c);
            }
        }

        printStack(stack);


    }

    private static void printStack(Stack<Character> stack) {
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }


}
