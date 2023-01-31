package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 소수 찾기
 *
 * [문제]
 *
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 *
 * [입력]
 * 4
 * 1 3 5 7
 *
 * [결과]
 * 3
 *
 * [풀이]
 * ㄱ. 소수를 구하는 법
 *  > 1일때 false 처리 (소수가 아님)
 *  > 2일때 true 처리 (소수)
 *  > 2부터 n-1까지를 나눴을 때 나머지 값이 0인 것이 하나라도 있으면 true (소수)
 * ㄴ. 소수일 시 카운팅
 */
public class Q1978 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(reader.readLine());
        int isPrimeNumber = 0;

        int[] intArr = new int[repeat];

        String[] arr = reader.readLine().split(" ");

        for(int i=0; i<arr.length; ++i) {
            intArr[i] = Integer.parseInt(arr[i]);
        }

        for(int i=0; i<intArr.length; ++i) {
            boolean flag = true;

            if (intArr[i] == 2) {
                flag = true;
            } else if (intArr[i] > 2) {

                for(int j=2; j<intArr[i]; ++j) {
                    if (intArr[i] % j == 0) {
                        flag = false;
                        break;
                    }
                }

            } else flag = false;

            if (flag) {
                isPrimeNumber++;
            }
        }

        System.out.println(isPrimeNumber);

    }

}
