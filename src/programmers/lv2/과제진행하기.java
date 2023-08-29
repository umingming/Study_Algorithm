package programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * 과제를 받은 루는 다음과 같은 순서대로 과제를 하려고 계획을 세웠습니다.
 *
 * 과제는 시작하기로 한 시각이 되면 시작합니다.
 * 새로운 과제를 시작할 시각이 되었을 때, 기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 새로운 과제를 시작합니다.
 * 진행중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 이어서 진행합니다.
 * 만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행합니다.
 * 멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다.
 * 과제 계획을 담은 이차원 문자열 배열 plans가 매개변수로 주어질 때, 과제를 끝낸 순서대로 이름을 배열에 담아 return 하는 solution 함수를 완성해주세요.
 *
 * [["korean", "11:40", "30"], ["english", "12:10", "20"], ["math", "12:30", "40"]]	["korean", "english", "math"]
 * [["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"], ["computer", "12:30", "100"]]	["science", "history", "computer", "music"]
 * [["aaa", "12:00", "20"], ["bbb", "12:10", "30"], ["ccc", "12:40", "10"]]	["bbb", "ccc", "aaa"]
 *
 * 0. watingStack을 선언한다.
 * 1. 다음 과목의 진행 시간과 현재 과목의 진행 시간을 뺀 값을 구한다. (timeLine)
 *  1.1. 그 값이 현재 과목의 진행 시간보다 크거나 같다면
 *      1.1. 현재 과목을 끝내고 answer에 넣는다.
 *      1.2. watingStack을 확인해서 값이 있으면 해당 작업을 수행한다.
 *  1.2. 그 값이 현재 과목의 진행 시간보다 작다면
 *      1.1. 현재 과목의 남은 시간에서 그 값을 뺴준다.
 *      1.2. Stack에 넣는다.
 *
 */
public class 과제진행하기 {

    public String[] solution(String[][] plans) {

        Arrays.sort(plans, Comparator.comparing(subject -> subject[1]));

        String[] answer = new String[plans.length];
        int answerPointer = 0;
        Stack<String[]> watingStack = new Stack<>();

        for(int i=0; i<plans.length-1; ++i) {
            int timeLine = 0;
            int currentHour = Integer.parseInt(plans[i][1].split(":")[0]);
            int currentMin = Integer.parseInt(plans[i][1].split(":")[1]);

            int nextHour = Integer.parseInt(plans[i+1][1].split(":")[0]);
            int nextMin = Integer.parseInt(plans[i+1][1].split(":")[1]);

            timeLine += (nextHour*60 + nextMin) - (currentHour*60 + currentMin);


            if (timeLine >= Integer.parseInt(plans[i][2])) {
                answer[answerPointer++] = plans[i][0];
                timeLine -= Integer.parseInt(plans[i][2]);

                while(timeLine != 0 && !watingStack.isEmpty()) {
                    if (Integer.parseInt(watingStack.peek()[2]) <= timeLine) {
                        timeLine -= Integer.parseInt(watingStack.peek()[2]);
                        answer[answerPointer++] = watingStack.pop()[0];
                    } else {
                        watingStack.peek()[2] = String.valueOf(Integer.parseInt(watingStack.peek()[2]) - timeLine);
                        timeLine = 0;
                    }
                }
            } else {
                plans[i][2] = String.valueOf(Integer.parseInt(plans[i][2]) - timeLine);
                timeLine = 0;
                watingStack.push(plans[i]);
            }
        }



        answer[answerPointer++] = plans[plans.length-1][0];

        while(!watingStack.isEmpty()) answer[answerPointer++] = watingStack.pop()[0];

        return answer;

    }

    public static void main(String[] args) {
        과제진행하기 solution = new 과제진행하기();
        String[][] arr = {{"A", "12:00", "30"}, {"B", "12:10", "20"}, {"C", "15:00", "40"}, {"D", "15:10", "30"}};
        for(String s : solution.solution(arr)) {
            System.out.print(s + " ");
        }

    }

}
