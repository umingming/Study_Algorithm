package programmers.lv1;

import java.util.*;

public class 두개뽑아서더하기 {

    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();
        for(int i=0; i<numbers.length-1; ++i) {
            for(int j=i+1; j<numbers.length; ++j) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();
    }

    public static void main(String[] args) {
        두개뽑아서더하기 solution = new 두개뽑아서더하기();
    }

}
