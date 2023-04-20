package gpt;

import java.util.Scanner;

public class DictionaryChar {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String word = scan.next();

        String[] wordArr = word.split("");

        char[] charArr = new char[wordArr.length];

        for(int i=0; i<wordArr.length; ++i) {
            charArr[i] = wordArr[i].charAt(0);
        }

        for(int i=0; i<charArr.length; ++i) {

            

        }



    }

}
