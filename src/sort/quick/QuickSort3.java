package sort.quick;

public class QuickSort3 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 1, 5, 2, 3, 1, 66, 2, 3};
        quickSort(arr);
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int start, int end) {

        int part2 = partition(arr, start, end);
        if (start < part2 - 1) {
            quickSort(arr, start, part2 - 1);
        }

        if (part2 < end) {
            quickSort(arr, part2, end);
        }

    }

    public static int partition(int[] arr, int start, int end) {

        int pivot = arr[(start + end) / 2];

        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }

            while (arr[end] < pivot) {
                end--;
            }

            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void swap(int[] arr, int source, int target) {
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }

}
