package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q25305 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int[] arr = new int[Integer.parseInt(input[0])];
        int resultIndex = Integer.parseInt(input[1]);

        String[] inputArr = reader.readLine().split(" ");

        for(int i=0; i<inputArr.length; ++i) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }

        bubbleSort(arr);

        System.out.println(arr[arr.length-resultIndex]);

    }

    public static void bubbleSort(int [] arr) {
        bubbleSort(arr, arr.length-1);
    }

    public static void bubbleSort(int[] arr, int lastIndex) {

        if(lastIndex > 0) {

            for(int i=1; i<=lastIndex; ++i) {

                if (arr[i-1] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                }

            }

            bubbleSort(arr, lastIndex-1);

        }

    }

}
