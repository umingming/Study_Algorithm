package baekjoon.b201;

import java.util.*;

/**
 * [문제]
 * 크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오등큰수 NGF(i)를 구하려고 한다.
 *
 * Ai가 수열 A에서 등장한 횟수를 F(Ai)라고 했을 때, Ai의 오등큰수는 오른쪽에 있으면서 수열 A에서 등장한 횟수가 F(Ai)보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
 * 그러한 수가 없는 경우에 오등큰수는 -1이다.
 *
 * 예를 들어, A = [1, 1, 2, 3, 4, 2, 1]인 경우 F(1) = 3, F(2) = 2, F(3) = 1, F(4) = 1이다.
 * A1의 오른쪽에 있으면서 등장한 횟수가 3보다 큰 수는 없기 때문에, NGF(1) = -1이다.
 * A3의 경우에는 A7이 오른쪽에 있으면서 F(A3=2) < F(A7=1) 이기 때문에, NGF(3) = 1이다. NGF(4) = 2, NGF(5) = 2, NGF(6) = 1 이다.
 *
 * [풀이]
 * 1. 돌면서 각 숫자들이 몇 번 선언 되었는지 확인해준다
 * 2. 그걸로 배열을 만든다
 * 3. 2번의 배열으로 오등큰수 알고리즘을 돌려보자
 */
public class Main {

    public static void main(String[] args) {

        int[] value = {1, 1, 2, 3, 4, 2, 1};

        Map<Integer, Integer> numberTypeMap = new HashMap<>();

        checkNumberCount(value, numberTypeMap);
        assignValue(value, numberTypeMap);

        Stack<Integer> stack = new Stack();

        stack.push(0);

        printValue(value);

//        for (int i=1; i<value.length; ++i) {
//            while ((!stack.isEmpty()) && value[stack.peek()] < value[i]) {
//                value[stack.pop()] = value[i];
//            }
//            stack.push(i);
//        }
//
//        while(!stack.isEmpty()) {
//            value[stack.pop()] = -1;
//        }
//
//        for(int i : value) {
//            System.out.println(i);
//        }


    }

    public static void printValue(int [] value) {

        for(int i : value) {
            System.out.println(i);
        }

    }

    private static void assignValue(int[] value, Map<Integer, Integer> numberTypeMap) {
        for (int i = 0; i< value.length; ++i) {
            if (numberTypeMap.containsKey(value[i])) {
                value[i] = numberTypeMap.get(value[i]);
            }
        }
    }

    private static void checkNumberCount(int[] value, Map<Integer, Integer> numberTypeMap) {
        for (int i = 0; i< value.length; ++i) {
            if(numberTypeMap.containsKey(value[i])) {
                int count = numberTypeMap.get(value[i]);
                numberTypeMap.put(value[i], count + 1);
            } else {
                numberTypeMap.put(value[i], 1);
            }
        }
    }

}
