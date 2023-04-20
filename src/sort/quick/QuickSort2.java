package sort.quick;

public class QuickSort2 {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);

        if (start < part2 - 1) {
            quickSort(arr, start, part2-1);
        }

        if (part2 < end) {
            quickSort(arr, part2, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {

        int pivot = arr[(start) + end / 2];

        while(start <= end) {
            start++;
        }

        return start;
    }

}
