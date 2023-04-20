package search;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 15, 16, 19, 22, 23, 24, 26, 29, 30, 31, 33, 40};

        System.out.println(nums.length);
        binarySearch(nums, 33);

    }

    public static void binarySearch(int[] nums, int findNumber) {
        binarySearch(nums, findNumber, 0, nums.length-1);
    }

    public static void binarySearch(int[] nums, int findNumber, int start, int end) {

        if(nums.length == 0) return;

        int pivot = nums[(start+end)/2];

        if (pivot == findNumber) {
            System.out.println(findNumber + "는 " + (start+end)/2 + "번째 인덱스입니다..");
        } else if (pivot > findNumber) {
            binarySearch(nums, findNumber, start, ((start+end)/2)-1);
        } else {
            binarySearch(nums, findNumber, (start+end)/2, end);
        }

    }

}
