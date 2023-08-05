package inflearn;

import java.util.Scanner;

//연습장
public class 중복문자뒤집기 {

    public String solution (String str) {

        String answer = "";

        for(int i=0; i<str.length(); ++i) {
            if (i == str.indexOf(str.charAt(i))) answer += str.charAt(i);
        }

        return answer;

    }



    public static void main (String[] args) {
        중복문자뒤집기 T = new 중복문자뒤집기();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }

}
