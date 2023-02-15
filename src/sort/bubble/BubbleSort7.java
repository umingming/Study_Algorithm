package sort.bubble;

public class BubbleSort7 {

    public static void main(String[] args) {
        int[] arr = {1, 34, 34,5345,34,421,4,2141,24,6,4567,567,456};

        bubbleSort(arr);

        for (int i : arr) {

            System.out.print(i);

        }


    }

    public static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length-1);
    }

    public static void bubbleSort(int[] arr, int lastIndex) {

        if (lastIndex > 1) {

            for (int i=1; i<=lastIndex; ++i) {

                if (arr[i-1] > arr[i]) {

                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;

                }

                bubbleSort(arr, lastIndex-1);

            }

        }

    }

}
