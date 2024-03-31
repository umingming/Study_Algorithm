package inflearn.DFSBFS활용;

import java.util.Arrays;

public class 순열구하기응용 {

    public static int selectCount = 3;
    public static int[] arr = {1, 2, 3, 4, 5};
    public static boolean[] check = new boolean[arr.length];
    public static int[] results = new int[selectCount];

    public static int max = 0;

    public static void DFS() {
        DFS(0);
    }

    public static void DFS(int L) {
        if (L == selectCount) {
            for (int result : results) {
                System.out.print(result+ " ");
            }
            System.out.println();
        } else {
            for(int i=0; i<arr.length; ++i) {
                check[i] = true;

                if (results[L] != arr[i]) {
                    results[L] = arr[i];
                }

                max = Math.max(max, Arrays.stream(results).sum());

                DFS(L+1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        DFS();
        System.out.println(max);
    }
}
