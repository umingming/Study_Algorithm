package inflearn.DFSBFS활용;

public class 조합구하기3 {

    int n = 5;
    int r = 3;

    int[] arr = new int[r];

    public static void main(String[] args) {
        조합구하기3 solution = new 조합구하기3();
        solution.DFS(0, 1);
    }

    public void DFS(int L, int s) {
        if (L == r) {
            for(int result : arr) {
                System.out.print(result + " ");
            }
            System.out.println();
        } else {
            for(int i=s; i<=n; ++i) {
                arr[L] = i;
                DFS(L+1, i+1);
            }
        }
    }
}
