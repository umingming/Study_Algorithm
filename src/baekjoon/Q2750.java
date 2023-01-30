package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 수 정렬하기
 *
 * [문제]
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 *
 * [입력]
 * 5
 * 5
 * 2
 * 3
 * 4
 * 1
 *
 * [결과]
 * 1
 * 2
 * 3
 * 4
 * 5
 *
 * [풀이]
 * 버블 정렬 해준다
 *
 *
 */
public class Q2750 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int repeat = Integer.parseInt(reader.readLine());
        int[] arr = new int[repeat];

        for (int i=0; i<repeat; ++i) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        bubbleSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    public static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length);
    }

    public static void bubbleSort(int[] arr, int lastIndex) {

        if (lastIndex > 0) {

            for(int i=1; i<lastIndex; ++i) {
                if (arr[i-1] > arr[i]) {
                    swap(arr, i-1, i);
                }
            }
            bubbleSort(arr, lastIndex-1);
        }

    }

    public static void swap(int[] arr, int source, int target) {
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;

    }

}
