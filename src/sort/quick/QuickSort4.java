package sort.quick;

/**
 * 파티션을 이용해서 임의의 pivot값을 상정하여 그 값으로 정렬을 수행한 후
 * 이 과정을 재귀적으로 호출하는 것을 뜻합니다.
 */
public class QuickSort4 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,23,21,12,3,5,34,56,3,4512,4,12,412,412,4,125,346457,6,45,7,4,2,1,77,5,4,3,3,1,2,3456456,34,52,34,1234,44};
        quickSort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }


    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int start, int end) {

        int part2 = partition(arr, start, end);

        if (start < part2 - 1) {
           quickSort(arr, start, part2-1);
        }

        if(end > part2) {
            quickSort(arr, part2, end);
        }

    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start+end)/2];

        while(start <= end) {
            while(arr[start]<pivot) start++;
            while(arr[end]>pivot) end--;

            if (start <= end) {
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
