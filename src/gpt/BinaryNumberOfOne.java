package gpt;

import java.io.IOException;
import java.util.Scanner;

public class BinaryNumberOfOne {

    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = 321;
        int count = 0;

        while (n != 0) {
            count += n & 1; // AND 연산을 이용하여 마지막 비트가 1인지 검사
            n = n >> 1; // 비트를 오른쪽으로 1칸씩 이동
        }

        System.out.println(count);

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int num = reader.read();
//        int mathCount = 1;
//        int binaryCount = 0;
//
//        while(mathCount <= num) {
//            mathCount = mathCount*2;
//            ++binaryCount;
//        }
//
//        mathCount = mathCount/2;
//
//        int resultCount = 0;
//        for(int i=0; i<binaryCount; ++i) {
//            if(num >= mathCount) {
//                ++resultCount;
//                num = num - mathCount;
//            }
//            mathCount = mathCount / 2;
//        }
//
//        System.out.println(resultCount);


    }

}
