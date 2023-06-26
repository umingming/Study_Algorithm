package programmers;

import java.util.Arrays;

/**
 문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
 예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.

 b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
 a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
 n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
 a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
 n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
 a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.


 toCharArray를 활용해서 풀어보자
 1. String을 charArray로 모두 변환 통칭 charArr
 2. charArr를 시작부터 끝까지 for문 순회
 2.1. 두번쨰 루프에서는 해당 지점부터 0번 루프까지를 돌면서 같은 글자가 있는지 확인
 2.1.1. 같은 글자가 있다면 해당 글자의 index에 answer에 넣는다
 2.1.2. 같은 글자가 없다면 계속 돌고, 만약 인덱스가 0이고 같은 글자가 없다면 해당 글자의 index에 -1을

 */

public class SameString {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana")));
    }



    public static int[] solution(String s) {

        int[] answer = new int[s.length()];
        char[] charArr = s.toCharArray();

        answer[0] = -1;

        for(int i=1; i<charArr.length; ++i) {

            for(int j=i-1; j>=0; --j) {

                if(charArr[i] == charArr[j]) {
                    answer[i]= i-j;
                    break;
                } else if(j==0 && charArr[i] != charArr[j]) {
                    answer[i] = -1;
                }

            }

        }

        return answer;
    }

    /**
     * 다른 사람의 풀이에 이런게 있다
     *         return IntStream.range(0, s.length()).map(i -> s.substring(0, i).lastIndexOf(s.charAt(i)) > -1 ? i - s.substring(0, i).lastIndexOf(s.charAt(i)) : -1).toArray();
     */

}
