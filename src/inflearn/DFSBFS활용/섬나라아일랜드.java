package inflearn.DFSBFS활용;

import designpattern.templatemethod.Parent;
import inflearn.재귀함수트리그래프.DFS;

public class 섬나라아일랜드 {

    static int[][] board;
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, 1, -1, -1, 1, 1, -1};

    public static void DFS(int x, int y) {
        board[x][y] = 0;
        for(int i=0; i<dx.length; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] == 1) {
                DFS(nx, ny);
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
                    ++result;
                    DFS(i, j);
                }
            }
        }

        System.out.println(result);

    }
}
