package array;

/*

    Given a sorted array of distinct integers and a target value, return the index if the target is found.
    If not, return the index where it would be if it were inserted in order.

    You must write an algorithm with O(log n) runtime complexity.

    Input: nums = [1,3,5,6], target = 5
    Output: 2

*/

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6, 8, 10};
        int target = 5;

        int i = searchInsert(nums, target);
        System.out.println(i);

    }

    public static int searchInsert(int[] nums, int target) {

        for(int i=0; i<nums.length-1; ++i) {
            if (nums[i]==target) {
                return i;
            }
        }

        return nums.length;
    }

}
