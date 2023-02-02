package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 평균은 넘겠지
 *
 * [문제]
 * 대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다. 당신은 그들에게 슬픈 진실을 알려줘야 한다.
 *
 * [입력 1]
 * 5
 * 5 50 50 70 80 100
 * 7 100 95 90 80 70 60 50
 * 3 70 90 80
 * 3 70 90 81
 * 9 100 99 98 97 96 95 94 93 91
 *
 * [결과 1]
 * 40.000%
 * 57.143%
 * 33.333%
 * 66.667%
 * 55.556%
 *
 */
public class Q4344 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int repeat = Integer.parseInt(reader.readLine());


        for (int i=0; i<repeat; ++i) {
            double sum = 0;

            double winner = 0;
            String[] inputArr = reader.readLine().split(" ");

            for (int j=1; j<inputArr.length; ++j) {

                sum += Double.parseDouble(inputArr[j]);

            }

            double avg = sum / Double.parseDouble(inputArr[0]);
            for (int j=1; j<inputArr.length; ++j) {

                if (Double.parseDouble(inputArr[j]) > avg) {
                    winner = winner + 1;
                }

            }

            System.out.printf("%.3f%s\n", Math.round(winner*100/Double.parseDouble(inputArr[0])*1000)/1000.0, "%");

        }

    }

}
