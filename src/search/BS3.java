package search;

public class BS3 {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 9};
        int target = 2;

        System.out.println(binarySearch(nums, target));

    }

    public static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length);
    }

    public static int binarySearch(int[] arr, int target, int start, int end) {
        if(arr.length==0||(end-start==1&&arr[start]!=target)) return -1;

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, 0,  mid-1);
        } else {
            return binarySearch(arr, target, mid, end);
        }
    }



}
