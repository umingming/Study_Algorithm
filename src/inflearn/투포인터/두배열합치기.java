package inflearn.투포인터;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 */
public class 두배열합치기 {
    public void solution(String[] firstArr, String[] secondArr) {

        // length 8
        int[] resultArr = new int[firstArr.length + secondArr.length];

        int fPointer = 0;
        int sPointer = 0;
        int rPointer = 0;

        for(int i=0; i< resultArr.length; ++i) {
            if (fPointer != firstArr.length && Integer.parseInt(firstArr[fPointer]) < Integer.parseInt(secondArr[sPointer])) {
                resultArr[rPointer] = Integer.parseInt(firstArr[fPointer]);
                fPointer++;

            } else {
                resultArr[rPointer] = Integer.parseInt(secondArr[sPointer]);
                sPointer++;
            }
            rPointer++;
        }

        for (int i : resultArr) {
            System.out.print(i + " ");
        }

    }

    public static void main(String[] args) {

        두배열합치기 solution = new 두배열합치기();
        Scanner kb = new Scanner(System.in);
        String[] firstArr = "1 3 5".split(" ");

        String[] secondArr = "2 3 6 7 9".split(" ");

        solution.solution(firstArr, secondArr);

    }
}
