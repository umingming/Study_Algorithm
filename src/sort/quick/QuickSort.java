package sort.quick;

/**
 *
 * 퀵 정렬
 * 퀵 정렬은 Pivot을 정해야 함.
 *
 * Pivot(기준값)을 잘 정해야한다.
 *
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        Quick(arr);


        for (int i : arr) {
            System.out.println(i);
        }

    }

    public static void Quick(int[] arr) {
        Quick(arr, arr.length/2);
    }

    public static void Quick(int[] arr, int pivotIndex) {
        if (pivotIndex < arr.length) {

            int preValue = 0;
            int postValue = 0;

            int preIndex = 0;
            int postIndex = 0;

            for (int i=0; i<=pivotIndex; ++i) {
                if (arr[i] >= arr[pivotIndex]) {
                    preValue = arr[i];
                    preIndex = i;
                }
                break;
            }

            for (int i=arr.length-1; i>pivotIndex; --i) {

                if (arr[i] < arr[pivotIndex]) {
                    postValue = arr[i];
                    postIndex = i;

                    arr[preIndex] = postValue;
                    arr[postIndex] = preValue;
                }
                break;

            }

            Quick(arr, pivotIndex+1);
        }
    }



}
