package inflearn.정렬과이분검색과결정알고리즘;

import java.util.Arrays;

public class 이분검색 {

    public static int solution(int[] arr, int target) {
        Arrays.sort(arr);

        int answer = 0;
        int lt = 0;
        int rt = arr.length-1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (arr[mid]==target) {
                answer = mid+1;
                break;
            }
            if (arr[mid]>target) {
                rt = mid-1;
            } else {
                lt = mid+1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] arr = {23, 87, 65, 12, 57, 32, 99, 81};
        int target = 32;

        System.out.println(solution(arr, target));

    }
}
