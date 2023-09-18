package inflearn.스텍과큐;

import datastruct.stack.nodestack.Stack;

public class 괄호문자제거 {

    public String solution(String s) {

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                stack.pop();
            }
            else {
                if (stack.isEmpty()) sb.append(c);
            }
        }

        return new String(sb);
    }

    public static void main(String[] args) {
        괄호문자제거 solution = new 괄호문자제거();
        System.out.println(solution.solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));

    }
}
