package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

/**
 * 나만의 카카오 성격 유형 검사지를 만들려고 합니다.
 * 성격 유형 검사는 다음과 같은 4개 지표로 성격 유형을 구분합니다. 성격은 각 지표에서 두 유형 중 하나로 결정됩니다.
 *
 * 지표 번호	성격 유형
 * 1번 지표	라이언형(R), 튜브형(T)
 * 2번 지표	콘형(C), 프로도형(F)
 * 3번 지표	제이지형(J), 무지형(M)
 * 4번 지표	어피치형(A), 네오형(N)
 * 4개의 지표가 있으므로 성격 유형은 총 16(=2 x 2 x 2 x 2)가지가 나올 수 있습니다. 예를 들어, "RFMN"이나 "TCMA"와 같은 성격 유형이 있습니다.
 *
 * 검사지에는 총 n개의 질문이 있고, 각 질문에는 아래와 같은 7개의 선택지가 있습니다.
 *
 * 매우 비동의
 * 비동의
 * 약간 비동의
 * 모르겠음
 * 약간 동의
 * 동의
 * 매우 동의
 * 각 질문은 1가지 지표로 성격 유형 점수를 판단합니다.
 *
 * 예를 들어, 어떤 한 질문에서 4번 지표로 아래 표처럼 점수를 매길 수 있습니다.
 *
 * 선택지	성격 유형 점수
 * 매우 비동의	네오형 3점
 * 비동의	네오형 2점
 * 약간 비동의	네오형 1점
 * 모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
 * 약간 동의	어피치형 1점
 * 동의	어피치형 2점
 * 매우 동의	어피치형 3점
 * 이때 검사자가 질문에서 약간 동의 선택지를 선택할 경우 어피치형(A) 성격 유형 1점을 받게 됩니다. 만약 검사자가 매우 비동의 선택지를 선택할 경우 네오형(N) 성격 유형 3점을 받게 됩니다.
 *
 * 위 예시처럼 네오형이 비동의, 어피치형이 동의인 경우만 주어지지 않고, 질문에 따라 네오형이 동의, 어피치형이 비동의인 경우도 주어질 수 있습니다.
 * 하지만 각 선택지는 고정적인 크기의 점수를 가지고 있습니다.
 *
 * 매우 동의나 매우 비동의 선택지를 선택하면 3점을 얻습니다.
 * 동의나 비동의 선택지를 선택하면 2점을 얻습니다.
 * 약간 동의나 약간 비동의 선택지를 선택하면 1점을 얻습니다.
 * 모르겠음 선택지를 선택하면 점수를 얻지 않습니다.
 * 검사 결과는 모든 질문의 성격 유형 점수를 더하여 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격 유형이라고 판단합니다. 단, 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단합니다.
 *
 * 질문마다 판단하는 지표를 담은 1차원 문자열 배열 survey와 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열 choices가 매개변수로 주어집니다. 이때, 검사자의 성격 유형 검사 결과를 지표 번호 순서대로 return 하도록 solution 함수를 완성해주세요.
 *
 * [입력 예제]
 * survey	                        choices	            result
 * ["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	    "TCMA"
 * ["TR", "RT", "TR"]	            [7, 1, 3]	        "RCJA"
 *
 * [풀이]
 * 1. Map에 Map을 넣는다. (Map<String, Map<String, Integer>)
 *  1.1. key = RT, CF, JM, AN value = map
 *      1.1.1. key = R, 값 | T, 값 등
 * 2. survey를 잘라서 값이 무엇인지 판단하고 넣어준다.
 *  2.1. 첫번째 값이 비동의 점수 두번째 값이 동의 점수
 *  2.2. 1. 매우 비동의, 2. 동의, 3. 약간 비동의, 4. 모르겠음, 5. 약간 동의, 6. 동의, 7. 매우 동의
 *  2.3. 매우 = 3점 동의격 = 2점 약간 = 1점
 *
 *
 *
 */
public class 성격유형검사 {

    public static void main(String[] args) {

    }

    public String solution(String[] survey, int[] choices) {

        Map<String, Map<Character, Integer>> map = new HashMap<>();

        map.put("RT", new HashMap<>());
        map.put("CF", new HashMap<>());
        map.put("JM", new HashMap<>());
        map.put("AN", new HashMap<>());

        for(int i=0; i<survey.length; ++i) {

            if (survey[i].equals("RT") || survey[i].equals("TR")) {
                if (choices[i] == 1) map.get("RT").put(survey[i].charAt(0), 3);
                else if (choices[i] == 2) map.get("RT").put(survey[i].charAt(0), 2);
                else if (choices[i] == 3) map.get("RT").put(survey[i].charAt(0), 1);
                else if (choices[i] == 5) map.get("RT").put(survey[i].charAt(1), 1);
                else if (choices[i] == 6) map.get("RT").put(survey[i].charAt(1), 2);
                else if (choices[i] == 7) map.get("RT").put(survey[i].charAt(1), 3);
            } else if (survey[i].equals("CF") || survey[i].equals("FC")) {
                if (choices[i] == 1) map.get("CF").put(survey[i].charAt(0), 3);
                else if (choices[i] == 2) map.get("CF").put(survey[i].charAt(0), 2);
                else if (choices[i] == 3) map.get("CF").put(survey[i].charAt(0), 1);
                else if (choices[i] == 5) map.get("CF").put(survey[i].charAt(1), 1);
                else if (choices[i] == 6) map.get("CF").put(survey[i].charAt(1), 2);
                else if (choices[i] == 7) map.get("CF").put(survey[i].charAt(1), 3);
            } else if (survey[i].equals("JM") || survey[i].equals("MJ")) {
                if (choices[i] == 1) map.get("JM").put(survey[i].charAt(0), 3);
                else if (choices[i] == 2) map.get("JM").put(survey[i].charAt(0), 2);
                else if (choices[i] == 3) map.get("JM").put(survey[i].charAt(0), 1);
                else if (choices[i] == 5) map.get("JM").put(survey[i].charAt(1), 1);
                else if (choices[i] == 6) map.get("JM").put(survey[i].charAt(1), 2);
                else if (choices[i] == 7) map.get("JM").put(survey[i].charAt(1), 3);
            } else {
                if (choices[i] == 1) map.get("AN").put(survey[i].charAt(0), 3);
                else if (choices[i] == 2) map.get("AN").put(survey[i].charAt(0), 2);
                else if (choices[i] == 3) map.get("AN").put(survey[i].charAt(0), 1);
                else if (choices[i] == 5) map.get("AN").put(survey[i].charAt(1), 1);
                else if (choices[i] == 6) map.get("AN").put(survey[i].charAt(1), 2);
                else if (choices[i] == 7) map.get("AN").put(survey[i].charAt(1), 3);
            }
        }

        String result = "";
        if (map.get("RT").get('R') > map.get("RT").get('T') && map.get("RT").get('R') == map.get("RT").get('T')) {
            result = result + "R";
        } else {
            result = "T";
        }

        if (map.get("CF").get('C') > map.get("CF").get('F') && map.get("CF").get('C') == map.get("CF").get('T')) {
            result = result + "C";
        } else {
            result = "F";
        }

        if (map.get("JM").get('J') > map.get("JM").get('M') && map.get("JM").get('J') == map.get("JM").get('M')) {
            result = result + "J";
        } else {
            result = "M";
        }

        if (map.get("AM").get('A') > map.get("AM").get('M') && map.get("AM").get('A') == map.get("AM").get('M')) {
            result = result + "A";
        } else {
            result = "M";
        }

        return result;

    }

}
