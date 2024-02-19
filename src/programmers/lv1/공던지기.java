package programmers.lv1;

/**
 * 머쓱이는 친구들과 동그랗게 서서 공 던지기 게임을 하고 있습니다.
 * 공은 1번부터 던지며 오른쪽으로 한 명을 건너뛰고 그다음 사람에게만 던질 수 있습니다.
 * 친구들의 번호가 들어있는 정수 배열 numbers와 정수 K가 주어질 때, k번째로 공을 던지는 사람의 번호는 무엇인지 return 하도록 solution 함수를 완성해보세요.
 *
 * [풀이]
 * [1, 2, 3, 4]가 있다고 했을 때
 *
 */
public class 공던지기 {

    public int solution(int[] numbers, int k) {
        int index = 0;

        for(int i=0; i<k-1; ++i) {
            if (index + 2 <= numbers.length-1) {
                index = index + 2;
            } else {
                if (numbers.length % 2 == 0) {
                    index = 0;
                } else {
                    if (index == numbers.length -2) {
                        index = 0;
                    } else {
                        index = 1;
                    }
                }
            }

        }

        return numbers[index];
    }

    public static void main(String[] args) {
        공던지기 soltuion = new 공던지기();
        System.out.println(soltuion.solution(new int[]{1, 2, 3, 4, 5, 6}, 5));
    }

}
