package inflearn.DFSBFS활용;

/**
 * 1부터 N까지 번호가 적힌 구슬이 있습니다.
 * 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열 하는 방법을 모두 출력합니다.
 *
 * 1 2 3
 */
public class 중복순열구하기 {

    static int n, m;
    static int[] arr;

    public void solution(int L) {
        if (L == m) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        } else {
            for(int i=1; i<=n; ++i) {
                arr[L] = i;
                solution(L+1);
            }
        }
    }

    public static void main(String[] args) {
        중복순열구하기 solution = new 중복순열구하기();
        n = 3;
        m = 2;
        arr = new int[m];
        solution.solution(0);
    }

}
