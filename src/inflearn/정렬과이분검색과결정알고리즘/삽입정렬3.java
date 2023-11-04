package inflearn.정렬과이분검색과결정알고리즘;

public class 삽입정렬3 {

    public static void sort(int[] arr) {
        int j = 0;

        for(int i=1; i<arr.length; ++i) {
            int temp = arr[i];

            for(j=i-1; j>=0; --j) {

                if (arr[j] > temp) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }

            }

            arr[j+1] = temp;

        }

    }

    public static void main(String[] args) {
        int[] arr = {11, 7, 5, 6, 10, 9};
        sort(arr);

        for (int i : arr) {
            System.out.print(i + " -> ");
        }
    }

}
