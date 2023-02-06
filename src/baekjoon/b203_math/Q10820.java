package baekjoon.b203_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 문자열 분석
 * 문자열 N개가 주어진다. 이때, 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램을 작성하시오.
 *
 * 각 문자열은 알파벳 소문자, 대문자, 숫자, 공백으로만 이루어져 있다.
 * [문제]
 *
 * [출력]
 * 첫째 줄부터 N번째 줄까지 각각의 문자열에 대해서 소문자, 대문자, 숫자, 공백의 개수를 공백으로 구분해 출력한다.
 *
 * [입력 1]
 * This is String
 * SPACE    1    SPACE
 *  S a M p L e I n P u T
 * 0L1A2S3T4L5I6N7E8
 *
 * [결과 1]
 * 10 2 0 2
 * 0 10 1 8
 * 5 6 0 16
 * 0 8 9 0
 *
 * [풀이]
 * 한글자씩 끊어줘서 아스키 코드값을 판별한다.
 */
public class Q10820 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        int[] resultArr = new int[4];

        while ((input = reader.readLine()) != null) {

            for (int i = 0; i < input.length(); ++i) {
                int charNumber = (int) input.charAt(i);
                if (charNumber >= (int) 'a' && charNumber <= (int) 'z') {
                    resultArr[0]++;
                } else if (charNumber >= (int) 'A' && charNumber <= (int) 'Z') {
                    resultArr[1]++;
                } else if (charNumber >= (int) '0' && charNumber <= (int) '9') {
                    resultArr[2]++;
                } else if (charNumber == ' ') {
                    resultArr[3]++;
                }
            }

            System.out.println(resultArr[0] + " " + resultArr[1] + " " + resultArr[2] + " " + resultArr[3]);

        }


    }
}
