package sort.bubble;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 1};
        bubbleSort(arr);
        printArr(arr);
    }

    public static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length);
    }

    public static void bubbleSort(int[]arr, int lastIndex) {
        if (lastIndex>0) {

            for (int i=1; i<lastIndex; ++i) {
                if (arr[i-1] > arr[i]) {
                    swap(arr, i-1, i);
                }
            }

            bubbleSort(arr, lastIndex);

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
