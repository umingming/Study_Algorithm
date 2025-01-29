package leetcode.threesumclosest;

import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 *
 *
 * Constraints:
 *
 * 3 <= nums.length <= 500
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class ThreeSumClosest2 {

    public static void main(String[] args) {
        ThreeSumClosest2 solution = new ThreeSumClosest2();
        System.out.println(solution.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];

        for(int i=0; i<nums.length-2; ++i) {
            int left = i+1;
            int right = right = nums.length-1;

            while(left < right) {

                int closestDiff = getDiffNum(closestNum, target);

                int currentNum = nums[i] + nums[left] + nums[right];
                int currentDiff = getDiffNum(currentNum, target);

                if (isClose(closestDiff, currentDiff)) {
                    closestNum = currentNum;
                }

                if (currentNum > target) {
                    left++;
                } else if (currentNum < target) {
                    right--;
                } else {
                    return closestNum;
                }
            }
        }

        return closestNum;
    }

    private int getDiffNum(int source, int target) {
        return Math.abs(source - target);
    }

    private boolean isClose(int prev, int current) {
        return prev > current;
    }

}
