package inflearn.재귀함수트리그래프;


/**
 * Stack
 *
 * 1. solution 호출 전 프린트
 *  1.1. num-1 호출 (이떄 스텍 프레임에 변수는 5)
 *  1.2. num-1 호출 (이떄 스텍 프레임에 변수는 4)
 *  1.3. num-1 호출 (이떄 스텍 프레임에 변수는 3)
 *  1.4. num-1 호출 (이떄 스텍 프레임에 변수는 2)
 *  1.5. 1 프린트
 *  1.6. 1.1. 스텍 프레임이 돌면서 찍음
 */

public class 재귀함수2 {

    public static void solution2(int num) {
        if (num <= 0) {
            return;
        } else {
            solution(num-1);
            System.out.println(num);
        }
    }

    public static void solution(int num) {
        if (num == 1) {
            System.out.println(num);
        } else {
            solution(num-1);
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
//        solution(5);
        solution2(5);
    }
}
