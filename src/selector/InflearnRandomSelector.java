package selector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InflearnRandomSelector {

    public static void main(String[] args) {
        Map<String, List<String>> problems = new HashMap<>();

        problems.put("DFS_BFS", Arrays.asList("동전교환", "미로최단거리통로", "미로탐색", "바둑이승차", "섬나라아일랜드", "섬나라아일랜드BFS",
                                              "수열추측하기", "순열구하기", "순열구하기응용", "조합구하기", "조합수", "중복순열구하기",
                                              "최대점수구하기", "토마토", "피자배달거리DFS", "합이같은부분집합"));

        problems.put("Greedy", Arrays.asList("UnionFind알고리즘", "가중치방향그래프인접행렬", "결혼식", "씨름선수",
                                                "최대수입스케줄", "최소스패닝트리크루스칼", "회의실배정", "다익스트라 알고리즘"));

        problems.put("String", Arrays.asList("문자거리", "숫자만추출", "암호", "중복문자뒤집기", "특정문자뒤집기",
                                             "유효한팰린드롬", "회문문자열"));

        problems.put("Array", Arrays.asList("격자판최대합", "뒤집은소수", "등수구하기", "멘토링", "보이는학생",
                                            "봉우리", "에라토스테네스체", "점수계산기", "큰수출력하기", "피보나치수열"));

        problems.put("Stack_Queue", Arrays.asList("공주구하기", "괄호문자제거", "교육과정설계", "쇠막대기자르기",
                                                  "올바른괄호", "응급실", "크레인인형뽑기", "후위연산식"));

        problems.put("Recursion_Tree_Graph", Arrays.asList("DFS", "경로탐색연결리스트", "경로탐색인접행렬", "그래프최단거리",
                                                           "부분집합구하기DFS", "송아지찾기BFS", "이진수재귀함수", "이진트리순회BFS",
                                                           "재귀함수", "트리말단노드까지의가장짧은경로", "팩토리얼", "피보나치수열"));

        problems.put("Sorting_BinarySearch", Arrays.asList("LRU", "마구간정하기결정알고리즘", "뮤직비디오결정알고리즘", "버블정렬",
                                                           "삽입정렬", "선택정렬", "이분검색", "장난꾸러기", "좌표정렬", "중복확인"));

        problems.put("TwoPointer", Arrays.asList("공통원소구하기", "두배열합치기", "부분연속수열", "연속된자연수의합",
                                                 "최대길이연속부분수열", "최대매출"));

        problems.put("Hashing", Arrays.asList("K번째큰수", "매출액의종류", "모든아나그램찾기", "아나그램", "학급회장"));

        // 랜덤으로 패키지 선택
        Random random = new Random();
        List<String> keys = new ArrayList<>(problems.keySet());
        String randomKey = keys.get(random.nextInt(keys.size()));

        // 해당 패키지의 문제 목록에서 랜덤으로 문제 선택
        List<String> selectedProblems = problems.get(randomKey);
        String randomProblem = selectedProblems.get(random.nextInt(selectedProblems.size()));

        System.out.println("랜덤으로 선택된 문제: " + randomProblem);

    }
}
