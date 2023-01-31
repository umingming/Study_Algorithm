package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 영수증
 *
 * [문제]
 *
 * [입력]
 * 260000
 * 4
 * 20000 5
 * 30000 2
 * 10000 6
 * 5000 8
 *
 * [결과]
 * Yes
 *
 */
public class Q25304 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int totalPrice = Integer.parseInt(reader.readLine());

        int sum = 0;

        int repeat = Integer.parseInt(reader.readLine());

        for (int i=0; i<repeat; ++i) {
            String[] input = reader.readLine().split(" ");
            sum += Integer.parseInt(input[0]) * Integer.parseInt(input[1]);
        }

        if (totalPrice == sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

}
