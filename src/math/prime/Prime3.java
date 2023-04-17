package math.prime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 에라토스테네스의 체
// 소수를 구하는 대표적인 방법 중 하나
// k=2부터 √N 이하까지 반복하여 자연수들 중 k를 제외한 k의 배수들을 제외시킨다.
public class Prime3 {

    public static boolean[] prime;

    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        int n = Integer.parseInt(reader.readLine());

        int n = 333;
        long start = System.currentTimeMillis();

        makeprime(n);

        for(int i = 0; i < prime.length; i++) {
            if(prime[i] == true) {	// 소수(false)일 경우 출력
                System.out.println(i);
            }
        }

        long end = System.currentTimeMillis();


    }

    public static void makeprime(int n) {

        prime = new boolean[n + 1];

        /**
         * 소수가 아닌 index = true
         * 소수인 index = false;
         */

        // 2 미만의 N을 입력 받으면 소수는 판별할 필요 없으므로 바로 return
        if(n < 2) {
            return;
        }

        prime[0] = prime[1] = false;

        // 제곱근 함수 : Math.sqrt()
        for(int i = 2; i <= Math.sqrt(n); ++i) {

            // 이미 체크된 배열이면 다음 반복문으로 skip
            if(prime[i] == false) {
                continue;
            }

            // i 의 배수들을 걸러주기 위한 반복문
            for(int j = i * i; j < prime.length; j = j+i) {

                prime[j] = false;
            }

        }

    }

}
