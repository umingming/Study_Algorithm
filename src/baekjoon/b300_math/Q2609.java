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


        System.out.println(lcd(intArr[0], intArr[1]));
        System.out.println(gcd(intArr[0], intArr[1]));


    }

    private static int lcd(int a, int b) {
        return a * b / gcd(a, b);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
