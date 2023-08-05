package inflearn;

import java.util.Scanner;

//연습장
public class 팰린드롬 {

    public String solution (String str) {

        String answer = "YES";

        str = str.replaceAll("[^A-Z]", "");

        String temp = new StringBuilder(str).reverse().toString();

        if (!answer.equals(temp)) answer = "NO";

        return answer;

    }



    public static void main (String[] args) {
        팰린드롬 T = new 팰린드롬();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }

}
