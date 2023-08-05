package inflearn;

import java.util.Scanner;

//연습장
public class 팰린드롬 {

    public String solution (String str) {

        String answer = "YES";

        char[] arr = str.toUpperCase().toCharArray();
        int lt = 0, rt = arr.length-1;

        while (lt < rt) {
            if (!Character.isAlphabetic(arr[lt])) lt++;
            else if (!Character.isAlphabetic(arr[rt])) rt--;
            else {
                if (arr[lt] != arr[rt]) {
                    answer = "NO";
                    break;
                } else {
                    lt++;
                    rt--;
                }
            }


        }

        return answer;

    }



    public static void main (String[] args) {
        팰린드롬 T = new 팰린드롬();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.print(T.solution(str));
    }

}
