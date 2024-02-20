package inflearn.DFSBFS활용;

import inflearn.재귀함수트리그래프.DFS;

/**
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면
 * 어떻게 주면 되는가?
 * 각 단위의 동전은 무한정 쓸 수 있다.
 *
 * 첫 번쨰 줄에는 동전의 종류 개수가 주어진다.
 * 두 번쨰 줄에는 N개의 동전의 종류가 주어지고, 그 다음에 거슬러 줄 금액 M이 주어진다.
 * 각 동전의 종류는 100원을 넘지 않는다.
 */
public class 동전교환 {

    int[] type = {1, 3, 5};
    int returnPrice = 15;
    static int result = Integer.MAX_VALUE;

    public void DFS(int L, int sum) {

        if (sum > returnPrice) {
            return;
        }

        if (L > result) {
            return;
        }

        if (sum == returnPrice) {
            result = Math.min(result, L);
        } else {
            for(int i=0; i<type.length; ++i) {
                DFS(L+1, sum+type[i]);
            }
        }
    }

    public static void main(String[] args) {
        동전교환 solution = new 동전교환();
        solution.DFS(0, 0);
        System.out.println(result);
    }

}
