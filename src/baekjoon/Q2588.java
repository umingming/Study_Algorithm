package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2588 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int firstNumber = Integer.parseInt(reader.readLine());
        int secondNumber = Integer.parseInt(reader.readLine());

        System.out.println(firstNumber * (secondNumber % 10));
        System.out.println(firstNumber * ((secondNumber % 100) / 10 ));
        System.out.println(firstNumber * (secondNumber / 100));
        System.out.println(firstNumber * secondNumber);

    }

}
