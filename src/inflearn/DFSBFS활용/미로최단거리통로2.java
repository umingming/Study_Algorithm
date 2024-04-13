package inflearn.DFSBFS활용;

import java.util.LinkedList;
import java.util.Queue;

public class 미로최단거리통로2 {

    static int[][] board;
    static int[][] dis;

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

    public void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(1, 1));
        board[1][1] = 1;

        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            for(int i=0; i<4; ++i) {
                // current
                int cx = poll.x;
                int cy = poll.y;

                // next
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 1 && nx <= board.length-1 && ny >= 1 && ny <= board[0].length-1 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.add(new Point(nx, ny));
                    dis[nx][ny] = dis[cx][cy] + 1;
                }

            }

        }

    }

    public static void main(String[] args) {
        board = new int[][] {
                  { 0, 0, 0, 0, 0, 0, 0, 0 }
                , { 0, 1, 0, 0, 0, 0, 0, 0 }
                , { 0, 0, 1, 1, 1, 1, 1, 0 }
                , { 0, 0, 0, 0, 1, 0, 0, 0 }
                , { 0, 1, 1, 0, 1, 0, 1, 1 }
                , { 0, 1, 1, 0, 0, 0, 0, 1 }
                , { 0, 1, 1, 0, 1, 1, 0, 0 }
                , { 0, 1, 0, 0, 0, 0, 0, 0 }
        };
        dis = new int[board.length][board[0].length];

        미로최단거리통로2 solution = new 미로최단거리통로2();
        solution.BFS();

        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[dis.length-1][dis[0].length-1]);
        }
    }
}
