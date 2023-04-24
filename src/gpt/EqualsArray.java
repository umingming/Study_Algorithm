package gpt;

public class EqualsArray {

    /**
     * 문제: 정수 배열이 주어집니다. 배열에서 가장 많이 등장하는 정수를 반환하는 함수를 작성하세요. 만약 여러 개의 정수가 동일한 빈도로 등장하는 경우, 그 중 가장 작은 정수를 반환하세요.
     *
     * 예시:
     * Input: [1, 2, 3, 1, 4, 1]
     * Output: 1
     *
     * Input: [2, 2, 3, 1, 4, 1]
     * Output: 1 or 2 (둘 다 가능)
     *
     * Input: [2, 2, 3, 1, 4, 4]
     * Output: 2
     */
    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 1, 4, 1};

        int arrLength = 0;
        for(int i : nums) {
            if(i > arrLength) arrLength=i;
        }

        int[] countArr = new int[arrLength-1];

        for(int i : nums) {
            countArr[i]++;
        }

        int valueMax = 0;
        int indexMax = 0;
        for(int i=0; i<countArr.length; ++i) {
            if (countArr[i] > valueMax) {
                valueMax = countArr[i];
                indexMax = i;
            }
        }
        System.out.println(indexMax);
    }
}
