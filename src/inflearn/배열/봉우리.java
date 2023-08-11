package inflearn.배열;

import java.util.Scanner;

public class 봉우리 {
    public void solution(String[][] wordArr) {

        int[][] newArr = new int[wordArr.length+2][wordArr.length+2];
        for(int i=0; i<wordArr.length; ++i) {

            for(int j=0; j<wordArr.length; ++j) {

                newArr[j+1][i+1] = Integer.parseInt(wordArr[i][j]);

            }

        }

        int result = 0;
        for(int i=1; i<newArr.length-1; ++i) {
            for(int j=1; j<newArr.length-1; ++j) {

                int nowNum = newArr[j][i];

                int top = newArr[j+1][i];
                int left = newArr[j][i-1];
                int right = newArr[j][i+1];
                int bottom = newArr[j-1][i];

                if (nowNum == Math.max(nowNum, Math.max(top, Math.max(left, Math.max(right, bottom))))) result++;

            }
        }

        System.out.println(result);

    }

    public static void main(String[] args) {

        봉우리 T = new 봉우리();
        Scanner kb = new Scanner(System.in);
        int length = kb.nextInt();

        kb.nextLine();

        String[][] arr = new String[length][length];

        for(int i=0; i<length; ++i) {
            arr[i] = kb.nextLine().split(" ");
        }

        for (String[] strings : arr) {

            for (String string : strings) {
                System.out.println(string);
            }

            System.out.println();

        }

        T.solution(arr);

    }

}
