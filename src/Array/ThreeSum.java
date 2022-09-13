/*
    [문제]
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
    Notice that the solution set must not contain duplicate triplets.
*/

/*
    [풀이]
    1. nums의 갯수가 3미만일 경우 0을 리턴해준다.
*/

package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[] temp = {-1,0,1,2,-1,-4};

        List<List<Integer>> list = test(temp);

        System.out.println(list);
//        for (List<Integer> testByList : list) {
//            System.out.println(testByList);
//        }
    }

    public static List<List<Integer>> test(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> array = new ArrayList<>();

        int left, right, sum;

        for(int i=0; i<nums.length-1; ++i) {

            left = i+1;
            right = nums.length-1;
            while(left < right) {

                sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    array.add(list);
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(right < right && nums[right] == nums[right-1]) right--;

                    ++left;
                    --right;
                } else if(sum<0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return array;
    }
}
