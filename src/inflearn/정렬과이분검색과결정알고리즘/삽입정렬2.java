package inflearn.정렬과이분검색과결정알고리즘;

public class 삽입정렬2 {

    public static int[] selectSort(int[] arr) {

        int j=0;
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

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = {13, 5, 11, 7, 23, 15};

        for (int i : selectSort(arr)) {
            System.out.println(i);
        }
    }

}
