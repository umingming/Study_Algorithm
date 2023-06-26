package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 첫번쨰는 그냥 넣는다
 * 2. 두번째부터 넣을때마다 순서를 매긴다
 *  2.1. k보다 작거나 같을 때
 *      - 요소를 확인한 후 요소보다 크면 그 뒤에 놓는다
 *      - 그 뒤에 값이 있으면 그 값은 한 칸 뒤로 민다
 *  2.2. k보다 클 때
 *      - 마지막 값보다 큰지 확인하고 크면 첫번쨰 요소를 버리고 맨 마지막에 넣는다.
 */
public class TvShow {

    public static void main(String[] args) {
        Arrays.stream(solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})).forEach(System.out::println);
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[k];

        answer[0] = score[0];

        for(int i=1; i<score.length; ++i) {
            if(i <= k) {
                if (score[i] > answer[i-1]) {
                    answer[i] = score[i];
                } else {
                    int temp = answer[i-1];
                    answer[i-1] = score[i];
                    answer[i] = temp;
                }
            } else {
                if (answer[0] < score[i]) {

                    for(int j=1; j<k; ++j) {
                       answer[i-1] = answer[i];
                    }

                    answer[k-1] = score[i];

                }
            }
        }

        return answer;
    }

}
