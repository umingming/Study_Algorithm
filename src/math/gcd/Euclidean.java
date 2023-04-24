package math.gcd;

public class Euclidean {

    public static void main(String[] args) {

        int a = 182;
        int b = 1114;

        System.out.println(gcd(a, b));
        System.out.println(lcd(a, b));


    }

    /**
     * if (A > B) {
     *     A % B = r;
     * }
     *
     * gcd(a, b) == gcd(b, r);
     *
     * 두 정수 A와 B가 있을 때 (A > B) A를 B로 나눈 나머지 수를 r이라고 하자.
     * A와 B의 GCD와 B와 r의 GCD는 동일하다.
     * A = aG, B = bG (a, b는 서로소(공약수가 없다.))

     * A / B = q;
     * A % B = r
     * A = B*q + r
     * aG = bG*q + r
     * r = aG - qbG
     * r = (a-qb)g;, B=bG
     *
     * 부정
     * a-qb = mP, b = nP
     * a-q*np = mp
     * a = (nq+m)p
     * b = np
     */

    /**
     * 두 자연수 a와 b의 최대공약수를 g라고 하면, g는 a와 b의 공통된 약수 중 가장 큰 수입니다.
     * 그렇다면, a와 b를 각각 g로 나누었을 때의 나머지는 0이 될 것입니다.
     *
     * 즉, a = g * m, b = g * n (단, m과 n은 자연수)으로 나타낼 수 있습니다.
     * 이 때, a와 b를 연속적으로 나누어가며 나머지를 구하는 과정에서 나머지가 0이 되는 최초의 단계에서 사용한 나머지는 a와 b의 공통된 약수 중 가장 큰 수인 g일 것입니다.
     *
     * 왜냐하면, 최초의 나머지는 a를 b로 나눈 나머지이고, 나중에는 이전 단계의 b를 나눈 나머지이므로, 이전 단계에서의 나머지는 b의 약수이며, a와 b의 공통된 약수가 됩니다.
     *
     * 이 과정을 반복하여 최종적으로 나머지가 0이 되는 순간의 b가 두 수의 최대공약수이기 때문에, 두 자연수를 연속적으로 나누어가며 최종적으로 나머지가 0이 되는 값을 찾는 것입니다.
     *
     * 따라서, 두 자연수를 연속적으로 나누었을 때 나머지가 0이 된 값이 최대공약수인 이유는, 그 값이 a와 b의 공통된 약수 중 가장 큰 수이기 때문입니다.

     */
    public static int gcd(int a, int b) {

        //18 14 -> 4
        //14 4  -> 2
        //4  2  -> 0
        //2가 최대 공약수

        int r = a % b;

        while(r!=0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    public static int lcd(int a, int b) {
        return a * b / gcd(a, b);
    }

}
