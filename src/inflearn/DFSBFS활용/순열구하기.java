package inflearn.DFSBFS활용;

import inflearn.재귀함수트리그래프.DFS;

/**
 * [문제]
 * 10 이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 *
 * 출력 순서는 사전 순으로 오름차순으로 출력합니다.
 */
public class 순열구하기 {

    static int n, m;
    static int[] arr, answer;
    static boolean[] ch;

    public void DFS(int L) {
        if (L == m) {
            for (int i : answer) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i=0; i<arr.length; ++i) {
                if (!ch[i]) {
                    ch[i] = true;
                    answer[L] = arr[i];
                    DFS(L+1);
                    ch[i] = false;
                }
            }
        }
    }


    public static void main(String[] args) {
        순열구하기 solution = new 순열구하기();
        n = 3;
        m = 2;

        answer = new int[m];
        ch = new boolean[n];
        arr = new int[]{3, 6, 9};


        solution.DFS(0);
    }
}
