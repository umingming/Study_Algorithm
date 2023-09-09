package inflearn.해시;

import java.util.*;

/**
 * 설명
 *
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
 * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
 *
 *
 * 입력
 * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
 * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
 *
 * 예시 입력 1
 *
 * bacaAacba
 * abc
 *
 * 예시 출력 1
 * 3
 *
 * 출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.
 *
 * 출력
 */
public class 모든아나그램찾기 {

    public int anagram(String s1, String s2) {

        int answer=0, lt=0;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        //map2에 값 넣
        for(char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        //map1에 값 넣기
        for(int i=0; i<map2.size(); ++i) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for(int rt=map1.size(); rt<s1.length(); ++rt) {
            if (map1.equals(map2)) answer++;

            map1.put(s1.charAt(rt), map1.getOrDefault(s1.charAt(rt), 0) + 1);

            if (map1.get(s1.charAt(lt)) == 1) map1.remove(s1.charAt(lt));
            else map1.put(s1.charAt(lt), map1.get(s1.charAt(lt)) -1);

            lt++;

        }

        if (map1.equals(map2)) answer++;


        return answer;
    }

    public static void main(String[] args) {

        모든아나그램찾기 solution = new 모든아나그램찾기();
        String s1 = "bacaAacba";
        String s2 = "abc";
        System.out.println(solution.anagram(s1, s2));

    }

}
