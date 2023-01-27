package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * 과제 안 내신 분..? 다국어
 *
 * X대학 M교수님은 프로그래밍 수업을 맡고 있다. 교실엔 학생이 30명이 있는데, 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.
 *
 * 교수님이 내준 특별과제를 28명이 제출했는데, 그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.
 */
public class Q5597 {

    public static void main(String[] args) throws IOException {

        List<Integer> memberList = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for(int i=1; i<31; ++i) {
            memberList.add(i);
        }


        for(int i=0; i<28; ++i) {
            memberList.remove(memberList.indexOf(Integer.parseInt(reader.readLine())));
        }

        for(int s : memberList) {
            System.out.println(s);
        }


    }

}
