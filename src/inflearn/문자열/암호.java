package inflearn.문자열;

import java.util.Scanner;

public class 암호 {

    public String solution (String str) {

        String answer = "";

        str = str.replace("#", "1").replace("*", "0");

        for(int i=0; i<str.length()/7; ++i) {

            String temp = str.substring(i*7, (i+1)*7);
            answer += (char)Integer.parseInt(temp, 2);
        }

        return answer;

    }



    public static void main (String[] args) {
        암호 T = new 암호();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }

}
