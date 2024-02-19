package programmers.lv1;

public class 저주의숫자3 {
    public int solution(int n) {
        int result = 0;

        for(int i=1; i<=n; ++i) {
            result += 1;

            while (result / 10 == 13 || result / 10 == 3 || result%10 == 3 || result%3 == 0) {
                result += 1;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        저주의숫자3 solution = new 저주의숫자3();
        System.out.println(solution.solution(9));
    }
}
