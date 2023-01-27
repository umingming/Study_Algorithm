package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 개수 세기
 *
 * [문제]
 * 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.
 *
 * [입력]
 * 11
 * 1 4 1 2 4 2 4 2 3 4 4
 * 2
 *
 * [결과]
 * 3
 */
public class Q10807 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] resultArr = new int[Integer.parseInt(reader.readLine())];

        String[] input = reader.readLine().split(" ");
        int count = 0;

        for(int i=0; i<resultArr.length; ++i) {
            resultArr[i] = Integer.parseInt(input[i]);
        }

        int isSameValue = Integer.parseInt(reader.readLine());

        for (int j : resultArr) {
            if (j == isSameValue) {
                ++count;
            }
        }

        System.out.println(count);








    }

}
