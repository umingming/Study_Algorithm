package baekjoon.b200_start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * [스택 수열]
 * 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때 자주 이용되는 개념이다.
 * 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop) 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
 *
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
 * 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
 * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지, 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
 * 이를 계산하는 프로그램을 작성하라.

 * [풀이]
 * 1. 스텍 선언
 * 2. count 변수로 값을 할당해준다.
 * 3. count 수만큼 for문을 돌면서 int 배열에 할당해준다
 * 4. for문을 돌면서 int[i]에 대한 판별을 해준다.
 * 5. Stack에 push 해줄 int 변수를 선언해준다.
 *  > 경우 1 스텍이 비었을 때
 *      > push, append +
 *  > 경우 2 stack.peek이 < arr[i]
 *      > push, append +
 *  > 경우 3 stack.peek이 > arr[i]
 *      > sb clear 후 NO 출력
 *  > 경우 4 stack.peek이 == arr[i]
 *      > pop append -
 */
public class Q1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int count = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        int number = 1;
        int [] inputValue = new int[count];


        for(int j = 0; j < count; ++j) {
            inputValue[j] = Integer.parseInt(reader.readLine());
        }


        for (int i = 0; i < inputValue.length ;) {

                if (stack.empty() || stack.peek() < inputValue[i]) {
                    stack.push(number);
                    sb.append("+\n");
                    number++;
                } else if (stack.peek() == inputValue[i]) {
                    stack.pop();
                    sb.append("-\n");
                    ++i;
                } else if (stack.peek() > inputValue[i]) {
                    stack.clear();
                    sb.delete(0, sb.length());
                    sb.append("NO");
                    break;
                }


        }

        System.out.print(sb);

    }
}
