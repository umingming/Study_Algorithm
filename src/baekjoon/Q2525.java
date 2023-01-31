package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2525 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        int[] mmss = new int[2];

        for(int i=0; i<input.length; ++i) {
            mmss[i] = Integer.parseInt(input[i]);
        }

        int plusTime = Integer.parseInt(reader.readLine());

        if (mmss[1] + plusTime >= 60) {
            mmss[0] = mmss[0] + ((mmss[1] + plusTime) / 60 );
            mmss[1] = (mmss[1] + plusTime) % 60;

        } else {
            mmss[1] = mmss[1] + plusTime;
        }

        if (mmss[0] >= 24) {
            mmss[0] = mmss[0] - 24;
        }

        System.out.print(mmss[0] + " " + mmss[1]);

    }

}
