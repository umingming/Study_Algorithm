package programmers.lv1;

/**
 * [풀이]
 *
 */
public class 최대공약수와최소공배수 {

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = getGcd(n, m);
        answer[1] = (n * m) / answer[0];
        return answer;
    }

    public int getGcd(int a, int b) {
        int r = Integer.MAX_VALUE;
        while (r != 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    public static void main(String[] args) {
        최대공약수와최소공배수 solution = new 최대공약수와최소공배수();
        for(int i : solution.solution(1, 2)) {
            System.out.print(i + " -> ");
        }

    }

}
