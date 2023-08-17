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
public class 공통원소구하기 {

    public void solution(String[] arrA, String[] arrB) {

        List<Integer> list = new ArrayList<>();

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int ap = 0, bp = 0;

        while(ap < arrA.length && bp < arrB.length) {
            if (arrA[ap].equals(arrB[bp])) {
                list.add(Integer.parseInt(arrA[ap++]));
                bp++;
            }
            else if (Integer.parseInt(arrA[ap]) < Integer.parseInt(arrB[bp])) ap++;
            else bp++;
        }
        for (Integer integer : list) System.out.print(integer + " ");
    }

    public static void main(String[] args) {

        공통원소구하기 solution = new 공통원소구하기();

        String word1 = "1 3 9 5 2";
        String word2 = "3 2 5 7 8";

        solution.solution(word1.split(" "), word2.split(" "));


    }
}
