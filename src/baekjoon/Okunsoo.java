package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Okunsoo {

    /*
            3 5 2 7
    * 1. Stack은 index를 저장해두는 공간이다.
    * 2. stack에 0이 들어간다
    *   2.1. number[0]이 5보다 작으므로 number[stack]은 i
    * */
    public static void main(String[] args) throws IOException {

//        3 5 2 7


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = "3 5 2 7";
        String[] sArr = temp.split(" ");
        Stack<Integer> stack = new Stack();

        int[] number = new int[sArr.length];
        int[] answer = new int[sArr.length];

        for (int j=0; j<answer.length; ++j) {
            answer[j] = -1;
        }

        number[0] = Integer.parseInt(sArr[0]);
        stack.push(0);

        for(int i=1; i<sArr.length; ++i) {

            int n = Integer.parseInt(sArr[i]);
            number[i] = n;

            while(!stack.isEmpty() && number[stack.peek()] < n) {
                answer[stack.pop()] = n;
            }
            stack.push(i);
        }

    }
}
