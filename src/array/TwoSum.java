package array;

/*
    [문제: TwoSum]
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
*/

/*
    [설계]
    1. 예시 int 배열을 1개 생성한다
    2. scanner를 선언환다.
    3. input값을 받는다
    4. 2중 for문을 돌면서 배열 내 2가지 정수의 값이 3번의 input값과 동일한지 판별한다.
*/
public class TwoSum {

    public int[] twoSum(int[] temp, int target) {

        int answer[] = new int[2];
        for(int i=0; i<temp.length; ++i) {
            for (int j=0; j<temp.length; ++j) {
                if(temp[i] + temp[j] == target && i!=j) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        return answer;
    }


}
