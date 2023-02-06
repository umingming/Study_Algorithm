package baekjoon.b203_math;

import java.util.Stack;

/**
 * 이러한 사실을 알고 중위 표기식이 주어졌을 때 후위 표기식으로 고치는 프로그램을 작성하시오
 *
 * [문제]
 * A+(B*C)-(D/E)
 *
 * [답]
 * ABC*+DE/-
 *
 * [문제]
 * A*(B+C)
 *
 * [답]
 * ABC+*
 *
 * 1. 알파벳이면 걍 넘겨
 * 2. 연산자면 push해
 * 3. (면면 무시해
 * 4. )이면 팝해
 */
public class Q1918 {

    public static void main(String[] args) {
        String input = "A+B*C-D/E";
        StringBuilder sb = new StringBuilder();

        Stack stack = new Stack();

        for(int i=0; i<input.length(); ++i) {
            if ((input.charAt(i) >= 'A' && input.charAt(i) <= 'Z')) {
                sb.append(input.charAt(i));
            } else if((input.charAt(i) == '+') || (input.charAt(i) == '-') || (input.charAt(i) == '*') || (input.charAt(i) == '/')) {
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);


    }

}
