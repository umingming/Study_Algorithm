package leetcode.foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 문제 설명:
 *
 * 정수 n개로 이루어진 배열 nums가 주어질 때, 다음 조건을 만족하는 모든 고유한 4-원소 조합(quadruplets) [nums[a], nums[b], nums[c], nums[d]]의 배열을 반환하라:
 *
 * 인덱스 a, b, c, d는 모두 0 이상 n 미만이어야 합니다.
 * a, b, c, d는 서로 다른 값이어야 합니다.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 반환하는 조합의 순서는 상관없습니다.
 * 예제 1:
 *
 * 입력: nums = [1, 0, -1, 0, -2, 2], target = 0
 * 출력: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
 * 예제 2:
 *
 * 입력: nums = [2, 2, 2, 2, 2], target = 8
 * 출력: [[2, 2, 2, 2]]
 * 제한 사항:
 *
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum solution = new FourSum();
        List<List<Integer>> result = solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            // i 중복 제거: 이전 값과 같으면 건너뛰기
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // j 중복 제거
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // left와 right의 중복 값 건너뛰기
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }


}
