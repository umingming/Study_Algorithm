package baekjoon.b203_math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 알파벳 갯수
 *
 * [문제]
 * 알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
 *
 * [입력 1]
 * baekjoon
 *
 * [결과 1]
 * 1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0
 *
 * [풀이]
 *
 */
public class Q10808 {

    public static void main(String[] args) throws IOException {

        Map<Integer, Integer> resultMap = new HashMap<>();

        for(int i=97; i<123; ++i) {
            resultMap.put(i, 0);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        for(int i=0; i<input.length(); ++i) {

            int checkNumber = resultMap.get((int)input.charAt(i));
            resultMap.put((int)input.charAt(i), checkNumber+1);

        }

        for(int i=97; i<123; ++i) {
            System.out.print(resultMap.get(i) + " ");
        }



    }


}
