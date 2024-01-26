package programmers.lv0;

/**
 * [[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]
 * 다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
 *
 * 1. 배열을 아래위로 1반씩 좌우로 1칸씩 늘려준다.
 * 1. 순회하면서 1인 값들을
 * 2. 순회하면서 0인 값들을 찾는다.
 */
public class 안전지대 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0}
        }));
    }

    public static int solution(int[][] board) {
        int answer = 0;

        int[][] newBoard = new int[board.length+2][board.length+2];

        copyBoard(board, newBoard);
        checkMine(newBoard);


        for(int i=1; i<newBoard.length-1; ++i) {
            for(int j=1; j<newBoard.length-1; ++j) {
                if (newBoard[j][i] == 0) {
                    answer++;
                }
            }

        }


        return answer;
    }

    public static void copyBoard(int[][] board, int[][] newBoard) {
        for(int i=0; i<board.length; ++i) {
            for(int j=0; j<board[0].length; ++j) {
                newBoard[i+1][j+1] = board[i][j];
            }
        }
    }

    public static void checkMine(int[][] board) {
        for(int i=1; i<board.length-1; ++i) {

            for(int j=1; j<board[0].length-1; ++j) {

                if (board[i][j] == 1) {

                    if (board[i+1][j] == 0) {
                        board[i+1][j] = 2;
                    }

                    if (board[i+1][j-1] == 0) {
                        board[i+1][j-1] = 2;
                    }

                    if (board[i+1][j+1] == 0) {
                        board[i+1][j+1] = 2;
                    }

                    if (board[i][j-1] == 0) {
                        board[i][j-1] = 2;
                    }

                    if (board[i][j+1] == 0) {
                        board[i][j+1] = 2;
                    }

                    if (board[i-1][j] == 0) {
                        board[i-1][j] = 2;
                    }

                    if (board[i-1][j-1] == 0) {
                        board[i-1][j-1] = 2;
                    }

                    if (board[i-1][j+1] == 0) {
                        board[i-1][j+1] = 2;
                    }

                }

            }

        }
    }

}
