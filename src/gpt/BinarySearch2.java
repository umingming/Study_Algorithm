package gpt;

import java.util.Arrays;

public class BinarySearch2 {

    public static void main(String[] args) {

        int[] fibonacci = new int[100];

        fibonacci[0] = 1;
        fibonacci[1] = 2;

        for(int i=2; i<fibonacci.length; ++i) {

            fibonacci[i]= fibonacci[i-2] + fibonacci[i-1];

        }

        binarySearch(fibonacci, 55);

    }

    public static void binarySearch(int[] arr, int target) {
        binarySearch(arr, target, 0, arr.length-1);
    }

    public static void binarySearch(int[] arr, int target, int start, int end) {

        if(start > end) return;
        int pivot = (end - start) / 2;

        if (arr[pivot] > target) {
            binarySearch(arr, target, start, pivot);
        } else if (arr[pivot] < target) {
            binarySearch(arr, target, pivot+1, end);
        } else {
            System.out.println(target+"은 " + pivot + "번째 인덱스에 있습니다.");
        }

    }

}
