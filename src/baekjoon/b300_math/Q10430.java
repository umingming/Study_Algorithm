package baekjoon.b300_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 나머지
 *
 * [문제]
 * (A+B)%C는 ((A%C) + (B%C))%C 와 같을까?
 *
 * (A×B)%C는 ((A%C) × (B%C))%C 와 같을까?
 *
 * 세 수 A, B, C가 주어졌을 때, 위의 네 가지 값을 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
 *
 * [입력 1]
 * 5 8 4
 *
 * [결과 1]
 * 1
 * 1
 * 0
 * 0
 *
 *
 */
public class Q10430 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = reader.readLine().split(" ");

        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);
        int C = Integer.parseInt(arr[2]);

        int[] resultArr = new int[4];

        resultArr[0] = (A+B)%C;
        resultArr[1] = ((A%C) + (B%C))%C;
        resultArr[2] = (A*B)%C;
        resultArr[3] = ((A%C) * (B%C))%C;

        for (int i : resultArr) {
            System.out.println(i);
        }


    }
}
