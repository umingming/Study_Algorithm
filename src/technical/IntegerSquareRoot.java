package technical;

public class IntegerSquareRoot {

    public static int integerSqrt(int x) {
        if (x <= 1) {
            return x;
        }

        int left = 1;
        int right = x;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // 만약 mid * mid가 x보다 크면 mid를 줄여야 함
            if (mid <= x / mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int x = 16;
        int sqrt = integerSqrt(x);
        System.out.println("Integer square root of " + x + " is " + sqrt);
    }
}