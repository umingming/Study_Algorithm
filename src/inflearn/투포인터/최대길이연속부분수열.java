package inflearn.투포인터;

/**
 * 0과 1로 구성된 길이가 N인 수열이 주어집니다.
 * 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
 * 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
 *
 * 만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
 *
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 * 여러분이 만들 수 있는 1이 연속된 연속부분수열은
 *
 * 14 2
 * p                         p
 * 1 1 0 0 1 1 0 1 1 0 1 1 0 1
 *
 */
public class 최대길이연속부분수열 {

    public void solution(int[] arr, int isChangeCount) {
        int lt=0, max=0, cnt=0;
        for(int rt=0; rt<arr.length; ++rt) {

            if (arr[rt] == 0) cnt++;

            while(cnt > isChangeCount) {
                if (arr[lt]==0) cnt--;
                lt++;
            }
            max = Math.max(max, rt-lt+1);
        }

        System.out.println(max);

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};
        최대길이연속부분수열 solution = new 최대길이연속부분수열();
        solution.solution(arr, 2);

    }

}
