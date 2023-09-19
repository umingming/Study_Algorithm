package inflearn.스텍과큐;

import java.util.Stack;

/**
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 *
 * 예시 입력 1
 * 352+*9-
 * 37*9-
 * 219-
 * 21-9
 *
 *
 * 예시 출력 1
 * 12
 */
public class 후위연산식 {

    public void solution(String s) {

        Stack<Integer> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if (Character.isDigit(c)) stack.push(c-48);
            else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(c=='+') stack.push(lt+rt);
                else if(c=='-') stack.push(lt-rt);
                else if(c=='*') stack.push(lt*rt);
                else if(c=='/') stack.push(lt/rt);
            }
        }

        System.out.println(stack.pop());
    }

    public static void main(String[] args) {
        후위연산식 solution = new 후위연산식();
        solution.solution("352+*9-");
    }

}
