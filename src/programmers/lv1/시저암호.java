package programmers.lv1;

/**
 * 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
 * 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
 * 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
 *
 * 제한 조건
 * 공백은 아무리 밀어도 공백입니다.
 * s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
 * s의 길이는 8000이하입니다.
 * n은 1 이상, 25이하인 자연수입니다.
 *
 * a = 97
 * z = 122
 *
 * z-a = 25
 *
 * A = 65
 * Z = 90
 *
 */
public class 시저암호 {

    public String solution(String s, int n) {
        char[] charArray = s.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char c : charArray) {
            int target = c+n;

            if (c >= 'a' && c <= 'z') {
                while (target > 122) {
                    target -= 26;
                }
                result.append((char)target);
            } else if (c >= 'A' && c <= 'Z'){
                while (target > 90) {
                    target -= 26;
                }

                result.append((char) target);
            } else {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        시저암호 solution = new 시저암호();
        System.out.println(solution.solution("a B z", 4));

    }

}
