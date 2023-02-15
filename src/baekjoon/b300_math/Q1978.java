package baekjoon.b300_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * [문제]
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 *
 * [출력]
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 *
 * [입력 1]
 * 4
 * 1 3 5 7
 *
 * [결과 1]
 * 3
 *
 * [풀이]
 * 2,3으로 나눴을 때 나누어지면 소수?
 *
 */
public class Q1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int firstInput = Integer.parseInt(reader.readLine());

        int[] arr = new int[firstInput];

        String[] temp = reader.readLine().split(" ");
        int sosooCount = 0;

        for(int i=0; i<temp.length; ++i) {

        }

        System.out.println(sosooCount);



    }

}
