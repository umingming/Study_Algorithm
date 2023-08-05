package inflearn;

import java.util.Scanner;


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
