package programmers.lv1;

/**
 * 0	zero
 * 1	one
 * 2	two
 * 3	three
 * 4	four
 * 5	five
 * 6	six
 * 7	seven
 * 8	eight
 * 9	nine
 */

public class 숫자문자열과영단어 {

    public int solution(String s) {

        return Integer.parseInt(s.replaceAll("zero", "0")
                                  .replaceAll("one", "1")
                                  .replaceAll("two", "2")
                                  .replaceAll("three", "3")
                                  .replaceAll("four", "4")
                                  .replaceAll("five", "5")
                                  .replaceAll("six", "6")
                                  .replaceAll("seven", "7")
                                  .replaceAll("eight", "8")
                                  .replaceAll("nine", "9"));
    }

    public static void main(String[] args) {

    }
}
