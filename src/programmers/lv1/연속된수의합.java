package programmers.lv1;

public class 연속된수의합 {

    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        int check = num*(num+1) / 2;
        int start = (total - check) / num + 1;

        for(int i=0; i<num; ++i) {
            answer[i] = start+i;
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
