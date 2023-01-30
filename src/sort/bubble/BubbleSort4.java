package sort.bubble;

public class BubbleSort4 {

    public static void main(String[] args) {
        int[] arr = {1, 5, 322, 214,124,12,412,312,4,15,12,41,24,124,124,21,412,5,4567,567,567,34,534,5,345,345,34,66,23,51,1,2,3,4,45,56,6,7,87,8,9,1};

        bubble(arr);
        printArr(arr);
    }

    public static void bubble(int[] arr) {
        bubble(arr, arr.length);
    }

    public static void bubble(int[] arr, int lastIndex) {

        if (lastIndex > 0) {

            for(int i=1; i<lastIndex; ++i) {

                if (arr[i-1] > arr[i]) {

                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;

                }

            }

            bubble(arr, lastIndex-1);
        }

    }

    public static void printArr(int[] arr) {

        for (int i : arr) {

            System.out.println(i);

        }

    }
}
