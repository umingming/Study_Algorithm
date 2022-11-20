package leetcode.array;

public class RemoveDuplicatesfromSortedArray {


    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0, 1, 2, 3, 4, 5};

        int index = 1;

        for (int i=0; i<nums.length-1; ++i) {

            if (nums[i] != nums[i+1]) {
                nums[index] = nums[i+1];
                index++;
            }

            //0 0 1 2 3
        }

        System.out.println(index);
    }

    public static int removeDuplicates(int[] nums) {

        return 0;
    }
}
