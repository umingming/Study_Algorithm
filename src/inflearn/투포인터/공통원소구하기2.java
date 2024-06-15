package inflearn.투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 설명
 *
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 *
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 *
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 *
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 *
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 *
 *
 * 출력
 * 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
 *
 *
 * 5
 * 1 3 9 5 2
 * 5
 * 3 2 5 7 8
 */
public class 공통원소구하기2 {

    public static void main(String[] args) {
        int[] firstArr = new int[]{1, 3, 9, 5, 2};
        int[] secondArr = new int[]{3, 2, 5, 7, 8};

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);

        int lx = 0;
        int rx = 0;
        List<Integer> resultList = new ArrayList<>();

        while (lx < firstArr.length && rx < secondArr.length) {
            int firstNum = firstArr[lx];
            int secondNum = secondArr[rx];
            if (firstNum == secondNum) {
                resultList.add(firstNum);
                lx++;
                rx++;
            } else if (firstNum < secondNum){
                lx++;
            } else {
                rx++;
            }
        }

        for(int result : resultList) {
            System.out.print(result + " ");
        }
        System.out.println();
    }
}
