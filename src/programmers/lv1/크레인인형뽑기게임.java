package programmers.lv1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * [문제]
 * 게임개발자인 "죠르디"는 크레인 인형뽑기 기계를 모바일 게임으로 만들려고 합니다.
 * "죠르디"는 게임의 재미를 높이기 위해 화면 구성과 규칙을 다음과 같이 게임 로직에 반영하려고 합니다.
 *
 * 게임 화면은 "1 x 1" 크기의 칸들로 이루어진 "N x N" 크기의 정사각 격자이며 위쪽에는 크레인이 있고 오른쪽에는 바구니가 있습니다. (위 그림은 "5 x 5" 크기의 예시입니다). 각 격자 칸에는 다양한 인형이 들어 있으며 인형이 없는 칸은 빈칸입니다.
 * 모든 인형은 "1 x 1" 크기의 격자 한 칸을 차지하며 격자의 가장 아래 칸부터 차곡차곡 쌓여 있습니다.
 *
 * 게임 사용자는 크레인을 좌우로 움직여서 멈춘 위치에서 가장 위에 있는 인형을 집어 올릴 수 있습니다.
 * 집어 올린 인형은 바구니에 쌓이게 되는 데, 이때 바구니의 가장 아래 칸부터 인형이 순서대로 쌓이게 됩니다. 다음 그림은 [1번, 5번, 3번] 위치에서 순서대로 인형을 집어 올려 바구니에 담은 모습입니다.
 *
 * 만약 같은 모양의 인형 두 개가 바구니에 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 바구니에서 사라지게 됩니다. 위 상태에서 이어서 [5번] 위치에서 인형을 집어 바구니에 쌓으면 같은 모양 인형 두 개가 없어집니다.
 *
 * [입출력 예]
 * board
 * [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
 *
 * moves
 * [1,5,3,5,1,2,1,4]
 *
 * result
 * 4
 *
 * [풀이 방법]
 * 0. 최종적인 값을 쌓을 result 바구니 스텍을 만든다, 이후 board의 수만큼 Stack 리스트를 생성해준다.
 * 1. 각 바구니 별로 스텍을 board 각 스텍에 담는다.
 *  1.1. 뒤에서부터 담고 세로축으로 올라가면서 담아준다.
 * 2. moves를 돌면서 연산을 해준다.
 *  2.1. 선택된 바구니가 비었을 시 아무것도 안함
 *  2.2. 선택된 바구니에 값이 있을 시 result 바구니 체크
 *      2.2.1. result 바구니의 마지막 값과 값이 같으면 result 바구니와 선택된 바구니의 값을 모두 비워줌
 *      2.2.2. 다르면 result 바구니에 쌓아줌.
 *  3. moves가 끝나면 result 바구니의 사이즈 반환
 */
public class 크레인인형뽑기게임 {

    public static void main(String[] args) {
        크레인인형뽑기게임 solution = new 크레인인형뽑기게임();

        int[][] board = { { 0, 0, 0, 0, 0 },
                          { 0, 0, 1, 0, 3 },
                          { 0, 2, 5, 0, 1 },
                          { 4, 2, 4, 4, 2 },
                          { 3, 5, 1, 3, 1 } };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

        System.out.println(solution.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {

        // 0. 최종적인 값을 쌓을 result 바구니 스텍을 만든다.
        Stack<Integer> result = new Stack<>();

        int boomCount = 0;

        // 이후 board의 수만큼 Stack 리스트를 생성해준다.
        List<Stack<Integer>> bucketList = new ArrayList<>();
        for(int i=0; i<board.length+1; ++i) {
            bucketList.add(new Stack<>());
        }

        //각 바구니 별로 스텍을 board 각 스텍에 담는다. (뒤에서부터 담고 세로축으로 올라가면서 담아준다.)
        for(int i=0; i<board.length; i++) {
            for(int j=board.length-1; j>=0; --j) {
                if (board[j][i] != 0) {
                    bucketList.get(correctionBucket(i)).push(board[j][i]);
                }
            }
        }

        // moves를 돌면서 연산을 해준다.
        for(int x : moves) {
            // 바구니 선택
            Stack<Integer> bucket = bucketList.get(x);

            // 선택된 바구니가 비었을 시 아무것도 안함
            if (bucket.isEmpty()) {
                continue;
            } else {
                // 선택된 바구니에 값이 있을 시 result 바구니 체크
                if (result.empty()) {
                    result.push(bucket.pop());
                    continue;
                }

                Integer resultPeek = result.peek();

                // result 바구니의 마지막 값과 값이 같으면 result 바구니와 선택된 바구니의 값을 모두 비워줌
                Integer bucketPeek = bucket.peek();
                if (bucketPeek.equals(resultPeek)) {
                    bucket.pop();
                    result.pop();
                    boomCount+=2;
                } else {
                    result.push(bucket.pop());
                }
            }

        }
        return boomCount;
    }

    private int correctionBucket(int num) {
        return num+1;
    }

}
