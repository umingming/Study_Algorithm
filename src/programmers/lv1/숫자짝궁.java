package programmers.lv1;

import java.util.*;

/**
 * 두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
 * (단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).
 * X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.
 *
 * 예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다.
 * 다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
 * 두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다.
 * X, Y는 0으로 시작하지 않습니다.
 * X, Y의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.
 *
 * 1. x의 각 수를 HashMap에 넣음
 * 2. y의 각 수를 HashMap에 넣음
 * 3. x의 Key를 돌면서 y를 돔 (시간복잡도 n^2가 될 듯)
 *  3.1. 돌아서 중복인 값이 나오면 List에 담음
 *  3.2. List를 소팅해준 후 Result에 쌓아줌.
 *  3.3. 만약 Result에 아무것도 없다면 Result는 -1
 *
 */
public class 숫자짝궁 {

    public static String solution(String x, String y) {

        StringBuilder result = new StringBuilder();
        List<Character> list = new ArrayList<>();

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : x.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }

        for(char c : y.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0)+1);
        }

        for (Character character : map1.keySet()) {
            if (map2.get(character) != null && map2.get(character) > 0) {
                int count = Math.min(map1.get(character), map2.get(character));

                for(int i=0; i<count; ++i) {
                    list.add(character);
                }

            }
        }

        Collections.sort(list, Collections.reverseOrder());

        if (list.size() == 0) {
            result.append("-1");
        } else {
            for(int i=0; i<list.size(); ++i) {
                result.append(list.get(i));
            }
        }

        String sResult = result.toString();

        if (sResult.matches("0+")) sResult = "0";

        return sResult;

    }

    public static void main(String[] args) {
        String x = "1002";
        String y = "30005";

        System.out.println(solution(x, y));
    }

}
