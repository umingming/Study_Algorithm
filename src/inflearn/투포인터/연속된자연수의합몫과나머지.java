package inflearn.투포인터;

public class 연속된자연수의합몫과나머지 {

    public int solution(int n) {

        int answer=0, cnt=1;
        n--;

        while(n>0) {
            cnt++;
            n-=cnt;
            if (n%cnt == 0) answer++;
        }

        return answer;

    }

    public static void main(String[] args) {
        연속된자연수의합몫과나머지 solution = new 연속된자연수의합몫과나머지();

        System.out.println(solution.solution(15));
    }

}
