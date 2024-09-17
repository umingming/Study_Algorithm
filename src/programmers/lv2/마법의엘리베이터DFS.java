package programmers.lv2;

public class 마법의엘리베이터DFS {

    public int solution(int storey) {
        return DFS(0, storey);
    }

    public int DFS(int sum, int storey) {
        if (storey == 0) {
            return sum;
        } else {
            int currentDigit = storey % 10;
            int nextDigit = (storey / 10) % 10;

            if (currentDigit > 5 || (currentDigit == 5 && nextDigit >= 5)) {
                return DFS(sum+(10-currentDigit), (storey+10)/10);
            } else {
                return DFS(sum+currentDigit, storey/10);
            }
        }
    }

    public static void main(String[] args) {
        마법의엘리베이터DFS solution = new 마법의엘리베이터DFS();
        System.out.println(solution.solution(2554));
    }
}
