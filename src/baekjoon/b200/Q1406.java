package baekjoon.b200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제]
 * 한 줄로 된 간단한 에디터를 구현하려고 한다. 이 편집기는 영어 소문자만을 기록할 수 있는 편집기로, 최대 600,000글자까지 입력할 수 있다.
 * 이 편집기에는 '커서'라는 것이 있는데, 커서는 문장의 맨 앞(첫 번째 문자의 왼쪽), 문장의 맨 뒤(마지막 문자의 오른쪽), 또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다.
 * 즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면, 커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.
 * 이 편집기가 지원하는 명령어는 다음과 같다.
 *
 * [풀이]
 * 1. 버퍼 선언
 * 2. 문자 변수 temp를 버퍼로 입력 받는다.
 * 3. 숫자 변수 count 버퍼로 입력 받는다.
 * 4. 숫자 변수 index를 선언한다. 최초값은 temp.length이다.
 * 4. 숫자만큼 for문을 돌아준다.
 *  > 값을 입력 받는다
 *      > L일 시
 *          > index = 1이 아니면 index = index-1
*       > D 일 시
 *          > index = temp.length가 아니면 index = index + 1;
*       > temp.startWith가 P일 시
 *          > temp = temp.substring(0, index-1) + P + temp.substring(index-1);
 */
public class Q1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String temp = reader.readLine();
        int count = Integer.parseInt(reader.readLine());
        int index = temp.length();
        String input;
        String[] isSplitInput = new String[1];

        for (int i=0; i<count; ++i) {
            input = reader.readLine();

            if (input.equals("L")) {
                if (index != 1) {
                    index = index-1;
                }
            } else if (input.equals("D")) {
                if (index != temp.length()) {
                    index = index+1;
                }

            } else if (input.startsWith("P")) {
                isSplitInput = input.split(" ");
                temp = temp.substring(0, index-1) + isSplitInput[1] + temp.substring(index-1);
            }

        }

        System.out.print(temp);


    }

}
