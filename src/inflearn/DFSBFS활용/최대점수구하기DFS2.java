package inflearn.DFSBFS활용;

import java.util.ArrayList;
import java.util.List;

/**
 * [설명]
 *
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
 * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 *
 *
 * [입력]
 * 첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
 * 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
 *
 * [출력]
 * 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
 *
 * [예시 입력 1]
 * n M
 * 5 20
 *
 * 점수 시간
 * 10 5
 * 25 12
 * 15 8
 * 6 3
 * 7 4
 */
public class 최대점수구하기DFS2 {

    static int m = 20;

    static class QuestionDTO {
        int score;

        int time;

        QuestionDTO(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }

    static int resultSum = 0;

    static List<QuestionDTO> questionDTOList = new ArrayList<>();

    public static void main(String[] args) {
        최대점수구하기DFS2 solution = new 최대점수구하기DFS2();
        questionDTOList.add(new QuestionDTO(10, 5));
        questionDTOList.add(new QuestionDTO(25, 12));
        questionDTOList.add(new QuestionDTO(15, 8));
        questionDTOList.add(new QuestionDTO(6, 3));
        questionDTOList.add(new QuestionDTO(7, 4));
        solution.DFS();
        System.out.println(resultSum);
    }

    private void DFS(int sum, int time, int L) {
        if (L == 5) {
            resultSum = Math.max(sum, resultSum);
            return;
        } else {
            QuestionDTO target = questionDTOList.get(L);
            // 자신을 포함하는 경우, 이때 자신을 포함했을 때 20이 넘으면 안되므로 체크한다.
            if (time + target.time <= 20) {
                DFS(sum + target.score, time + target.time, L + 1);
            }
            DFS(sum, time, L+1);
        }
    }

    private void DFS() {
        DFS(0, 0, 0);
    }


}
