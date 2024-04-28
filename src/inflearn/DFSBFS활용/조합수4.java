package inflearn.DFSBFS활용;

/**
 * 5C3을 뽑는 경우의 수
 *
 * 3C2는?
 * 2C2 더하기 2C1
 * 1        2
 *
 * [풀이]
 * 1. nCr = n-1Cr + n-1Cr-1
 */
public class 조합수4 {

    static int[][] arr;

    public static int DFS(int n, int r) {
        if (arr[n][r] > 0) {
            return arr[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        } else {
            return arr[n][r] = DFS(n-1, r) + DFS(n-1, r-1);
        }
    }

    public static void main(String[] args) {

        arr = new int[6][3];
        System.out.println(DFS(5, 2));
    }

}
