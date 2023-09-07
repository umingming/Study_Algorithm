package inflearn.해시;

import java.util.*;

/**
 * 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
 * 각 구간별로 구하라고 했습니다.
 *
 * 만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
 *
 * 20 12 20 10 23 17 10
 *
 * 각 연속 4일간의 구간의 매출종류는
 *
 * 첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
 * 두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
 * 세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
 * 네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
 *
 *       lt          rt
 * 20 12 20 10 23 17 10
 *
 * N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
 *
 * 매출액의 종류를 출력하는 프로그램을 작성하세요.
 */
public class 매출액의종류 {

    public List<Integer> solution(int[] arr, int n) {

        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        int lt=0, rt=n-2;

        for(int i=0; i<n-1; ++i) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        while(rt < arr.length-1) {
            rt++;
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);

            answer.add(map.size());

            if (map.get(arr[lt]) == 1) {
                map.remove(arr[lt]);
            } else {
                map.put(arr[lt], map.get(arr[lt])-1);
            }

            lt++;
        }



        return answer;
    }

    public static void main(String[] args) {
        매출액의종류 solution = new 매출액의종류();
        int[] arr = {20, 12, 20, 10, 23, 17, 10};
        for (int i : solution.solution(arr, 4)) {
            System.out.print(i + " ");
        }
    }

}
