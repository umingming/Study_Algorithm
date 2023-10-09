package inflearn.정렬과이분검색과결정알고리즘;

public class 버블정렬 {

    public static void bubbleSort(int[] arr) {

        for(int i=0; i<arr.length-1; ++i) {
            for(int j=0; j<arr.length-i-1; ++j) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 5, 11, 7, 23, 15};
        bubbleSort(arr);


        for (int i : arr) {
            System.out.print(i + " -> ");
        }
    }

}
