package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final char START = 'S';

    public static final char LEVER = 'L';

    public static final char EXIT = 'E';

    public static void main(String[] args) {
        미로탈출 solution = new 미로탈출();
        System.out.println(solution.solution(new String[] { "SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE" }));
    }

    public int solution(String[] maps) {
        int[] xNextArr = { 1, -1, 0, 0 };
        int[] yNextArr = { 0, 0, 1, -1 };

        int startToLever = bfs(maps, START, LEVER, xNextArr, yNextArr);
        if (startToLever == -1) {
            return -1;
        }

        int leverToExit = bfs(maps, LEVER, EXIT, xNextArr, yNextArr);
        if (leverToExit == -1) {
            return -1;
        }

        return startToLever + leverToExit;
    }

    private int bfs(String[] maps, char start, char target, int[] xNextArr, int[] yNextArr) {
        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == start) {
                    queue.add(new Point(j, i));
                    visited[i][j] = true;
                }
            }
        }

        int steps = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                Point point = queue.poll();

                if (maps[point.y].charAt(point.x) == target) {
                    return steps;
                }

                for (int j = 0; j < 4; j++) {
                    int nextX = point.x + xNextArr[j];
                    int nextY = point.y + yNextArr[j];

                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                        && maps[nextY].charAt(nextX) != 'X' && !visited[nextY][nextX]) {
                        queue.add(new Point(nextX, nextY));
                        visited[nextY][nextX] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
