package inflearn.정렬과이분검색과결정알고리즘;

public class 선택정렬 {

    public int[] selectSort(int[] arr) {

        for(int i=0; i<arr.length; ++i) {
            int idx = i;
            for(int j=i+1; j<arr.length; ++j) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;

        }

        return arr;
    }

    public static void main(String[] args) {
        선택정렬 solution = new 선택정렬();
        int[] arr = {13, 5, 11, 7, 23, 15};

        for (int i : solution.selectSort(arr)) {
            System.out.println(i);
        }
    }

}
