package inflearn.문자열;

import java.util.Scanner;

public class 유효한팰린드롬3 {

    private static final String YES = "Yes";

    private static final String NO = "No";

    public static void main(String[] args) {
        유효한팰린드롬3 solution = new 유효한팰린드롬3();

        Scanner scanner = new Scanner(System.in);
//        String word = scanner.next();
        String word = "found7, time: study; Yduts; emit, 7Dnuof";

        System.out.println(solution.isPal(word) ? YES : NO);
    }

    public boolean isPal(String word) {

        String preProcessingWord = word.toUpperCase()
                                       .replaceAll("[^A-Z]", "");
        String reverseWord = new StringBuilder(preProcessingWord).reverse().toString();

        return preProcessingWord.equals(reverseWord);

    }
}
