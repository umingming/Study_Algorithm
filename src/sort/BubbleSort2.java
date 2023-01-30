package sort;

public class BubbleSort2 {

    public static void main(String[] args) {

        int[] arr = {4, 1, 2, 4, 6, 7, 8};

        bubbleSort(arr);

    }

    public static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length-1);
    }

    public static void bubbleSort(int[]arr, int lastIndex) {

        if (lastIndex > 0) {
            for (int i=1; i<lastIndex; ++i) {
                if (arr[i-1] > arr[i]) {
                    swap(arr, i-1, i);
                }
            }
            bubbleSort(arr, lastIndex-1);
        }
    }

    public static void swap(int[] arr, int before, int after) {

        int temp = arr[after];
        arr[after] = arr[before];
        arr[before] = temp;

    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }


}
