package programmers.lv1;

public class 나머지가1이되는수찾기 {

    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<n; ++i) {
            if (n%i == 1) return i;
        }

        return answer;
    }

    public static void main(String[] args) {
        나머지가1이되는수찾기 solution = new 나머지가1이되는수찾기();
        System.out.println(solution.solution(10));

    }

}
