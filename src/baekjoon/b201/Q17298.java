package baekjoon.b201;


import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.io.*;
import java.util.Stack;

/**
 * 크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
 * Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.
 *
 * 예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
 *
 * [예제]
 * 3 5 2 7
 * [결과]
 * 5 7 7 -1
 *
 * 예제
 * 9 5 4 8
 * [결과]
 * -1 8 8 -1
 *
 * [풀이]
 * 1. int로 다 치환
 * 2. 첫번째 인덱스 저장
 * 3. for문을 돌아준다
 *  > 반복문을 돌 때 스텍이 비어있으면 i를 push 해준다.
 *  > 비지 않고 a[stack.peek] < a[i]이면
 *          > ans[stack.pop] = a[i]
 *  >
 * 3.
 *
 */
public class Q17298 {

    public static void main(String[] args) throws IOException {

        // 리더 생성
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 임시로 받고
        String[] temp = "3 5 2 4 6".split(" ");

        // int 로 변환할 배열 생성
        int[] a = new int[temp.length];
        // 정답 배열 생성
        int[] ans = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            // int로 변환
            a[i] = Integer.parseInt(temp[i]);
        }
        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // 첫번째 인덱스 저장
        stack.push(0);

        /**
         * 35246
         * Step 1
         * Stack = {0}
         * i = 1
         * a[0] 3 < a[1] 5?
         * ans[0] = 5
         * Stack = {1}
         *
         * Step 2
         * Stack = {1}
         * i = 2
         * a[1] 5 < a[2] 2?
         * Stack = {1, 2}
         *
         * Step 3
         * Stack = {1, 2}
         * i = 3
         * a[1] 5 < a[3] 4
         * Stack = {1, 2, 4}
         *
         * Step 4
         * Stack = {1, 2, 4}
         * i = 4
         * a[1] 5 < a[4] 6
         * ans[1] = 6
         *
         * 5, 6, -1 -1 -1
         */

        for (int i = 1; i < temp.length; i++) {
            if (stack.isEmpty()) {
                // 반복문에 들어올 때 스택이 비어있으면 인덱스 저장
                stack.push(i);
            }

            // 비어있지 않고 숫자가 인덱스 가장 위쪽 숫자보다 크면
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                // 정답 배열 중 스택의 가장 위쪽 숫자와 같은 인덱스에 i번째 숫자를 넣는다
                ans[stack.pop()] = a[i];
            }
            // 다음번에 비교할 숫자를 stack에 집어넣는다
            stack.push(i);
        }

        // 반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌 때 까지
        while (!stack.empty()) {
            // stack에 쌓인 index에 -1을 넣고
            ans[stack.pop()] = -1;
        }

        for (Integer integer : ans) {
            System.out.println(integer);
        }


    }

}
