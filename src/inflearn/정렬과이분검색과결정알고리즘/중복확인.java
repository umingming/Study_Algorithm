package inflearn.정렬과이분검색과결정알고리즘;

import java.util.Arrays;

/**
 * 현수네 반에는 N명의 학생들이 있습니다.
 *
 * 선생님은 반 학생들에게 1부터 10,000,000까지의 자연수 중에서 각자가 좋아하는 숫자 하나 적어 내라고 했습니다.
 *
 * 만약 N명의 학생들이 적어낸 숫자 중 중복된 숫자가 존재하면 D(duplication)를 출력하고,
 *
 * N명이 모두 각자 다른 숫자를 적어냈다면 U(unique)를 출력하는 프로그램을 작성하세요.
 */
public class 중복확인 {

    public static String solution(int[] arr) {

        String result = "U";
        Arrays.sort(arr);

        for(int i=0; i<arr.length-1; ++i) {
            if (arr[i] == arr[i+1]) return "D";
        }

        return result;

    }

    public static void main(String[] args) {
        int[] arr = {20, 25, 52, 30, 39, 33, 43, 33};
        System.out.println(solution(arr));
    }

}
