package inflearn.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 설명
 *
 * 현수는 씨름 감독입니다. 현수는 씨름 선수를 선발공고를 냈고, N명의 지원자가 지원을 했습니다.
 * 현수는 각 지원자의 키와 몸무게 정보를 알고 있습니다.
 * 현수는 씨름 선수 선발 원칙을 다음과 같이 정했습니다.
 * “A라는 지원자를 다른 모든 지원자와 일대일 비교해서 키와 몸무게 모두 A지원자 보다 높은(크고, 무겁다) 지원자가
 * 존재하면 A지원자는 탈락하고, 그렇지 않으면 선발된다.”
 * N명의 지원자가 주어지면 위의 선발원칙으로 최대 몇 명의 선수를 선발할 수 있는지 알아내는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫째 줄에 지원자의 수 N(5<=N<=30,000)이 주어집니다.
 * 두 번째 줄부터 N명의 흰돌 능력치와 검은돌 능력치 정보가 차례로 주어집니다.
 * 각 선수의 흰돌능력치가 모두 다르고, 검은돌 능력치도 모두 다릅니다. 능력치 값은 1,000,000이하의 자연수입니다.
 *
 * 172 67
 * 183 65
 * 180 70
 * 170 72
 * 181 60
 */
public class 씨름선수 {

    static class Person implements Comparable<Person> {
        int weight;
        int height;

        Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        //반환 값이 0보다 작으면, 호출 객체가 매개변수 객체보다 작다는 것을 의미합니다.
        // = 호출 객체가 매개 변수 객체보다 작다.
        // = 호출 객체 - 매개 변수 객체를 리턴 하면 높은 값이 위로 올라가게 된다
        @Override
        public int compareTo(Person o) {
            return o.weight - this.weight;
        }
    }


    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(172, 67));
        personList.add(new Person(183, 65));
        personList.add(new Person(180, 70));
        personList.add(new Person(170, 72));
        personList.add(new Person(181, 60));

        Collections.sort(personList);

        int resultSum = 0;
        int maxHeight = 0;

        for(int i=0; i<personList.size(); ++i) {

            int targetHeight = personList.get(i).height;
            if (i == 0) {
                resultSum++;
                maxHeight = targetHeight;
            } else {
                if (targetHeight > maxHeight) {
                    resultSum++;
                    maxHeight = targetHeight;
                }
            }
        }

        System.out.println(resultSum);
    }
}
