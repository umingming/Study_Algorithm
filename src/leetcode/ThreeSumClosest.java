package leetcode;

import java.util.Arrays;

/**
 * [문제]
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
 *
 * [풀이]
 * 1. 소팅한다
 * 2. 투포인터로 처리한다.
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        ThreeSumClosest solution = new ThreeSumClosest();
        System.out.println(solution.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int bestNum = nums[0] + nums[1] + nums[2];

        for(int i=0; i<nums.length-2; ++i) {
            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                int currentNum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currentNum - target) < Math.abs(bestNum - target)) {
                    bestNum = currentNum;
                }

                if (currentNum > target) {
                    right--;
                } else if (currentNum < target) {
                    left++;
                } else {
                    return bestNum;
                }

            }
        }

        return bestNum;
    }

}
