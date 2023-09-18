package inflearn.스텍과큐;

import datastruct.stack.nodestack.Stack;

public class 올바른괄호 {


    public String solution(String s) {

        String answer = "";

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if (c == ')') {
                if (stack.pop() != '(') return "No";
            } else {
                stack.push(c);
            }
        }

        if (!stack.isEmpty()) {
            return "No";
        } else {
            return "Yes";
        }

    }

    public static void main(String[] args) {
        올바른괄호 solution = new 올바른괄호();
        System.out.println(solution.solution("(()(()))(()"));
    }

}
