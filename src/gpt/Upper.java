package gpt;

import java.util.Locale;

/**
 * 문제: 주어진 문자열에서 모든 단어의 첫 글자를 대문자로 변환하는 함수를 작성하세요.
 *
 * 예시:
 * Input: "hello world"
 * Output: "Hello World"
 *
 * Input: "apple orange banana"
 * Output: "Apple Orange Banana"
 *
 * Input: "a b c"
 * Output: "A B C"
 */
public class Upper {

    public static void main(String[] args) {
        String input = "apple orange banana";
        String[] words = input.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.substring(0, 1).toUpperCase(Locale.ROOT));
            sb.append(word.substring(1)).append(" ");
        }
        sb.setLength(sb.length() - 1); // 마지막 공백 제거

        System.out.println(sb.toString());
    }

}
