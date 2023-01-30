package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 단어 공부
 *
 * [문제]
 * 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
 *
 *
 * [예제 1]
 * Mississipi
 *
 * [결과 1]
 * ?
 *
 * [예제 2]
 * ZzA
 *
 * [결과 2]
 * z
 *
 * [풀이]
 * ㄱ. upper로 올려준다
 *  > 65~90
 * ㄴ. Map에 담아준다.
 * ㄷ. 소팅 해준다.
 * ㄹ. 제일 높은게 2개면 ? 아니면 그 값 뽑아주기
 *
 */
public class Q1157 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> resultMap = new HashMap<>();
        String input = reader.readLine().toUpperCase();

        for(int i=0; i<input.length(); ++i) {
            resultMap.put(input.charAt(i), 0);
        }

        for(int i=0; i<input.length(); ++i) {

            int value = resultMap.get(input.charAt(i));
            resultMap.put(input.charAt(i), value+1);

        }

        for (Character character : resultMap.keySet()) {
            System.out.println("Key: " + character);
            System.out.println("Value: " + resultMap.get(character));
        }

        ArrayList<Integer> list = new ArrayList<>(resultMap.values());
        Collections.sort(list);


        if (list.get(list.size()-1) == list.get(list.size()-2)) {
            System.out.println("?");
        } else {
            for (Character character : resultMap.keySet()) {
                if (resultMap.get(character) == list.size()-1) {
                    System.out.println(character);
                }
            }
        }



    }



}
