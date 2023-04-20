package gpt;

public class Reverse {

    /**
     * 사용자로부터 알파벳 대소문자와 공백으로 이루어진 문자열을 입력 받아
     * 해당 문자열의 단어들을 뒤집어서 출력하는 프로그램을 작성해보세요.
     * 단, 공백은 그대로 유지되어야 합니다.
     */

    public static void main(String[] args) {
        String word = "Hello World";

        String[] wordArr = word.split("");

        for(int i=wordArr.length-1; i>-1; --i) {
            System.out.print(wordArr[i]);
        }
    }

}
