package inflearn.DFSBFS활용;

public class 조합수3 {

    static int[][] arr;

    public static int DFS(int n, int r) {
        if (arr[n][r] > 0) {
            return arr[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        } else {
            return arr[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
        }
    }

    public static void main(String[] args) {
        int n = 33;
        int r = 19;

        arr = new int[n+1][r+1];
        System.out.println(DFS(n, r));

    }
}
