package programmers.lv1;

/**
 * 주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
 * 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때
 * 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 * 1. 무식하게 생각하면 이렇다
 * 2. 3중 for문을 돌면서 모든 수의 소수 값을 확인한다.
 */
public class 소수만들기 {

    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length-2; ++i) {
            for(int j=i+1; j<nums.length-1; ++j) {
                for(int z=j+1; z<nums.length; ++z) {
                    if (isPrime(nums[i] + nums[j] + nums[z])) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private boolean isPrime (int num) {
        for (int i=2; i<=(int)Math.sqrt(num); ++i) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        소수만들기 solution = new 소수만들기();
        System.out.println(solution.solution(new int[]{1,2, 3, 4}));
    }

}
