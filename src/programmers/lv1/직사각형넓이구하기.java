package programmers.lv1;

public class 직사각형넓이구하기 {

    public int solution(int[][] dots) {
        int lowX = Math.min(dots[0][0], dots[1][0]);
        lowX = Math.min(lowX, dots[2][0]);
        lowX = Math.min(lowX, dots[3][0]);

        int highX = Math.max(dots[0][0], dots[1][0]);
        highX = Math.max(highX, dots[2][0]);
        highX = Math.max(highX, dots[3][0]);

        int lowY = Math.min(dots[0][1], dots[1][1]);
        lowY = Math.min(lowY, dots[2][1]);
        lowY = Math.min(lowY, dots[3][1]);

        int highY = Math.max(dots[0][1], dots[1][1]);
        highY = Math.max(highY, dots[2][1]);
        highY = Math.max(highY, dots[3][1]);

        return getNum(lowX, highX) * getNum(lowY, highY);
    }

    private int getNum(int low, int high) {
        return Math.abs(high - low);
    }

    private boolean swapCheck(int low, int high) {
        return low > high;
    }

    public static void main(String[] args) {
        직사각형넓이구하기 solution = new 직사각형넓이구하기();
        int[][] dots = new int[][]{{-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        System.out.println(solution.solution(dots));
    }
}

