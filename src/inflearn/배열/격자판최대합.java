package inflearn.배열;

import java.util.Scanner;

public class 격자판최대합 {
    public void solution(String[][] wordArr) {

        int result = 0;

        int lDSum = 0;
        // 행, 열, 좌에서 우로 떨어지는 대각선
        for(int i=0; i<wordArr.length; ++i) {
            int widSum = 0;
            int heiSum = 0;

            for(int j=0; j<wordArr.length; ++j) {
                widSum += Integer.parseInt(wordArr[i][j]);
                heiSum += Integer.parseInt(wordArr[j][i]);
            }

            result = Math.max(result, Math.max(widSum, heiSum));


            lDSum += Integer.parseInt(wordArr[i][i]);
        }

        //우에서 좌로 떨어지는 대각선
        int rDSum = 0;
        int rdCount = 0;
        for(int i=wordArr.length-1; i<=0; --i) {
            rDSum += Integer.parseInt(wordArr[i][rdCount]);
        }

        result = Math.max(result, Math.max(lDSum, rDSum));

        System.out.println(result);

    }

    public static void main(String[] args) {

        격자판최대합 T = new 격자판최대합();
        Scanner kb = new Scanner(System.in);
        int length = kb.nextInt();

        kb.nextLine();

        String[][] arr = new String[length][length];

        for(int i=0; i<length; ++i) {
            arr[i] = kb.nextLine().split(" ");
        }

        T.solution(arr);

    }

}
