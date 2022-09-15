package Array;

public class ZiazagConversion {

    public static void main(String[] args) {
        String answer = convert("abcdefg", 3);
        System.out.println(answer);
    }


    /* [2개]
        1   3   5   7   9
        2   4   6   8   10
    */

    /* [3개]

    abcdefg

        a       e
        b   d   f
        c       g
    */


    public static String convert(String s, int numRows) {
        if(numRows <= 1)
            return s;

        String answer = "";

        for(int i = 0; i < numRows; ++i){
            for(int j = i, cnt = 0; j < s.length(); ++cnt){

                answer += s.charAt(j);
                int offset = 2 * numRows - 2;
                if(i != 0 && i != (numRows - 1)){
                    if(cnt % 2 == 0){
                        offset -= (2 * i);
                    }
                    else {
                        offset = 2 * i;
                    }
                }
                j += offset;
            }
        }
        return answer;
    }
}


    /* [4개]
        1           7           13          19
        2       6   8       12  14      18  20
        3   5       9   11      15  17      21
        4           10          16          22
    */

    /*  [5개]
        1               9               17
        2           8   10          16  18
        3       7       11      15      19
        4   6           12  14          20
        5               13              21
    */

    /*  [6개]
        1                   11                  21
        2               10  12              20  22
        3           9       13          19      23
        4       8           14      18          24
        5   7               15  17              25
        6                   16                  26
    */