package inflearn.해시;

import java.util.Set;
import java.util.TreeSet;

/**
 * 현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있습니다. 같은 숫자의 카드가 여러장 있을 수 있습니다.
 *
 * 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
 *
 * 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 자연수 N(3<=N<=100)과 K(1<=K<=50) 입력되고, 그 다음 줄에 N개의 카드값이 입력된다.
 *
 *
 * 출력
 * 첫 줄에 K번째 수를 출력합니다. K번째 수가 존재하지 않으면 -1를 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 10 3
 * 13 15 34 23 45 65 33 11 26 42
 *
 * 1 2 3 4 5
 * 예시 출력 1
 * 143
 */
public class K번째큰수 {

    public int solution(int[] arr) {
        int answer = 0;

        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0; i<arr.length-2; ++i) {
            for(int j=i+1; j<arr.length-1; ++j) {
                for(int z=j+1; z<arr.length; ++z) {
                    set.add(arr[i]+arr[j]+arr[z]);
                }
            }
        }

        int count = 3;

        for(int i=0; i<count-1; ++i) {
            set.pollLast();
        }

        answer = set.pollLast();

        return answer;

    }

    public static void main(String[] args) {

        K번째큰수 solution = new K번째큰수();
        int[] arr = {13, 15, 34, 23, 45, 65, 33, 11, 26, 42};

        System.out.println(solution.solution(arr));

    }

}
