package programmers.lv1;

import java.util.Arrays;

public class 평균구하기 {

    public static double solution(int[] arr) {
        return Arrays.stream(arr).average().orElse(0);
    }

    public static void main(String[] args) {

    }

}
