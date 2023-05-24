package gpt;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {

        int[] fibonacci = new int[100];

        fibonacci[0] = 1;
        fibonacci[1] = 2;

        for(int i=2; i<fibonacci.length; ++i) {

            fibonacci[i]= fibonacci[i-2] + fibonacci[i-1];

        }

        System.out.println(Arrays.toString(fibonacci));

    }

}
