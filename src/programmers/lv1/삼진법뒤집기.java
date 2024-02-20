package programmers.lv1;

/**
 * 자연수 n이 매개변수로 주어집니다
 * n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
 *
 * [생각해볼 것]
 * 1. 진법 변환을 어떻게 할 것인가
 */
public class 삼진법뒤집기 {

    public void convertTernary(int num, StringBuilder sb) {
        if (num == 0) {
            return;
        } else {
            convertTernary(num/3, sb);
            sb.append(num % 3);
        }
    }

    public int solution(int n) {
        int result = 0;
        StringBuilder sb = new StringBuilder();

        convertTernary(n, sb);
        String s = sb.reverse().toString();
        int pow = 0;

        for(int i=s.length()-1; i>=0; --i) {
            result += (int) ((s.charAt(i) - 48) * Math.pow(3, pow));
            pow++;
        }

        return result;
    }

    public static void main(String[] args) {
        삼진법뒤집기 solution = new 삼진법뒤집기();
        System.out.println(solution.solution(45));
    }

}
