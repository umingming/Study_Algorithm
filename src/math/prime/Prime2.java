package math.prime;

import technical.MyAnnotation;

// √N 이하의 자연수들로 모두 나눠본다.
// 𝐍 을 임의의 수로 나누게 되면 임의의 수가 √N 보다 작다면 결국 나머지는 √N 보다 클 수 밖에 없다.
public class Prime2 {

    public static void main(String[] args) {

        int num = 1000;

        for(int i=1; i<num+1; ++i) {

            if (isPrime(i)) {
                System.out.printf("%d는 소수입니다\n", i);
            }

        }

    }

    public static boolean isPrime (int num) {

        if (num < 2) return false;
        if (num == 2) return true;

        for(int i=2; i<=Math.sqrt(num); ++i) {

            if (num%i == 0) {
                return false;
            }

        }

        return true;


    }

}
