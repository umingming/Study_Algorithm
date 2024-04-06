package inflearn.DFSBFS활용;

public class 미로탐색 {

    static int result = 0;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public void DFS(int x, int y) {

        if (x == 6 && y == 6) {
            result++;
        } else {
            for(int i=0; i<4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    DFS(nx, ny);
                    board[nx][ny] = 0;
                }
            }
        }

    }

    /**
     * 0 0 0 0 0 0 0
     * 0 1 1 1 1 1 0
     * 0 0 0 1 0 0 0
     * 1 1 0 1 0 1 1
     * 1 1 0 0 0 0 1
     * 1 1 0 1 1 0 0
     * 1 0 0 0 0 0 2
     */
    public static void main(String[] args) {
        미로탐색 solution = new 미로탐색();

        board = new int[][] { { 1, 0, 0, 0, 0, 0, 0 }
                            , { 0, 1, 1, 1, 1, 1, 0 }
                            , { 0, 0, 0, 1, 0, 0, 0 }
                            , { 1, 1, 0, 1, 0, 1, 1 }
                            , { 1, 1, 0, 0, 0, 0, 1 }
                            , { 1, 1, 0, 1, 1, 0, 0 }
                            , { 1, 0, 0, 0, 0, 0, 0 }
                            };

        solution.DFS(0, 0);
        System.out.println(result);
    }
}
