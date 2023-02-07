package baekjoon.b300_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * [문제]
 * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 *
 * [출력]
 * 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 *
 * [입력 1]
 * 24 18
 *
 * [결과 1]
 * 6
 * 72
 *
 *
 *
 */
public class Q2609 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        String[] arr = reader.readLine().split(" ");
        int[] intArr = {24, 18};

//        for (int i = 0; i < arr.length; ++i) {
//            intArr[i] = Integer.parseInt(arr[i]);
//        }

        // 최대 공약수
        int gcd = 1;
        
        boolean loopFlag = true;

        while (loopFlag) {

            if (intArr[0] % 2 == 0 && intArr[1] % 2 == 0) {
                intArr[0] = intArr[0] / 2;
                intArr[1] = intArr[1] / 2;
                gcd = gcd * 2;
            } else if (intArr[0] % 3 == 0 && intArr[1] % 3 == 0) {
                intArr[0] = intArr[0] / 3;
                intArr[1] = intArr[1] / 3;
                gcd = gcd * 3;
            } else if (intArr[0] % 5 == 0 && intArr[1] % 5 == 0) {
                intArr[0] = intArr[0] / 5;
                intArr[1] = intArr[1] / 5;
                gcd = gcd * 5;
            } else if (intArr[0] % 7 == 0 && intArr[1] % 7 == 0) {
                intArr[0] = intArr[0] / 7;
                intArr[1] = intArr[1] / 7;
                gcd = gcd * 7;
            } else loopFlag = false;

        }

        System.out.println(gcd);
        System.out.println(gcd * intArr[0] * intArr[1]);


    }
}
