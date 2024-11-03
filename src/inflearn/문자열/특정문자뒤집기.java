package inflearn.문자열;

import java.util.Scanner;

/**
 * 5. 특정 문자 뒤집기
 * 설명
 *
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 *
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 *
 *
 * 출력
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * a#b!GE*T@S
 * 예시 출력 1
 *
 * S#T!EG*b@a
 */
public class 특정문자뒤집기 {

    public String solution (String str) {

        char[] arr = str.toCharArray();

        int lf = 0, rf = arr.length-1;

        while(lf<rf) {

            if (!Character.isAlphabetic(arr[lf])) lf++;
            else if (Character.isAlphabetic(arr[rf])) rf--;
            else {
                char temp = arr[lf];
                arr[lf] = arr[rf];
                arr[rf] = temp;

                lf++;
                rf--;
            }
        }

        return String.valueOf(arr);

    }



    public static void main (String[] args) {
        특정문자뒤집기 T = new 특정문자뒤집기();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }

}
