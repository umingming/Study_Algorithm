package baekjoon.b201;


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
 * 1. 내 바로 오른쪽의 수가 나보다 큰지를 판별
 * 2. 그렇다면 그게 오큰수~
 *  > 스텍에 값이 있는지를 보고 그 값이랑도 판별 해준당
 * 3. 만약 그렇지 않다면 Stack에 넣어준다
 *
 */
public class Q17298 {

    public static void main(String[] args) throws IOException {

        // 리더 생성
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 임시로 받고
        String[] temp = "1 3 2 10 4 3 7 1 6 4".split(" ");

        // int 로 변환할 배열 생성
        int[] a = new int[temp.length];
        // 정답 배열 생성
        int[] ans = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            a[i] = Integer.parseInt(temp[i]);
        }
        Stack<Integer> stack = new Stack<>();



        for(int j=0; j<a.length-1; ++j) {

            if (a[j] < a[j+1]) {
                ans[j] = a[j];
                if (!stack.isEmpty() && a[stack.peek()] < a[j]) {
                    while(!stack.isEmpty()) {
                        ans[stack.pop()] = a[j];
                    }
                }
            } else {
                stack.push(j);
            }

        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        ans[ans.length-1] = -1;

        for (int i : ans) {
            System.out.println(i);
        }

    }

}
