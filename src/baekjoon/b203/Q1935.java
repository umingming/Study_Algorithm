package baekjoon.b203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산하는 프로그램을 작성하시오.
 *
 * [문제]
 * 5
 * ABC*+DE/-
 * 1
 * 2
 * 3
 * 4
 * 5
 *
 * [결과]
 * 6.20
 *
 * 1. ABC*+DE/-
 * 2. A(B*C)+DE/-
 * 3. A+(B*C)DE/-
 * 4. A+(B*C)D/E
 * 5. A+(B*C)-(D/E)
 *
 */
public class Q1935 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int cycle = Integer.parseInt(reader.readLine());
        String temp = reader.readLine();

        Double[] valueArr = new Double[cycle];

        for (int i=0; i<cycle; ++i) {
            valueArr[i] = Double.parseDouble(reader.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i=0; i<temp.length(); ++i) {

            char c = temp.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                stack.push(valueArr[(int)c - 65]);
            } else if (c == '+') {
                Double temp1 = stack.pop();
                Double temp2 = stack.pop();

                stack.push(temp2 + temp1);
            } else if (c == '-') {
                Double temp1 = stack.pop();
                Double temp2 = stack.pop();

                stack.push(temp2 - temp1);
            } else if (c == '/') {
                Double temp1 = stack.pop();
                Double temp2 = stack.pop();

                stack.push(temp2 / temp1);
            } else if (c == '*') {
                Double temp1 = stack.pop();
                Double temp2 = stack.pop();

                stack.push(temp2 * temp1);
            }


        }

        double result = stack.pop();

        System.out.printf("%.2f", result);





    }


}
