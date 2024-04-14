package inflearn.DFSBFS활용;

import java.util.LinkedList;
import java.util.Queue;

public class 토마토2 {

    static int[][] board, dis;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();

        for(int i=0; i<board.length; ++i) {
            for(int j=0; j<board[0].length; ++j) {
                if (board[i][j] == 1) {
                    dis[i][j] = 0;
                    queue.offer(new Point(i, j));
                } else if (board[i][j] == 0) {
                    dis[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point poll = queue.poll();

            for(int i=0; i<4; ++i) {
                int currentX = poll.x;
                int currentY = poll.y;

                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0
                    && nextX < board.length
                    && nextY >= 0
                    && nextY < board[0].length
                    && board[nextX][nextY] == 0
                    && dis[nextX][nextY] == -1
                ) {
                    board[nextX][nextY] = 1;
                    dis[nextX][nextY] = dis[currentX][currentY] + 1;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }

     }

    public static void main(String[] args) {
        board = new int[][] {
                  { 0, 0, -1, 0, 0, 0, }
                , { 0, 0, 1, 0, -1, 0 }
                , { 0, 0, -1, 0, 0, 0 }
                , { 0, 0, 0, 0, -1, 1 }
        };

        dis = new int[board.length][board[0].length];

        BFS();

        int result = 0;

        for(int i=0; i<dis.length; ++i) {
            for(int j=0; j<dis[0].length; ++j) {
                if (dis[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, dis[i][j]);
            }
        }

        System.out.println(result);
    }
}
