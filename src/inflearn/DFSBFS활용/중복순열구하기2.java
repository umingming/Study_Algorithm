package inflearn.DFSBFS활용;

/**
 * 1부터 N까지 번호가 적힌 구슬이 있습니다.
 * 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열 하는 방법을 모두 출력합니다.
 *
 * 1 2 3
 * 1 1
 * 1 2
 * 1 3
 * 2 2
 * 2 3
 * 3 1
 * 3 2
 * 3 3
 */
public class 중복순열구하기2 {

    static int N = 3;

    static int M = 2;

    static int[] arr = new int[N + 1];

    static int[] result = new int[M];

    public static void main(String[] args) {
        중복순열구하기2 solution = new 중복순열구하기2();
        solution.init();
        solution.DFS();
    }

    private void init() {
        for(int i=0; i<arr.length; ++i) {
            arr[i] = i;
        }
    }

    private void DFS() {
        this.DFS(0);
    }

    private void DFS(int L) {
        if (L == M) {
            for(int result : result) {
                System.out.print(result + " ");
            }
            System.out.println();
        } else {
            for(int i=1; i<arr.length; ++i) {
                result[L] = i;
                DFS(L+1);
            }
        }
    }

}
