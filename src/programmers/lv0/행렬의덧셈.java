package programmers.lv0;

/**
 *
 */
public class 행렬의덧셈 {

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = arr1;

        for(int i=0; i< arr1.length; ++i) {
            for(int j=0; j<arr1[0].length; ++j) {
                answer[i][j] += arr2[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{2,3}};
        int[][] arr2 = {{3,4},{5,6}};

        solution(arr1, arr2);
    }

}
