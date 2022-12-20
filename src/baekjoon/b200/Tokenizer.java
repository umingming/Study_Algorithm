package baekjoon.b200;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Tokenizer {
    public static void main(String[] args) {

        String str = "I'm Developer Genius";
        StringTokenizer temp = new StringTokenizer(str);

        while(temp.hasMoreTokens()) System.out.println(temp.nextToken());

    }
}
