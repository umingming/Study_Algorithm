package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소인수 분해
 *
 * [문제]
 * 정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
 *
 * [예제 1]
 * 72
 *
 * [결과 1]
 * 2
 * 2
 * 2
 * 3
 * 3
 *
 * [예제 2]
 * 9991
 *
 * [결과]
 * 97
 * 103
 *
 * [결과 2]
 */
public class Q11653 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        int number = 5;
        while(true) {
            if (input % 2 == 0) {
                System.out.println(2);
                input = input / 2;
            } else if (input % 3 == 0){
                System.out.println(3);
                input = input / 3;
            } else if (input == 1){
                return;
            } else {
                if (input%number == 0) {
                    System.out.println(number);
                    input = input / number;
                } else {
                    ++number;
                }
            }
        }




    }

}
