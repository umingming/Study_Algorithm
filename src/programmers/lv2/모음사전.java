package programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
 *
 * 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
 *
 * [풀이]
 * 1. dfs를 돌면서 모든 경우의 수를 리스트에 넣어준다.
 * 2. 리스트에서 index를 조회한다.
 *
 */
public class 모음사전 {

    public static void main(String[] args) {
        모음사전 solution = new 모음사전();
        System.out.println(solution.solution("AAAAE"));
    }

    List<String> list = new ArrayList<>();
    public int solution(String word) {
        DFS("", 0);
        return list.indexOf(word);
    }
    void DFS(String str, int length) {
        if(length > 5) {
            return;
        }
        list.add(str);
        for(int i = 0; i < 5; i++) {
            DFS(str + "AEIOU".charAt(i), length + 1);
        }
    }

}
