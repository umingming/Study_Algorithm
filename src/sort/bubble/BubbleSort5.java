package sort.bubble;

/**
 * lastIndex에 시멘틱한 값이 부여되어야 하니까 이게 좀 더 정확하겠다.
 */
public class BubbleSort5 {

    public static void main(String[] args) {

    }

    public static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length-1);
    }

    public static void bubbleSort(int[] arr, int lastIndex) {
        if (lastIndex > 0) {

            for (int i=1; i<=lastIndex; ++i) {

                if (arr[i-1] > arr[i]) {

                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;

                }

            }

            bubbleSort(arr, lastIndex-1);

        }
    }

}
