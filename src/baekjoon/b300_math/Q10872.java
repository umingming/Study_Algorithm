package baekjoon.b300_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10872 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());

        if (input != 0) {
            System.out.println(factorial(input, 1));
        } else {
            System.out.println(1);
        }
    }

    public static int factorial(int input, int result) {

        while (input!=0) {
            result = result * input;
            input--;
        }

        return result;

    }

}
