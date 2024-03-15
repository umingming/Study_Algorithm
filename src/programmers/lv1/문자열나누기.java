package programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 문자열나누기 {

    public int solution(String s) {
        int startIndex = 0;
        int xCount = 0;
        int anotherCount = 0;
        List<String> result = new ArrayList<>();

        for(int i=0; i<s.length(); ++i) {
            if (s.charAt(startIndex) != s.charAt(i)) {
                anotherCount++;
            } else {
                xCount++;
            }

            if (xCount == anotherCount) {
                result.add(getChuck(s, startIndex, i));
                startIndex = i+1;
                xCount = 0;
                anotherCount = 0;
            }

            if (xCount != anotherCount && i == s.length()-1) {
                result.add(s.substring(startIndex));
            }
        }

        for (String string : result) {
            System.out.println(string);
        }

        return result.size();
    }

    public String getChuck(String input, int startIndex, int lastIndex) {
        return lastIndex+1 < input.length() ? input.substring(startIndex, lastIndex+1)
                                            : input.substring(startIndex);
    }

    public static void main(String[] args) {
        문자열나누기 solution = new 문자열나누기();
        solution.solution("aaabbaccccabba");
    }
}
