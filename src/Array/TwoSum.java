package Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/*
    [설계]
    1. 예시 int 배열을 1개 생성한다
    2. scanner를 선언환다.
    3. input값을 받는다
    4. 2중 for문을 돌면서 배열 내 2가지 정수의 값이 3번의 input값과 동일한지 판별한다.
*/
public class TwoSum {
    public static void main(String[] args) throws Exception{

        int[] temp = {1, 3, 5, 2, 1};

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        System.out.print("Please Input Value: ");
        int inputNumber = Integer.parseInt(reader.readLine());
        String result = "";

        for(int i=0; i<temp.length; ++i) {
            for (int j=0; j<temp.length; ++j) {
                if(temp[i] + temp[j] == inputNumber && i!=j) {
                    result = "[" + i + "," + j + "]";
                    System.out.println(result);

                    return;
                }
            }
        }

    }
}
