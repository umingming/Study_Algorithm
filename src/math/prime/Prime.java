package math.prime;

public class Prime {

    // n이하의 수 중 소수를 판별하는 방법
    // 시간 복잡도 O(n²)
    public static void primeCheck(int n) {

        for (int i=1; i<n; ++i) {
            if(is_prime(i)) {
                System.out.printf("%d는 소수입니다.", i);
            }
        }

    }

    // 소수 판별 알고리즘
    // 시간 복잡도 O(n)
    public static boolean is_prime(int number) {

        if (number > 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }

        return true;


    }

}
