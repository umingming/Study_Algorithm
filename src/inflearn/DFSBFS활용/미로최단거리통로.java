package inflearn.DFSBFS활용;

import inflearn.재귀함수트리그래프.DFS;

public class 미로최단거리통로 {

    static int[][] board;
    static int result = Integer.MAX_VALUE;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void DFS() {
        DFS(0, 0, 0);
    }

    private static void DFS(int x, int y, int sum) {
        if (x == 6 && y == 6) {
            result = Math.min(result, sum);
        } else {
            for(int i=0; i<4; ++i) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX >= 0 && nextX <= 6 && nextY >= 0 && nextY <= 6 && board[nextX][nextY] == 0) {
                    board[nextX][nextY] = 1;
                    DFS(nextX, nextY, sum+1);
                    board[nextX][nextY] = 0;
                }

            }
        }
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

        DFS();
        System.out.println(result);
    }
}
