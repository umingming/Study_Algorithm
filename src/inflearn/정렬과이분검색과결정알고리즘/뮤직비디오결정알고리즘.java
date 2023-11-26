package inflearn.정렬과이분검색과결정알고리즘;

import java.util.Arrays;

public class 뮤직비디오결정알고리즘 {

    private static int getNeedDvdCount (int[] arr, int mid) {
        int sum = 0;
        int result = 1;

        for (int i : arr) {
            if (sum+i > mid) {
                result++;
                sum = i;
            } else {
                sum+=i;
            }
        }

        return result;
    }

    private static int getMid(int lt, int rt) {
        return (lt+rt) / 2;
    }

    public static int solution(int[] arr, int dvdCount) {
        int result = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();
        while (lt<=rt) {
            int mid=getMid(lt, rt);
            if (getNeedDvdCount(arr, mid)<=dvdCount) {
                result = mid;
                rt = mid - 1;
            } else {
                lt = mid+1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int dvdCount = 3;

        System.out.println(solution(arr, dvdCount));
    }

}
