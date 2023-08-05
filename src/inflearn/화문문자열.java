package inflearn;

import java.util.Scanner;

public class 화문문자열 {

    public String solution (String str) {

        String answer = "YES";

        char[] arr = str.toUpperCase().toCharArray();
        int lt = 0, rt = arr.length-1;

        while (lt < rt) {
            if (!(arr[lt] == arr[rt])) {
                answer = "NO";
                break;
            }

            lt++;
            rt--;
        }

        return answer;

    }



    public static void main (String[] args) {
        화문문자열 T = new 화문문자열();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }

}
