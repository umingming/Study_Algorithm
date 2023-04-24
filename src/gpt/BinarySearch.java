package gpt;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 오름차순으로 정렬된 N개의 정수가 주어진다.
 * 이 중에서 특정한 숫자 x가 몇 번째 위치에 있는지 찾으시오.
 * 만약 찾는 숫자가 없다면 -1을 출력한다.
 *
 * 예를 들어, 1 3 5 7 9 11 13 15가 입력으로 주어지고 찾는 숫자가 7이라면, 4를 출력합니다.
 */
public class BinarySearch {

    public static void main(String[] args) throws IOException {

        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};

        int x = 7;

        binarySearch(arr, x);

    }

    public static void binarySearch(int[] arr, int target) {
        binarySearch(arr, target, 0, arr.length-1);
    }

    public static void binarySearch(int[] arr, int target, int startIndex, int endIndex) {

        if (arr.length==0) return;
        if (startIndex > endIndex) {
            System.out.println("-1");
            return;
        }

        int mid = (startIndex + (endIndex - startIndex)) / 2;

        if (arr[mid] == target) {
            System.out.println(mid+1);
        } else if (arr[mid] > target) {
            binarySearch(arr, target, mid, endIndex);
        } else {
            binarySearch(arr, target, startIndex, mid-1);
        }
    }
}
