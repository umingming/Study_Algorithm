package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P        A      H       N
 *   A   P   L   S   I   I   G
 *     Y        I       R
 *
 * 1. make String Buffer List
 * 2. input value zigzag type
 */
public class ZigzagConversion2 {

    public static void main(String[] args) {

        ZigzagConversion2 solution = new ZigzagConversion2();
        System.out.println(solution.convert("AB", 1));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        // make zigzag
        List<StringBuilder> list = makeZigzagArray(numRows, s);

        // make result(String)
        return makeResult(list);
    }

    private List<StringBuilder> makeZigzagArray(int numRows, String s) {
        List<StringBuilder> list = makeStringBuilderArray(numRows);

        char[] charArray = s.toCharArray();

        boolean isUpper = false;
        int index = 0;

        for (int i = 0; i < charArray.length; i++) {
            list.get(index).append(charArray[i]);

            if (isUpper) {
                if (index == 0) {
                    isUpper = false;
                    index++;
                } else {
                    index--;
                }
            } else {
                if (index == numRows - 1) {
                    isUpper = true;
                    index--;
                } else {
                    index++;
                }
            }
        }
        return list;
    }

    private List<StringBuilder> makeStringBuilderArray(int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        return list;
    }

    private String makeResult(List<StringBuilder> list) {
        StringBuilder resultSb = new StringBuilder();
        list.forEach(e -> resultSb.append(e.toString()));
        return resultSb.toString();
    }
}
