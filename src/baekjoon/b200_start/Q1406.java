package baekjoon.b200_start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * [문제]
 * 한 줄로 된 간단한 에디터를 구현하려고 한다. 이 편집기는 영어 소문자만을 기록할 수 있는 편집기로, 최대 600,000글자까지 입력할 수 있다.
 * 이 편집기에는 '커서'라는 것이 있는데, 커서는 문장의 맨 앞(첫 번째 문자의 왼쪽), 문장의 맨 뒤(마지막 문자의 오른쪽), 또는 문장 중간 임의의 곳(모든 연속된 두 문자 사이)에 위치할 수 있다.
 * 즉 길이가 L인 문자열이 현재 편집기에 입력되어 있으면, 커서가 위치할 수 있는 곳은 L+1가지 경우가 있다.
 * 이 편집기가 지원하는 명령어는 다음과 같다.
 * <p>
 * L  : 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
 * D  : 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
 * B  : 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
 * 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
 * P $: $라는 문자를 커서 왼쪽에 추가함
 * <p>
 * [풀이 1]
 * 1. 버퍼 선언
 * 2. 문자 변수 temp를 버퍼로 입력 받는다.
 * 3. 숫자 변수 count 버퍼로 입력 받는다.
 * 4. 숫자 변수 index를 선언한다. 최초값은 temp.length이다.
 * 5. 숫자만큼 for문을 돌아준다.
 * > 값을 입력 받는다
 * > L일 시
 * > index = 1이 아니면 index = index-1
 * > D 일 시
 * > index = temp.length가 아니면 index = index + 1;
 * > temp.startWith가 P일 시
 * > temp = temp.substring(0, index-1) + P + temp.substring(index-1);
 * <p>
 * [시간 초과...]
 * <p>
 * [풀이 2]
 * 1. 버퍼 선언
 * 2. 문자 변수 input을 버퍼로 입력 받는다.
 * 3. 숫자 변수 count 버퍼로 입력 받는다.
 * 4. 커서를 기준으로 leftStack과 rightStack 선언
 * > leftStack에는 모든 문자열을 다 넣는다 (input.charAt)
 * 5. count만큼 for문을 돌아준다.
 *  > 커맨드 받아줌
 *  > L일 시
 *      > leftStack이 비지 않았으면
 *      > rightStack에 leftStack값을 pop하여 push한다.
 *  > D일 시
 *      > rightStack이 비지 않았으면
 *      > leftStack에 rightStack값을 pop하여 push한다.
 *  > B일 시
 *      > leftStack이 비지 않았으면
 *      > leftStack의 값을 pop한다.
 *  > command[0]가 P일 시
 *      > input[1]을 push해준다.
 * 6. rightStack에 leftStack을 모두 push해준다.
 */
public class Q1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String[] inputArray = input.split("");
        int count = Integer.parseInt(reader.readLine());

        Stack<String> leftStack = new Stack();
        Stack<String> rightStack = new Stack();

        for (int i = 0; i < input.length(); ++i) {
            leftStack.push(inputArray[i]);
        }

        for (int i = 0; i < count; ++i) {

            String[] commandArray = reader.readLine().split(" ");

            switch (commandArray[0]) {
                case "L":
                    if (!leftStack.empty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D":
                    if (!rightStack.empty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B":
                    if (!leftStack.empty()) {
                        leftStack.pop();
                    }
                    break;
                case "P":
                    leftStack.push(commandArray[1]);
                    break;
            }
        }

        while (!leftStack.empty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.empty()) {
            System.out.print(rightStack.pop());
        }


    }

}
