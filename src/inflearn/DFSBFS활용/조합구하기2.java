package inflearn.DFSBFS활용;

/**
 * 1부터 N까지 번호가 적힌 구슬이 있습니다.
 *
 * 이 중 M개를 뽑는 방법의 수를 출력하는 프로그을 작성하세요
 */
public class 조합구하기2 {

    static int N = 6;

    static int M = 3;

    static int[] arr = new int[N+1];

    static boolean[] check = new boolean[arr.length];

    static int[] results = new int[M];

    /**
     * 방안
     * 1. DFS 시작(L, s)
     * 2. check가 false면
     *  2.1. for문을 돈다.
     *  2.2. check = true 처리
     *  2.3. 값을 채워 넣는다.
     *  2.4. 재귀로 DFS 호출
     *  2.5 check = false 처리
     */
    public static void main(String[] args) {
        조합구하기2 solution = new 조합구하기2();
        solution.solution(0, 1);
    }

    public void solution(int L, int s) {
        if (L == M) {
            for(int result : results) {
                System.out.print(result + " ");
            }
            System.out.println();
        } else {
            for(int i=s; i<arr.length; ++i) {
                results[L] = i;
                solution(L+1, i+1);
            }
        }
    }

}
