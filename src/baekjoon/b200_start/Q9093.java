package baekjoon.b200_start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오. 단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있으며, 문장이 하나 주어진다. 단어의 길이는 최대 20, 문장의 길이는 최대 1000이다. 단어와 단어 사이에는 공백이 하나 있다.
 *
 * 1. 버퍼로 정수 값을 입력 받는다.
 * 2. 정수의 수만큼 for문을 돌아준다.
 * 3. 정수값을 split으로 잘라준다.
 * 4. split으로 잘라준 갯수만큼 for문을 돈다.
 * 5. 잘라준 temp의 각 배열의 방의 갯수만큼 반대로 돌면서 sb에 추가해준다.
 */

public class Q9093 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int count = Integer.parseInt(reader.readLine());

        for(int i=0; i<count; ++i) {

            String[] temp = reader.readLine().split(" ");

            for(int j=0; j<temp.length; ++j) {


                sb.append(new StringBuilder(temp[j]).reverse() + " ");

            }

            sb.append("\n");

        }

        System.out.println(sb);


    }

}
