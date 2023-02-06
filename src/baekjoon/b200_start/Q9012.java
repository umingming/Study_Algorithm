package baekjoon.b200_start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * [문제]
 * 괄호 문자열(Parenthesis String, PS)은 두 개의 괄호 기호인 ‘(’ 와 ‘)’ 만으로 구성되어 있는 문자열이다.
 * 그 중에서 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
 * 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다.
 * 만일 x 가 VPS 라면 이것을 하나의 괄호에 넣은 새로운 문자열 “(x)”도 VPS 가 된다.
 * 그리고 두 VPS x 와 y를 접합(concatenation)시킨 새로운 문자열 xy도 VPS 가 된다.
 * 예를 들어 “(())()”와 “((()))” 는 VPS 이지만 “(()(”, “(())()))” , 그리고 “(()” 는 모두 VPS 가 아닌 문자열이다.
 * 여러분은 입력으로 주어진 괄호 문자열이 VPS 인지 아닌지를 판단해서 그 결과를 YES 와 NO 로 나타내어야 한다.
 *
 * 1. 스텍을 생성한다.
 * 2. 몇 번 돌지 BufferedReader로 count 변수에 할당해준다.
 * 3. for문을 count만큼 돌아준다.
 * 4. String 값을 입력 받는다.
 *      > 입력한 값을 한 글자씩 자른다(charToArry)
 *      > 자른 글자들에 대한 분기 시작
 *          > 값이 (일 때
 *              > push해준다
 *          > 값이 )일 때
 *              > 만약 stack의 값이 비었다면 push 후 break;
 *              > 만약 stack의 값이 있다면 pop
 *
 */
public class Q9012 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(reader.readLine());

        for(int i=0; i<count; ++i) {
            String temp = reader.readLine();
            for(int j=0; j<temp.length(); ++j) {
                char c = temp.charAt(j);

                if (c == '(') {
                    stack.push(1);
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        stack.push(1);
                        break;
                    } else {
                        stack.pop();

                    }
                }

            }
            if (stack.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");

            }

            stack.clear();

        }

        System.out.println(sb);


    }//main
}//class
