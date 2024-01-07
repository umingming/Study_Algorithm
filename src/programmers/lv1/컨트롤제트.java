package programmers.lv1;


/**
 * 숫자와 "Z"가 공백으로 구분되어 담긴 문자열이 주어집니다.
 * 문자열에 있는 숫자를 차례대로 더하려고 합니다.
 * 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다.
 * 숫자와 "Z"로 이루어진 문자열 s가 주어질 때,
 * 머쓱이가 구한 값을 return 하도록 solution 함수를 완성해보세요.
 *
 * [풀이]
 * 1. 스플릿으로 쪼갬
 * 2. for문을 0부터 .length-1까지 돔
 *  2.1. 만약 i+1이 "z"가 아니면 더해줌.
 */
public class 컨트롤제트 {

    public int solution(String s) {
        int answer = 0;

        String[] stringList = s.split(" ");

        for(int i=0; i<stringList.length-1; ++i) {
            if (!stringList[i].equals("Z") && !stringList[i+1].equals("Z")) {
                answer += Integer.parseInt(stringList[i]);
            }
        }

        String last = stringList[stringList.length - 1];
        if (!last.equals("Z")) {
            answer+=Integer.parseInt(last);
        }

        return answer;
    }

    public static void main(String[] args) {
        컨트롤제트 solution = new 컨트롤제트();
        System.out.println(solution.solution("1 2 Z 3"));
    }

}
