package inflearn.DFSBFS활용;

/**
 * [문제]
 * 10 이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 *
 * 출력 순서는 사전 순으로 오름차순으로 출력합니다.
 */
public class 순열구하기2 {

    static int M = 2;

    static boolean[] check;
    static int[] result = new int[M];

    public void solution(int[] arr) {
        solution(arr, 0);
    }

    public void solution(int[] arr, int index) {
        if (index == M) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for(int i=0; i<check.length; ++i) {
                if (check[i] == false) {
                    check[i] = true;
                    result[index] = arr[i];
                    solution(arr, index+1);
                    check[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        순열구하기2 solution = new 순열구하기2();
        int[] arr = { 3, 6, 9 };
        check = new boolean[arr.length];
        solution.solution(arr);
    }

}
