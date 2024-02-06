package programmers.lv1;

public class 연속된수의합 {

    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int startPoint = 1;
        int result = Integer.MAX_VALUE;

        while (result != total) {
            result = 0;
            for (int i=0; i<num; ++i) {
                result+=startPoint+i;
            }

            if (result == total) {
                for(int i=0; i<num; ++i) {
                    answer[i] = startPoint+i;
                }
            } else {
                if (result < total) {
                    startPoint++;
                } else {
                    startPoint--;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        연속된수의합 solution = new 연속된수의합();
        for(int i : solution.solution(1, 500)) {
            System.out.print(i + " ");
        }
    }
}
