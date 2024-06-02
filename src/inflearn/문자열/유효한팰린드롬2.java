package inflearn.문자열;

import java.util.Scanner;

/**
 * 설명
 *
 * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
 *
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 *
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 *
 * 알파벳 이외의 문자들의 무시합니다.
 *
 *
 * 입력
 * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
 *
 *
 * 출력
 * 첫 번째 줄에 팰린드롬인지의 결과를 YES 또는 NO로 출력합니다.
 *
 * found7, time: study; Yduts; emit, 7Dnuof
 *
 * [풀이]
 * 1. 포인터 2개 선언
 *  1.1. lt, rt
 * 2. 중간값으로 점점 이동
 */
public class 유효한팰린드롬2 {

    public static void main(String[] args) {
        유효한팰린드롬2 solution = new 유효한팰린드롬2();
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        System.out.println(solution.isPalindrome(word) ? "Yes" : "No");


    }

    public boolean isPalindrome(String word) {
        word = word.toLowerCase();

        int lt = 0, rt = word.length() - 1;

        while (lt < rt) {
            while (!Character.isAlphabetic(word.charAt(lt)) && lt <= word.length()/2) {
                lt++;
            }

            while (!Character.isAlphabetic(word.charAt(rt)) && rt >= word.length()/2) {
                rt--;
            }

            if (lt > rt) {
                break;
            }

            lt++;
            rt--;
        }
        return true;
    }


}
