package inflearn.DFSBFS활용;

import java.util.LinkedList;
import java.util.Queue;

public class 섬나라아일랜드BFS {

    static int[][] board, dis;
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};
    static Queue<Point> queue = new LinkedList<>();

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int x, int y) {
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for(int i=0; i<dx.length; ++i) {

                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx >= 0
                && nx < board.length
                && ny >= 0
                && ny < board[0].length
                && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.add(new Point(nx, ny));
                }

            }
        }
    }

    public static void main(String[] args) {
        board = new int[][] {
                { 1, 1, 0, 0, 0, 1, 0 }
                ,{ 0, 1, 1, 0, 1, 1, 0 }
                ,{ 0, 1, 0, 0, 0, 0, 0 }
                ,{ 0, 0, 0, 1, 0, 1, 1 }
                ,{ 1, 1, 0, 1, 1, 0, 0 }
                ,{ 1, 0, 0, 0, 1, 0, 0 }
                ,{ 1, 0, 1, 0, 1, 0, 0 }
        };


        int result = 0;

        for(int i=0; i<board.length; ++i) {
            for(int j=0; j<board[0].length; ++j) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    BFS(i, j);
                    result++;
                }


            }
        }

        System.out.println(result);

    }


}
