package baekjoon.b300_math;

/**
 *
 * [문제]
 * 두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 *
 * [출력]
 * 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 *
 * [입력 1]
 * 24 18
 *
 * [결과 1]
 * 6
 * 72
 *
 */
public class Q2609V2 {

    public static void main(String[] args) {

        int a = 9;
        int b = 54;

        System.out.println("gcd: " + gcd(a, b));
        System.out.println("lcm: " + lcm(a, b));
    }

    public static int gcd(int a, int b) {

        while(b != 0) {

            int r = a%b;
            a = b;
            b = r;

        }

        return a;

    }

    public static int lcm(int a, int b) {
        return a*b/gcd(a, b);
    }


}
