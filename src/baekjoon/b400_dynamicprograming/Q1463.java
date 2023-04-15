package baekjoon.b400_dynamicprograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 1로 만들기
 *
 * 정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
 *
 * X가 3으로 나누어 떨어지면, 3으로 나눈다.
 * X가 2로 나누어 떨어지면, 2로 나눈다.
 * 1을 뺀다.
 * 정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다.
 * 연산을 사용하는 횟수의 최솟값을 출력하시오.
 *
 * 2 -> 1
 * 10 -> 3
 *
 * 10 -> 5 -> 4 -> 2 -> 1
 * 30 -> 10 -> 5 -> 4 -> 2 -> 1
 *
 */
public class Q1463 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        int n = Integer.parseInt(reader.readLine());
        int n = 10;

        // N까지의 숫자에 대한 최소 연산 횟수를 저장할 DP 테이블
        int[] dp = new int[n+1];

        // 1은 이미 1을 만들기 위한 연산 횟수가 0이므로, 2부터 N까지 탐색
        for (int i = 2; i <= n; i++) {
            // 이전 수에서 1을 뺀 연산 횟수에 1을 더함
            dp[i] = dp[i-1] + 1;

            // 현재 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                // 2로 나눈 수에서 1을 더한 연산 횟수와 현재까지 계산된 연산 횟수 중 최소값 선택
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
            // 현재 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                // 3으로 나눈 수에서 1을 더한 연산 횟수와 현재까지 계산된 연산 횟수 중 최소값 선택
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }
        }

        // N을 1로 만들기 위한 최소 연산 횟수 출력
        System.out.println(dp[n]);
    }





}
