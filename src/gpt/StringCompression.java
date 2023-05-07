package gpt;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 문제: 문자열 압축
 * 주어진 문자열을 압축하여 반환하는 함수를 작성하십시오.
 *
 * 예시:
 *
 * 입력: "aaabbcccc"
 *
 * 출력: "a3b2c4"
 *
 * 입력: "abcd"
 *
 * 출력: "abcd" (압축이 되지 않음)
 *
 * 입력: "aabbaa"
 *
 * 출력: "a2b2a2" (압축됨)
 *
 * 추가적으로, 아래와 같은 제약 조건을 고려해주세요.
 *
 * 압축된 문자열의 길이가 원래 문자열의 길이보다 크지 않도록 작성해야 합니다.
 * 대소문자를 구분하지 않습니다.
 *
 * A = 65
 * Z = 90
 *
 * [풀이]
 * 0. 0번째 인덱스 문자 + 0을 스텍에 넣는다
 * 1. 1부터 문자열의 갯수만큼 반복문을 돌아 스텍에 넣는다
 * 2. 스텍에 넣을때 값이 비었으면 문자+0 이라는 값으로 넣고, 아니면 판별한다. 판별 시 upperCase한다.
 *  2.1. 판별 시 이전 값과 같을 경우 뒤의 숫자 + 1을 한다
 *  2.2. 아닐 시 숫자 + 0을 한다
 * 3. 스텍의 값을 다른 스텍에 다시 넣는다
 * 4. 3번 스텍을 문자열로 치환한다.
 * 5. replaceAll을 하여 0은 모두 지워준다
 * */
public class StringCompression {

    public static void main(String[] args) {

        String word = "AABBCCDD";

        Stack<String> compressionStack = new Stack<>();
        compressionStack.push(word.charAt(0)+"0");

        for(int i=1; i<word.length(); ++i) {
            String lastChar = compressionStack.peek().substring(0, 1).toUpperCase();

            if(lastChar.equals(String.valueOf(word.charAt(i)))) {
                String temp = compressionStack.pop();
                temp = lastChar + Integer.parseInt(temp.substring(1, 2)) + 1;
                compressionStack.push(temp);
            } else {
                compressionStack.push(word.charAt(i) + "0");
            }
        }

        Stack<String> tempStack = new Stack<>();
        String result = null;
        while(!compressionStack.empty()) {
            tempStack.push(compressionStack.pop());
        }

        while(!tempStack.empty()) {
            result += tempStack.pop();
        }

        result.replaceAll("0", "");

        System.out.println(result);








    }

}
