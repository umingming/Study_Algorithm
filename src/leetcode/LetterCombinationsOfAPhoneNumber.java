package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber solution = new LetterCombinationsOfAPhoneNumber();
        solution.letterCombinations("23");
    }

    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> map = new HashMap<>();
        List<List<Character>> mapToList = new ArrayList<>();
        init(digits, map, mapToList);

        List<String> resultList = new ArrayList<>();
        getResultList(0, mapToList, resultList, "");

        if (resultList.get(resultList.size()-1).equals("")) {
            resultList.remove(resultList.size()-1);
        }

        for (String s : resultList) {
            System.out.println(s);
        }
        return resultList;
    }

    private void init(String digits, Map<Integer, List<Character>> map, List<List<Character>> mapToList) {
        initMap(map);
        initMapToList(map, mapToList, digits);
    }

    private void initMap(Map<Integer, List<Character>> map) {
        map.put(2, new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        map.put(3, new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        map.put(4, new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        map.put(5, new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        map.put(6, new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        map.put(7, new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        map.put(8, new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        map.put(9, new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
    }

    private void initMapToList(Map<Integer, List<Character>> map, List<List<Character>> mapToList, String digits) {
        for(char c : digits.toCharArray()) {
            int digitToNum = Integer.parseInt(String.valueOf(c));
            mapToList.add(map.get(digitToNum));
        }
    }

    private void getResultList(int depth, List<List<Character>> mapToList, List<String> resultList, String word) {
        // 'abc' 'def'
        // 일단 이것만 생각해보면
        // 어떤 작은 문제로 쪼갤 수 있을까?
        //

        if(depth == mapToList.size()) {
            resultList.add(word);
            return;
        } else {
            // a, b, c
            // d, e, f

            //가 있다고 하자.
            // ad, ae, af, bd ~~ cf까지 찍어주는 방안은
            // 우선 첫번째 행을 다 돌아줘야 한다.
            // 그럼 for문을 돌아서 처리하면 되느냐?
            // 현재는 2차원 배열에 1차원 배열이 두 개 밖에 없어서 그렇게 처리할 수 있으나 배열이 3개 이상이 되는 순간 그렇게 처리하면 안된다.
            // 즉 재귀적으로 뭔가 깔쌈하게 처리해야 한다는 뜻?
            // 어떻게 짜지? 1차원 배열의 값은 뎁스로 핸들링하고 요소 선택은 인덱스라는 별도 값을 둬야하나?
            // 아 배열 갯수 차원은 for문이 처리해주고 나머지는 index가 처리해주겠다.

            for(char c : mapToList.get(depth)) {
                getResultList(depth + 1, mapToList, resultList, word + c);
            }

            // step 2
            // 어떻게 고도화 할것인가?
        }
    }

}
