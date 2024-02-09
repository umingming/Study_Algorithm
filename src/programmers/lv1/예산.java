package programmers.lv1;

import java.util.Arrays;

/**
 * S사에서는 각 부서에 필요한 물품을 지원해 주기 위해 부서별로 물품을 구매하는데 필요한 금액을 조사했습니다.
 * 그러나, 전체 예산이 정해져 있기 때문에 모든 부서의 물품을 구매해 줄 수는 없습니다.
 * 그래서 최대한 많은 부서의 물품을 구매해 줄 수 있도록 하려고 합니다.
 *
 * 물품을 구매해 줄 때는 각 부서가 신청한 금액만큼을 모두 지원해 줘야 합니다.
 * 예를 들어 1,000원을 신청한 부서에는 정확히 1,000원을 지원해야 하며,
 * 1,000원보다 적은 금액을 지원해 줄 수는 없습니다.
 *
 * 부서별로 신청한 금액이 들어있는 배열 d와 예산 budget이 매개변수로 주어질 때,
 * 최대 몇 개의 부서에 물품을 지원할 수 있는지 return 하도록 solution 함수를 완성해주세요.
 *
 * d는 부서별로 신청한 금액이 들어있는 배열이며, 길이(전체 부서의 개수)는 1 이상 100 이하입니다.
 * d의 각 원소는 부서별로 신청한 금액을 나타내며, 부서별 신청 금액은 1 이상 100,000 이하의 자연수입니다.
 * budget은 예산을 나타내며, 1 이상 10,000,000 이하의 자연수입니다.
 *
 * d	        budget	result
 * [1,3,2,5,4]	9	    3
 * [2,2,3,3]	10	    4
 *
 * [풀이]
 * 1. 값의 비교가 있기 때문에 소팅한 다음 쌓아올리면 될 듯
 *
 * [실패한 풀이]
 * 1. 바꾸어 생각하면 문제의 핵심은 이거다 "수열의 합이 budget과 동일한 최대 수열의 길이를 구하시오"
 * 2. for문을 돌면서 들어가있는 케이스와 안들어가있는 케이스를 종합해서 최종적으로 최대 수가 몇인지를 구하면 될 것 같은데?
 *  2.1. 배열의 길이만큼 for문을 돈다.
 *  2.2. 이때 2개로 뻗어나간다. 해당 index가 false인 경우의 수와, ture인 경우의 수
 *  2.3. 인자로 포함된 부서의 갯수, 여태까지의 합
 *  2.4. 종료 기준 = budget을 초과했을 때
 *  2.5. answer값보다 부서 갯수가 큰지 확인
 */
public class 예산 {

    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int sum = 0;
        int answer = 0;
        for (int i : d) {
            sum += i;
            answer++;
            if (sum == budget) {
                return answer;
            } else if (sum > budget) {
                return answer-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        예산 solution = new 예산();
        System.out.println(solution.solution(new int[]{1,3,2,5,4}, 9));
    }

}
