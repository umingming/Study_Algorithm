package sort.bubble;

public class BubbleSort6 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 3, 7867,56,645456,45653,345,2324,21,1,24,12,5156,34,634,645,6456,345,23,52,7,7,245,642,56,4256,245,624562456,4256,};
        bubbleSort(arr);

        for (int i : arr) {

            System.out.println(i);
        }
    }

    public static void bubbleSort(int[] arr) {

        bubbleSort(arr, arr.length-1);

    }

    public static void bubbleSort (int[] arr, int lastIndex) {

        if(lastIndex>0) {

            for(int i=1; i<=lastIndex; ++i) {

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
