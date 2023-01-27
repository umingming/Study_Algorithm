package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [문제]
 * 첫째 줄에 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다. (1 ≤ N ≤ 1024, 1 ≤ M ≤ 100,000)
 * 둘째 줄부터 N개의 줄에는 표에 채워져 있는 수가 1행부터 차례대로 주어진다.
 * 다음 M개의 줄에는 네 개의 정수 x1, y1, x2, y2 가 주어지며, (x1, y1)부터 (x2, y2)의 합을 구해 출력해야 한다.
 * 표에 채워져 있는 수는 1,000보다 작거나 같은 자연수이다. (x1 ≤ x2, y1 ≤ y2)
 *
 * [예제]
 * 4 3
 * 1 2 3 4
 * 2 3 4 5
 * 3 4 5 6
 * 4 5 6 7
 * 2 2 3 4
 * 3 4 3 4
 * 1 1 4 4
 *
 * [답]
 * 27
 * 6
 * 64
 *
 * [풀이]
 * 1. nm 배열 갯수 생성
 * 2. n만큼 for문 돌아 배열 값 할당
 * 3. m만큼 for문 돌아 값 계산하여 찍어줌
 */
public class Q11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String nm = reader.readLine();

        // 1. nm 배열 갯수 생성
        int[] inputInfo = changeStringArrToIntArr(nm.split(" "));
        int n = inputInfo[0];
        int m = inputInfo[1];
        int[][] resultArr = new int[n][n];



        // 2. n만큼 for문 돌아 배열 값 할당
        for (int i=0; i<n; ++i) {
            int[] inputArr = changeStringArrToIntArr(reader.readLine().split(" "));

            for(int j=0; j<n; ++j) {
                resultArr[i][j] = inputArr[j];
            }

        }

        // 3. m만큼 for문 돌아 값 계산하여 찍어줌
        for(int i=0; i<inputInfo[1]+1; i++) {
            int[] point = changeStringArrToIntArr(reader.readLine().split(" "));

            int startX = point[0];
            int lastX = point[2];

            int startY = point[1];
            int lastY = point[3];

            int sum = 0;

            for(int x=startX-1; x<=lastX-1; ++x) {

                for(int y=startY-1; y<=lastY-1; ++y) {
                    sum += resultArr[y][x];
                }
            }

            System.out.println(sum);


        }


    }

    public static int[] changeStringArrToIntArr(String[] arr) {
        int[] resultArr = new int[arr.length];

        for(int i=0; i<arr.length; ++i) {
            resultArr[i] = Integer.parseInt(arr[i]);
        }

        return resultArr;
    }

}
