package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * [문제]
 * P[0], P[1], ...., P[N-1]은 0부터 N-1까지(포함)의 수를 한 번씩 포함하고 있는 수열이다.
 * 수열 P를 길이가 N인 배열 A에 적용하면 길이가 N인 배열 B가 된다. 적용하는 방법은 B[P[i]] = A[i]이다.
 *
 * 배열 A가 주어졌을 때, 수열 P를 적용한 결과가 비내림차순이 되는 수열을 찾는 프로그램을 작성하시오.
 * 비내림차순이란, 각각의 원소가 바로 앞에 있는 원소보다 크거나 같을 경우를 말한다. 만약 그러한 수열이 여러개라면 사전순으로 앞서는 것을 출력한다.
 *
 * [예제 1]
 * 3
 * 2 3 1
 *
 * [결과 1]
 * 1 2 0
 *
 * [예제 2]
 * 4
 * 2 1 3 1
 *
 * [결과 2]
 * 2 0 3 1
 *
 * [예제 3]
 * 8
 * 4 1 6 1 3 6 1 4
 *
 * [결과 3]
 * 4 0 6 1 3 7 2 5
 *
 */
public class Q1015 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(reader.readLine());
        int[] inputArr = new int[repeat];

        String[] arr = reader.readLine().split(" ");

        for(int i=0; i<arr.length; ++i) {
            inputArr[i] = Integer.parseInt(arr[i]);
        }

    }

}
