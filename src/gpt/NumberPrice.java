package gpt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자 하나를 입력 받아 해당 숫자까지의 모든 자연수의 합을 구하는 프로그램을 작성해보세요.
 */
public class NumberPrice {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int inputPrice = Integer.parseInt(reader.readLine());
        int allPrice = 0;

        for(int i=1; i<inputPrice+1; ++i) {
            allPrice += i;

        }

        System.out.println(allPrice);


    }

}
