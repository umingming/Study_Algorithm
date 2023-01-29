package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 블랙잭
 *
 * [문제]
 *
 * 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다.
 * 각 카드에는 양의 정수가 쓰여 있다. 그 다음 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
 * 이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
 * N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
 *
 * [예제 1]
 * 5 21
 * 5 6 7 8 9
 *
 * [결과 1]
 * 21
 *
 * [예제 2]
 * 10 500
 * 93 181 245 214 315 36 185 138 216 295

 * [결과 2]
 * 497
 *
 * [풀이]
 * ㄱ. 1,2,3 -> 1,2,4 -> 1,2,5 반복문 쭉 반복
 * ㄴ. 1,3,4 -> 1,3,5 -> 1,3,6 반복문 쭉 반복
 * 싸이클 다 돌고
 * ㄷ. 2,3,4 -> 2,3,5 싸이클을 쭉 돈다
 *  > for문에 abc를 두고
 *      > if문으로 a>b>c 관계 확실히 해둘것
 */
public class Q2798 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int repeat = Integer.parseInt(input[0]);
        int targetValue = Integer.parseInt(input[1]);

        int[] cardType = new int[repeat-1];

        String[] inputCardType = reader.readLine().split(" ");

        for(int i=0; i<cardType.length; ++i) {
            cardType[i] = Integer.parseInt(inputCardType[i]);
        }

        int result = 0;

        for (int a=0; a<cardType.length-2; ++a) {
            for (int b=a+1; b<cardType.length-1; ++b) {
                for (int c=b+1; c<cardType.length; ++c) {

                    int addValue = cardType[a] + cardType[b] + cardType[c];

                    if (addValue <= targetValue && addValue > result) {
                        result = addValue;
                    }

                }

            }
        }

        System.out.println(result);


    }

}
