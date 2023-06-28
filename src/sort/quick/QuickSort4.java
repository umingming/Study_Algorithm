package sort.quick;

public class QuickSort4 {

    public static void main(String[] args) {

        quickSort(new int[]{1, 5, 7, 3, 2, 1, 5});
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0,  arr.length-1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);

        if(start < part2) {
            quickSort(arr, start, part2 -1);
        }

        if(end > part2) {
            quickSort(arr, part2-1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start+end) / 2];

        while(start >= end) {
            while(pivot > arr[start]) start++;
            while(pivot < arr[end]) end--;

            if (start >= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        return start;
    }

    public static void swap(int[] arr, int target, int source) {
        int temp = arr[target];
        arr[target] = arr[source];
        arr[source] = temp;
    }

}
