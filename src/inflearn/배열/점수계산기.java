package inflearn.배열;

import java.util.Scanner;

public class 점수계산기 {

    public void solution(String[] wordArr) {


        int[] intArr = new int[wordArr.length];

        for(int i=0; i<intArr.length; ++i) intArr[i] = Integer.parseInt(wordArr[i]);

        int result = 0;
        int count = 0;

        result+=intArr[0];
        count+=intArr[0];

        for(int i=1; i<intArr.length; ++i) {

            if (intArr[i] == 0) {
                count = 0;
            } else {
                count++;
                result += count;
            }

        }

        System.out.print(result);

    }

    public static void main(String[] args) {

        점수계산기 T = new 점수계산기();
        Scanner kb = new Scanner(System.in);
        String[] wordArr = kb.nextLine().split(" ");
        T.solution(wordArr);

    }

}
