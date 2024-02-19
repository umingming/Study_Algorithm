package programmers.lv1;

public class 정수제곱근판별 {

    public long solution(long n) {
        for(int i=1; i<=Math.sqrt(n); ++i) {
            if ((long) i * i == n) {
                return (long) Math.pow(i + 1, 2);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        정수제곱근판별 soltuion = new 정수제곱근판별();
        System.out.println(soltuion.solution(121));
    }
}
