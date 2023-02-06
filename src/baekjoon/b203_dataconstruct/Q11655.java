package baekjoon.b203_dataconstruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * ROT13
 *
 * [문제]
 * ROT13은 카이사르 암호의 일종으로 영어 알파벳을 13글자씩 밀어서 만든다.
 *
 * 예를 들어, "Baekjoon Online Judge"를 ROT13으로 암호화하면 "Onrxwbba Bayvar Whqtr"가 된다. ROT13으로 암호화한 내용을 원래 내용으로 바꾸려면 암호화한 문자열을 다시 ROT13하면 된다. 앞에서 암호화한 문자열 "Onrxwbba Bayvar Whqtr"에 다시 ROT13을 적용하면 "Baekjoon Online Judge"가 된다.
 *
 * ROT13은 알파벳 대문자와 소문자에만 적용할 수 있다. 알파벳이 아닌 글자는 원래 글자 그대로 남아 있어야 한다. 예를 들어, "One is 1"을 ROT13으로 암호화하면 "Bar vf 1"이 된다.
 *
 * 문자열이 주어졌을 때, "ROT13"으로 암호화한 다음 출력하는 프로그램을 작성하시오.
 *
 * [입력 1]
 * Baekjoon Online Judge
 *
 * [결과 1]
 * Onrxwbba Bayvar Whqtr
 *
 * [입력 2]
 * One is 1
 *
 * [결과 2]
 * Bar vf 1
 *
 * [풀이]
 * ㄱ. 아스키 코드값이 범위 내에 있을시 +13
 * ㄴ. 없으면 -13
 */
public class Q11655 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String input = reader.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<input.length(); ++i) {

            char c = input.charAt(i);

            if(c >= 'a' && c <= 'z') {

                if ((c+13) <= 'z') {
                    sb.append((char)(c+13));
                } else {
                    sb.append((char)(c-13));
                }

            } else if (c >= 'A' && c <= 'Z') {

                if ((c+13) <= 'Z') {
                    sb.append((char)(c+13));
                } else {
                    sb.append((char)(c-13));
                }

            } else if (c >= '0' && c <= '9') {

                sb.append(c);

            } else if (c == ' ') {
                sb.append(c);
            }


        }

        System.out.println(sb.toString());


    }



}
