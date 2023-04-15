package baekjoon.b300_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 소수 구하기
 *
 * 문제
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 *
 * 출력
 * 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 */
public class Q1929 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        int[] arr = new int[2];
        String[] sArr = reader.readLine().split(" ");

        for(int i=0; i<2; ++i) {
            arr[i] = Integer.parseInt(sArr[i]);
        }

        int n = arr[0];
        int m = arr[1];

        for(int i=n; i<=m; ++i) {

            if (check(i)) {
                list.add(i);
            }

        }

        for (int num : list) {
            System.out.println(num);
        }



    }

    public static boolean check(int n) {

        boolean isFlag = false;

        for (int i=2; i<n; ++i) {

            if (n % i == 0) {
                isFlag = false;
                break;
            } else {
                isFlag = true;
            }

        }

        return isFlag;

    }

}
