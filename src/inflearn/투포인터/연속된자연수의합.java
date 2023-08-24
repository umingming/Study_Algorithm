package inflearn.투포인터;

/**
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는
 * 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 * 와 같이 총 3가지의 경우가 존재한다.
 *
 * ▣ 입력설명
 * 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
 * ▣ 출력설명
 * 첫 줄에 총 경우수를 출력합니다.
 * ▣ 입력예제 1
 * 15
 * ▣ 출력예제 1
 * 3
 *
 * ▣ 풀이
 * 1. lt를 0에서 나누기2까지 돈다
 * 2. rt를 0에서 나누기2+1까지 돈다
 * 3. 이중 포문으로도 가능할 것 같은데?
 *
 */
public class 연속된자연수의합 {

    public int solution(int m) {

        long startTime = System.currentTimeMillis();

        int answer=0, lt=1, rt=0, sum=0;

        while(lt<m/2+1) {
            sum+=lt;
            rt=lt+1;
            while(sum<m) {
                sum+=rt;
                rt++;
            }
            if (sum==m) answer++;
            lt++;
            sum=0;
        }

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("메소드 실행 시간: " + elapsedTime + "밀리초");

        return answer;
    }

    public static void main(String[] args) {

        연속된자연수의합 solution = new 연속된자연수의합();
        int m = 10000000;

        solution.solution(m);

    }

}
