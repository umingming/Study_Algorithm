package programmers.lv1;

import java.util.Arrays;

public class 문자열내림차순으로배치하기 {

    public String soltuoin(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new StringBuilder(new String(chars)).reverse().toString();
    }

    public static void main(String[] args) {
        문자열내림차순으로배치하기 soltuion = new 문자열내림차순으로배치하기();
        System.out.println(soltuion.soltuoin("Zbcdefg"));
    }

}
