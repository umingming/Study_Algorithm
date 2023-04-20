package sort.quick;

public class QuickSortVer2 {

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right); // pivotIndex를 기준으로 배열을 분할합니다.
            quickSort(arr, left, pivotIndex - 1); // 왼쪽 부분 배열을 재귀적으로 정렬합니다.
            quickSort(arr, pivotIndex + 1, right); // 오른쪽 부분 배열을 재귀적으로 정렬합니다.
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left+right)/2]; // 배열의 마지막 원소를 pivot으로 선택합니다.
        int i = left - 1; // i는 왼쪽 부분 배열의 끝 인덱스입니다.

        for (int j = left; j < right; j++) { // pivot을 제외한 나머지 원소들에 대해 반복합니다.
            if (arr[j] < pivot) { // pivot보다 작은 원소를 찾으면
                i++; // i를 증가시키고
                swap(arr, i, j); // 그 원소와 arr[i]를 교환합니다.
            }
        }

        swap(arr, i + 1, right); // pivot을 i + 1번째 원소와 교환합니다.
        return i + 1; // pivot의 인덱스를 반환합니다.
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
