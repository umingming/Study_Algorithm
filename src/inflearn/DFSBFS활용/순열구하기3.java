package inflearn.DFSBFS활용;

/**
 * [문제]
 * 10 이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 *
 * 출력 순서는 사전 순으로 오름차순으로 출력합니다.
 *
 * 3, 6, 9
 *
 * 3 6
 * 3 9
 * 6 3
 * 6 9
 * 9 3
 * 9 6
 */
public class 순열구하기3 {

    static int M = 2;

    static int[] arr = new int[]{3, 6, 9};

    static boolean[] dis = new boolean[arr.length];

    static int[] results = new int[M];

    public static void main(String[] args) {
        순열구하기3 solution = new 순열구하기3();
        solution.DFS();
    }

    private void DFS() {
        this.DFS(0);
    }

    private void DFS(int L) {
        if (L == M) {
            for(int result : results) {
                System.out.print(result+ " ");
            }
            System.out.println();

        } else {
            for(int i=0; i<arr.length; ++i) {
                if (dis[i] == false) {
                    dis[i] = true;
                    results[L] = arr[i];
                    DFS(L+1);
                    dis[i] = false;
                }
            }
        }
    }
}
