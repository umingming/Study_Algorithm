package inflearn.배열;

import java.util.Scanner;

public class 등수구하기 {

    public void solution(String[] wordArr) {

        int[] arr = new int[wordArr.length];

        for(int i=0; i<wordArr.length; ++i) arr[i] = Integer.parseInt(wordArr[i]);

        int rank = 1;
        for(int i=0; i<arr.length; ++i) {
            rank = 1;
            for(int j=0; j<arr.length; ++j) {

                if (arr[j] > arr[i]) {
                    rank++;
                }

            }
            System.out.print(rank + " ");
        }

    }

    public static void main(String[] args) {

        등수구하기 T = new 등수구하기();
        Scanner kb = new Scanner(System.in);
        String[] wordArr = kb.nextLine().split(" ");
        T.solution(wordArr);

    }

}
