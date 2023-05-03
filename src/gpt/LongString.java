package gpt;

/**
 * 물론이죠! 백앤드 개발자가 입사 코딩 테스트에서 자주 출제되는 문제 유형 중 하나는 문자열 처리 문제입니다. 예를 들어, 다음과 같은 문제가 출제될 수 있습니다.
 *
 * 문자열 S가 주어졌을 때, S에서 반복되는 가장 긴 부분 문자열을 찾아서 출력하는 함수를 구현하세요.
 *
 * 예를 들어, 문자열 "ABCDABCDABDE"가 주어졌을 때, 반복되는 가장 긴 부분 문자열은 "ABCD"입니다. 따라서, 이 함수는 "ABCD"를 반환해야 합니다.
 *
 * - 맨 처음 글자를 StringBilder에 넣는다
 * - 그 다음 글자부터 끝까지 순회한다.
 * - 만약 들어가있는 글자의 제일 끝 숫자 +1이 본인일 경우 StringBuilder에 추가한다.
 * - 아닐 경우 sb와 result의 값을 비교하여 result보다 클 경우 result를 sb로 대체한다.
 */
public class LongString {

    public static void main(String[] args) {
        String s = "ABCDABCDABDE";

        String temp = String.valueOf(s.charAt(0));
        String result = "";

        for(int i=1; i<s.length(); ++i) {
            if(temp.charAt(temp.length()-1)+1 == s.charAt(i)) {
                temp += s.charAt(i);
                if(result.length() < temp.length()) {
                    result = temp;
                }
            } else {
                temp = String.valueOf(s.charAt(i));
            }
        }

        System.out.println(result);
    }
}
