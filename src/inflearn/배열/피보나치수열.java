package inflearn.배열;

import java.util.ArrayList;
import java.util.List;

public class 피보나치수열 {
    public void solution (int count) {

        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);

        for(int i=2; i<count; ++i) {
            int num = result.get(i-2) + result.get(i-1);
            result.add(i, num);
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }


    }



    public static void main (String[] args) {
        피보나치수열 T = new 피보나치수열();
//        Scanner kb = new Scanner(System.in);
//        String str = kb.next();
//        int[] aArr = {2, 3, 3, 1, 3};
//        int[] bArr = {1, 1, 2, 2, 3};
        T.solution(10);
    }


}
