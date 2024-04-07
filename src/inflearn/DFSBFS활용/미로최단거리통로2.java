package inflearn.DFSBFS활용;

import java.util.LinkedList;
import java.util.Queue;

public class 미로최단거리통로2 {

    static int[][] board;

    static int[] dx = {1, 0, -1, 0};

    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x;

        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int BFS() {
        int L = 0;
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0; i<size; ++i) {
                Point poll = queue.poll();

                if (poll.x == 6 && poll.y == 6) {
                    return L;
                }
                for(int j=0; j<4; ++j) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];

                    if (nx >= 0 && nx <= 6 & ny >= 0 && ny <= 6 && board[nx][ny] != 1) {
                        queue.add(new Point(nx, ny));
                    }
                }
            }

            L++;

        }

        return L;

    }

    public static void main(String[] args) {
        board = new int[][] { { 1, 0, 0, 0, 0, 0, 0 }
                , { 0, 1, 1, 1, 1, 1, 0 }
                , { 0, 0, 0, 1, 0, 0, 0 }
                , { 1, 1, 0, 1, 0, 1, 1 }
                , { 1, 1, 0, 0, 0, 0, 1 }
                , { 1, 1, 0, 1, 1, 0, 0 }
                , { 1, 0, 0, 0, 0, 0, 0 }
        };
        System.out.println(BFS());
    }
}
