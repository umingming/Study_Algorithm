package baekjoon.b300_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팩토리얼 0의 개수
 * N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.
 *
 * 첫째 줄에 구한 0의 개수를 출력한다.
 *
 * 10
 * 2
 *
 * 3
 * 0
 *
 * N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올때까지
*/
public class Q1676 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(reader.readLine());
        int count = 0;

        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }
        System.out.println(count);
    }

}
