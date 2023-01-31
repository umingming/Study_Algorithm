package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3003 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] fullCount = new int[6];

        fullCount[0] = 1;
        fullCount[1] = 1;
        fullCount[2] = 2;
        fullCount[3] = 2;
        fullCount[4] = 2;
        fullCount[5] = 8;

        String[] inputCount = reader.readLine().split(" ");

        for(int i=0; i<inputCount.length; ++i) {
            System.out.print(fullCount[i] - Integer.parseInt(inputCount[i]) + " ");
        }

    }

}
