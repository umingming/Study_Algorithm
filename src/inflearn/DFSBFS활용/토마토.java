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
 *
 * 1. 익은 토마토가 있는 좌표값을 넣은 큐를 만든다
 * 2. 익지 않은 토마토가 있는 좌표값은 넣은 큐를 만든다.
 * 3. 날짜를 체킹하기 위한 dis 배열을 만든다.
 *  3.1. 이때 dis 배열의 수는 토마토의 수와 동일하다.
 * 4. BFS를 쭉쭉 돌려준다
 *  4.1. 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
 * 5. 익지 않은 토마토가 있는 dis 좌표값을 확인한다.
 * 6. 값을 출력한다.
 *  6.1. 익지 않은 토마토가 있는 좌표값의 큐가 비었으면 0 출력
 *  6.2. 최솟값이 0이면 -1 출력 (토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.)
 *  6.3. 아니면 최솟값 출력
 */
public class 토마토 {

    static int[][] board;
    static int[][] dis;

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

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();


        for(int i=0; i<board.length; ++i) {
            for(int j=0; j<board[0].length; ++j) {
                if (board[i][j] == 1) {
                    queue.offer(new Point(i, j));
                    dis[i][j] = 0;
                } else if (board[i][j] == 0) {
                    dis[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for(int i=0; i<4; ++i) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 0 && dis[nx][ny] == -1) {
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[current.x][current.y] + 1;
                    queue.add(new Point(nx, ny));
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

        int maxDays = 0;
        for (int[] row : dis) {
            for (int day : row) {
                if (day == -1) {
                    System.out.println(-1);
                    return;
                }
                maxDays = Math.max(maxDays, day);
            }
        }

        System.out.println(maxDays);


    }
}
