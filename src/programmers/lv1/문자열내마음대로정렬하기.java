package programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) > o2.charAt(n)) {
                return 1;
            } else if (o1.charAt(n) < o2.charAt(n)) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        });

        return strings;
    }

    private void swap(String[] strings, int i, int j) {
        String temp;
        temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }

    public static void main(String[] args) {

    }

}
