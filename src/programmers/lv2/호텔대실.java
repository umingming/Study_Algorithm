package programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 호텔을 운영 중인 코니는 최소한의 객실만을 사용하여 예약 손님들을 받으려고 합니다. 한 번 사용한 객실은 퇴실 시간을 기준으로 10분간 청소를 하고 다음 손님들이 사용할 수 있습니다.
 * 예약 시각이 문자열 형태로 담긴 2차원 배열 book_time이 매개변수로 주어질 때, 코니에게 필요한 최소 객실의 수를 return 하는 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 1 ≤ book_time의 길이 ≤ 1,000
 * book_time[i]는 ["HH:MM", "HH:MM"]의 형태로 이루어진 배열입니다
 * [대실 시작 시각, 대실 종료 시각] 형태입니다.
 * 시각은 HH:MM 형태로 24시간 표기법을 따르며, "00:00" 부터 "23:59" 까지로 주어집니다.
 * 예약 시각이 자정을 넘어가는 경우는 없습니다.
 * 시작 시각은 항상 종료 시각보다 빠릅니다.
 */
public class 호텔대실 {

    static class BookTimeInfo implements Comparable<BookTimeInfo> {
        int time;
        String symbol;

        public BookTimeInfo (int time, String symbol) {
            this.time = time;
            this.symbol = symbol;
        }

        @Override
        public int compareTo(BookTimeInfo o) {
            if(this.time == o.time) {
                return this.symbol.charAt(0) - o.symbol.charAt(0);
            } else {
                return this.time - o.time;
            }
        }
    }

    public int solution(String[][] book_time) {
        List<BookTimeInfo> bookTimeInfoList = new ArrayList<>();
        initBookTimeInfoList(book_time, bookTimeInfoList);
        Collections.sort(bookTimeInfoList);

        int result = 0;
        int currentCount = 0;

        for(BookTimeInfo booktimeInfo : bookTimeInfoList) {
            if(booktimeInfo.symbol.equals("I")) {
                currentCount++;
                result = Math.max(result, currentCount);
            } else {
                currentCount--;
            }
        }

        return result;
    }

    private void initBookTimeInfoList(String[][] book_time, List<BookTimeInfo> bookTimeInfoList) {
        for(String[] list : book_time) {
            int inTime = (Integer.parseInt(list[0].split(":")[0]) * 60) + Integer.parseInt(list[0].split(":")[1]);
            int outTime = (Integer.parseInt(list[1].split(":")[0]) * 60) + (Integer.parseInt(list[1].split(":")[1]) + 10);
            bookTimeInfoList.add(new BookTimeInfo(inTime), "I");
            bookTimeInfoList.add(new BookTimeInfo(outTime), "O");
        }
    }
}
