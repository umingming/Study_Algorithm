package baekjoon.b301_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 수빈이는 동생 N명과 숨바꼭질을 하고 있다. 수빈이는 현재 점 S에 있고, 동생은 A1, A2, ..., AN에 있다.
 *
 * 수빈이는 걸어서 이동을 할 수 있다.
 * 수빈이의 위치가 X일때 걷는다면 1초 후에 X+D나 X-D로 이동할 수 있다.
 *
 * 수빈이의 위치가 동생이 있는 위치와 같으면, 동생을 찾았다고 한다.
 *
 * 모든 동생을 찾기위해 D의 값을 정하려고 한다. 가능한 D의 최댓값을 구해보자.
 */

public class Q17087 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = reader.readLine().split(" ");
        int[] intArr = new int[arr.length];

        for (int i=0; i<arr.length; ++i) {
            intArr[i] = Integer.parseInt(arr[i]);
        }

        int brotherCount = intArr[0];
        int myLocation = intArr[1];

        String[] brotherArr = reader.readLine().split(" ");

        if (brotherArr.length > brotherCount) {
            System.out.println("동생의 수가 입력한 수보다 많습니다.");
            return;
        }

        int resultCount = 0;

        for(int i=0; i<brotherArr.length; ++i) {

            int diffrent = myLocation - Integer.parseInt(brotherArr[i]);

            if (resultCount < diffrent) {
                resultCount = diffrent;
            }
        }

        System.out.println(resultCount);


    }

}
