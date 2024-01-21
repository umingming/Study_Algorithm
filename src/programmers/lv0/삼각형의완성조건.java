package programmers.lv0;


/**
 * [문제]
 * 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.
 *
 * 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
 * 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다.
 * 나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.
 *
 * [입출력 예]
 * 1,2 -> 1
 * 3, 6 -> 5
 * 11, 7 -> 13
 *
 * [풀이]
 * 1. 삼각형의 조건은 한 변의 길이가 나머지 두 변의 길이의 합보다 작아야한다 라는 것이다.
 * 2. sides로 들어온 값중 큰 값이 최대값이라는 경우를 상정한다
 *  2.1. max를 뽑아
 * 3. 나머지 될 수 있는 경우의 수가 최대 값이라는 것을 상정한다.
 *
 */
public class 삼각형의완성조건 {

    public static int solution(int[] sides) {
        int result = 0;

        return haveSidesMaxValueCase(sides) + haveNotSidesMaxValueCase(sides);
    }

    // 배열 안에 가장 큰 값이 있을 경우
    public static int haveSidesMaxValueCase(int[] sides) {

        int result = 0;

        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        int diff = max - min;

        result = max - (diff + 1);


        return result;
    }

    public static int haveNotSidesMaxValueCase(int[] sides) {
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);

        int result = 0;
        int count = max;
        while (count < max + min) {
            count++;
            result++;
        }



        return result;
    }


    public static void main(String[] args) {
        int[] sides = {1, 2};
        // 11이 가장 클 경우
        //
        System.out.println(solution(sides));
    }
}
