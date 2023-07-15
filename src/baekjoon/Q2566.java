package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 */
public class Q2566 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = new int[10][10];




        int maxNumber = 0;
        int[] maxNumberCoordinate = new int[2];

        for(int i=0; i<arr.length; ++i) {

            for(int j=0; j<arr[i].length; ++j) {

                if (arr[i][j] > maxNumber) {
                    maxNumber = arr[i][j];
                    maxNumberCoordinate[0] = i;
                    maxNumberCoordinate[1] = i;
                }

            }

        }

        System.out.println(maxNumber);
        System.out.println(maxNumberCoordinate[0] + " " + maxNumberCoordinate[1]);

    }

}
