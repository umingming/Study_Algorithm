package inflearn.문자열;

import java.util.Scanner;

public class 숫자만추출 {

    public int solution (String str) {

        String answer = "";

        for(char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }

        return Integer.parseInt(answer);

    }



    public static void main (String[] args) {
        숫자만추출 T = new 숫자만추출();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }

}
