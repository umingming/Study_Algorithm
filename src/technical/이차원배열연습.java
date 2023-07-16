package technical;

import java.util.Arrays;

/**
 * 일반적으로 x축 y축 개념으로 이차원 배열을 생각하다보니
 * 가끔 [x][y] 축으로 착각하기도 하는 것 같다.
 */
public class 이차원배열연습 {

    public static void main(String[] args) {

        int[][] temp = new int[10][10];

        for(int i=0; i<10; ++i){
            temp[i] = new int[]{i*10+0, i*10+1, i*10+2, i*10+3, i*10+4, i*10+5, i*10+6, i*10+7, i*10+8, i*10+9};
        }

        System.out.println(Arrays.toString(temp[0]));
        System.out.println(temp[0][1]);
        System.out.println(temp[1][1]);


    }

}
