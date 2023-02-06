package baekjoon.b203_dataconstruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 네 수
 *
 * [문제]
 * 네 자연수 A, B, C, D가 주어진다. 이때, A와 B를 붙인 수와 C와 D를 붙인 수의 합을 구하는 프로그램을 작성하시오.
 *
 * 두 수 A와 B를 합치는 것은 A의 뒤에 B를 붙이는 것을 의미한다. 즉, 20과 30을 붙이면 2030이 된다.
 *
 * [입력]
 * 10 20 30 40
 *
 * [결과]
 * 4060
 *
 */
public class Q10824 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        String first = input[0] + input[1];
        String second = input[2] + input[3];

        long firstNumber = Long.parseLong(first);
        long secondNumber = Long.parseLong(second);

        System.out.println(firstNumber+secondNumber);
    }

}
