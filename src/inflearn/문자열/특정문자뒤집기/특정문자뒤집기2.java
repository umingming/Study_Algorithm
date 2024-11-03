package inflearn.문자열.특정문자뒤집기;

import java.util.Stack;

/**
 * 5. 특정 문자 뒤집기
 * 설명
 *
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 *
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 *
 *
 * 출력
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * a#b!GE*T@S
 * 예시 출력 1
 *
 * S#T!EG*b@a
 *
 * [풀이]
 * 1. 한 번 돌면서 스텍에 쌓는다.
 * 2. 한 번 더 돌면서 알파벳이면 스텍에서 뽑아 쓴다.
 */
public class 특정문자뒤집기2 {

    public static void main(String[] args) {
        특정문자뒤집기2 solution = new 특정문자뒤집기2();
        System.out.println(solution.solution("a#b!GE*T@S"));
    }

    public String solution(String input) {
        Stack<Character> stack = new Stack<>();

        char[] charArr = input.toCharArray();
        firstCheckAndInputStack(stack, charArr);
        return change(stack, charArr);
    }

    private void firstCheckAndInputStack(Stack<Character> stack, char[] charArr) {
        for (Character c : charArr) {
            if (Character.isAlphabetic(c)) {
                stack.push(c);
            }
        }
    }

    private String change(Stack<Character> stack, char[] charArr) {
        StringBuilder sb = new StringBuilder();
        for (Character c : charArr) {
            if (Character.isAlphabetic(c)) {
                sb.append(stack.pop());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
