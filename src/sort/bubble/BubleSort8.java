package sort.bubble;

import java.util.Arrays;

public class BubleSort8 {

    public static void main(String[] args) {

        int[] tempArr = {1, 4, 3, 3, 1, 2, 45, 7, 5, 32, 1, 8, 55};
        System.out.println(Arrays.toString(tempArr));

        bubbleSort(tempArr);

        System.out.println(Arrays.toString(tempArr));

    }

    public static void bubbleSort(int[] arr) {
        bubbleSort(arr, 0, arr.length-1);
    }

    public static void bubbleSort(int[] arr, int index, int end) {

        while(index<end) {

            for(int i=index+1; i<=end; ++i) {
                if(arr[index] > arr[i]) {
                    swap(arr, index, i);
                }
            }

            ++index;

        }

    }

    public static void swap(int[] arr, int source, int target) {

        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;

    }

}
