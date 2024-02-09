package programmers.lv1;

import java.util.Arrays;

/**
 * 함수 solution은 정수 n을 매개변수로 입력받습니다.
 * n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
 * 예를들어 n이 118372면 873211을 리턴하면 됩니다.
 *
 * 제한 조건
 * n은 1이상 8000000000 이하인 자연수입니다.
 */
public class 정수내림차순으로배치하기 {

    public long solution(long n) {
        String s = n + "";
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(c);
        }

        sb.reverse();

        return Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        정수내림차순으로배치하기 soltuion = new 정수내림차순으로배치하기();
        System.out.println(soltuion.solution(118372));
    }
}
