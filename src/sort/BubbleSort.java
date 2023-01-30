package sort;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 6};
        bubbleSort(arr);
        printArr(arr);
    }

    public static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length-1);
    }

    public static void bubbleSort(int[]arr, int lastIndex) {
        if (lastIndex>0) {

            for (int i=1; i<lastIndex; ++i) {
                if (arr[i-1] > arr[i]) {
                    swap(arr, i-1, i);
                }
            }

            bubbleSort(arr, lastIndex-1);

        }
    }

    public static void swap(int[]arr, int source, int target) {
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }

    public static void printArr(int[] arr) {

        for (int i : arr) {
            System.out.println(i);
        }
    }

}
