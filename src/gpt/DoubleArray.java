package gpt;

/**
 * 두 개의 정수 배열 A와 B가 주어집니다. 각 배열은 길이가 n이며, 배열의 요소는 0보다 크거나 같은 정수입니다.
 * 두 배열에서 하나씩 요소를 선택하고 곱한 값을 모두 더합니다.
 * 이때, 가능한 최대값을 구하세요. (n은 1 이상 50 이하입니다.)
 */
public class DoubleArray {

    public static void main(String[] args) {

        int resultCount = 0;
        int[] A = {1, 12,3, 1, 2, 3, 4, 5, 2, 1, 2, 34, 11, 11, 50};
        int[] B = {5, 22, 3, 1, 2, 8, 41, 22, 1, 22, 3, 4, 14, 32};

        for(int i=0; i<A.length; ++i) {
            for(int j=0; j<B.length; ++j) {

                int multiplyCount = A[i] * B[j];

                if (resultCount < multiplyCount) {
                    resultCount = multiplyCount;
                }


            }
        }

        System.out.println(resultCount);

    }

}
