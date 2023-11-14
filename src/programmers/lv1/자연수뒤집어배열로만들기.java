package programmers.lv1;

public class 자연수뒤집어배열로만들기 {

    public static int[] solution(long n) {
        return new StringBuilder().append(n).reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public static void main(String[] args) {

    }

}
