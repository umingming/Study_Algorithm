package inflearn.DFSBFS활용;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 현수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
 * 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
 *
 * 창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면,
 * 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
 * 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,
 *
 * 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 현수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
 * 토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
 * 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.
 *
 * 0 0 -1 0 0 0
 * 0 0 1 0 -1 0
 * 0 0 -1 0 0 0
 * 0 0 0 0 -1 1
 */
public class 토마토 {

    static int[][] board;

    static int[] dx = { 0, 0, 1, -1 };

    static int[] dy = { 1, -1, 0, 0 };

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

        Queue<Point> queue = new LinkedList();
        Queue<Point> checkQueue = new LinkedList();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 1) {
                    queue.offer(new Point(i, j));
                } else if (board[i][j] == 0) {
                    checkQueue.offer(new Point(i, j));
                }
            }
        }

        boolean resultCheck = true;

        while (!queue.isEmpty()) {

            // 하나라도 안익은 게 있으면 안됨
            // false로 바꿔준다?
            // 안익은게 하나라도 있으면 안됨
            for (Point point : checkQueue) {
                if (board[point.x][point.y] == 0) {
                    resultCheck = false;
                    break;
                }
            }

            // 다 익었으면
            if (resultCheck) {
                return L;
            }

            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                Point poll = queue.poll();

                for(int j=0; j<4; ++j) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];

                    if (nx >= 0 && nx < board[0].length && ny >= 0 && ny < board.length && board[ny][nx] != -1) {
                        board[ny][nx] = 1;
                        queue.add(new Point(nx, ny));
                    }

                }

            }

            L++;
            resultCheck = true;

            if (L > 30) {
                return -1;
            }

        }

        return L;

    }

    public static void main(String[] args) {
        board = new int[][] {
                { 0, 0, -1, 0, 0, 0, }
                , { 0, 0, 1, 0, -1, 0 }
                , { 0, 0, -1, 0, 0, 0 }
                , { 0, 0, 0, 0, -1, 1 }
        };
        System.out.println(BFS());


    }
}
