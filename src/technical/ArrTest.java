package technical;

/**
 * 아래의 Arr를 741, 852, 963 순으로 순회하고 싶다.
 */
public class ArrTest {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3},
                                  {4, 5, 6},
                                  {7, 8, 9}};

        // 현재 구조에서는 x축으로 점점 증가하고, x축이 완전히 증가 되었으면 y축이 증가하는 구조
        // 즉 이걸 구현하기 위해서는 두개의 점점 증가하는 명제가 필요하다 (a 명제가 점점 증가하고, a 명제의 증가가 끝났을 때 b 명제가 증가)
        for(int i=0; i<arr.length; ++i) {
            for(int j=0; j<arr[i].length; ++j) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // 반대로 이 경우 증가하는 명제와 감소하는 명제가 하나씩 필요한 것.
        //
        for (int i=0; i<arr.length; ++i) {
            for(int j=arr.length-1; j>=0; --j) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
    }
}
