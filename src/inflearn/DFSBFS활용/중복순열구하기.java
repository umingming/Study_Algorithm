package inflearn.DFSBFS활용;

import inflearn.재귀함수트리그래프.DFS;

/**
 * 1부터 N까지 번호가 적힌 구슬이 있습니다.
 * 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 *
 * [입력 설명]
 * 첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.
 *
 * [출력 설명]
 * 첫 번째 줄에 결과를 출력합니다.
 * 출력 순서는 사전순으로 오름차순으로 출력합니다.
 *
 * [입력 예제 1]
 * 3 2
 *
 * [출력 예제 1]
 * 1 1
 * 1 2
 * 1 3
 * 2 1
 * 2 2
 * 2 3
 * 3 1
 *
 * [풀이]
 *
 *
 */
public class 중복순열구하기 {
    static int[] pm;
    static int n = 3;
    static int m = 2;
    public static void DFS(int L) {
        if (L == m) {
            System.out.println(pm[0] + " " + pm[1]);
        } else {
            for(int i=1; i<=3; ++i) {
                pm[L] = i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) {
        pm = new int[m];

        DFS(0);
    }
}
