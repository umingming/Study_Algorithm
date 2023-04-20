package gpt;

import java.util.Arrays;

public class SearchArray {

    public static void main(String[] args) {

        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        nums = removeDuplicates(nums);

//         for(int i=0; i<nums.length; ++i) {
//
//             for(int j=i+1; j<nums.length; ++j) {
//
//                 if(nums[i] == nums[j]) {
//                     shift(nums, j);
//                 }
//
//             }
//
//         }

        System.out.println(Arrays.toString(nums));


    }


    public static int[] removeDuplicates(int[] nums) {
        if (nums.length == 0) return nums;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        int[] result = new int[i + 1];
        for (int k = 0; k < result.length; k++) {
            result[k] = nums[k];
        }
        return result;
    }

//    public static void shift(int[] arr, int target) {
//
//        for(int i = target; i<arr.length-1; ++i) {
//
//            arr[i] = arr[i+1];
//
//        }
//
//        arr[arr.length-1] = 0;
//
//    }

}
