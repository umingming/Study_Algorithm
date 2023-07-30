package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class 무인도여행2 {

    static char map[][]; // 지도를 나타낼 2차원 char 배열 선언
    static boolean visited[][]; // 방문 여부를 나타낼 2차원 boolean 배열 선언
    static int dx[] = {1,0,-1,0}; // x 방향 이동을 나타낼 배열 선언
    static int dy[] = {0,1,0,-1}; // y 방향 이동을 나타낼 배열 선언
    static ArrayList<Integer> list = new ArrayList<>(); // 결과값을 저장할 ArrayList 선언

    class Solution { // 'Solution' 클래스 선언

        // 주어진 무인도 지도(maps)를 탐색하여 이동 가능한 모든 경로의 합을 오름차순으로 반환하는 메소드입니다.
        public int[] solution(String[] maps) {
            visited = new boolean[maps.length][maps[0].length()]; // 방문 배열을 무인도 지도와 동일한 크기로 초기화
            map = new char[maps.length][maps[0].length()]; // 지도 배열을 무인도 지도와 동일한 크기로 초기화

            // 주어진 문자열 배열(maps)을 2차원 char 배열로 변환하여 지도(map)에 저장합니다.
            for(int a=0;a<maps.length ; a++){
                for(int i =0;i<maps[a].length();i++){
                    map[a][i] = maps[a].charAt(i);
                }
            }

            // 모든 지점을 탐색하면서, 방문하지 않은 이동 가능한 지점을 시작으로 BFS 탐색을 시작합니다.
            for(int i=0;i<map.length;i++){
                for(int j=0;j<map[i].length;j++){
                    if(!visited[i][j] && map[i][j] != 'X'){ // 방문하지 않았고, 이동 가능한 지점일 때

                        // 해당 지점으로부터 BFS 탐색을 시작하여 이동 가능한 경로의 합을 list에 저장합니다.
                        list.add(bfs(i,j,map.length,map[i].length));
                    }
                }
            }

            // list에 저장된 값을 오름차순으로 정렬하고, int 배열로 변환하여 반환합니다.
            int temp[] = list.stream()
                    .mapToInt(Integer::intValue)
                    .sorted()
                    .toArray();

            // temp 배열이 비어있을 경우, 즉 이동 가능한 지점이 없을 경우 -1을 반환합니다.
            return temp.length == 0 ? new int[]{-1} : temp;
        }

        // BFS 탐색을 위한 메소드입니다.
        int bfs(int x, int y, int height, int width){
            Queue<Node> queue = new LinkedList<>(); // BFS 탐색을 위한 큐 선언
            queue.add(new Node(x,y)); // 시작 노드를 큐에 추가하여 탐색을 시작합니다.
            visited[x][y] = true; // 시작 노드를 방문 표시합니다.
            int sum = 0; // 이동 가능한 경로의 합을 저장할 변수를 초기화합니다.

            // 큐가 비어있을 때까지 반복하여 BFS 탐색을 진행합니다.
            while(!queue.isEmpty()){
                Node now = queue.poll(); // 큐에서 하나의 노드를 꺼냅니다.

                sum += map[now.x][now.y] - '0'; // 현재 노드의 값을 합산합니다. (문자를 숫자로 변환하여 합산)

                // 현재 노드의 상하좌우 인접 노드들을 탐색하여 큐에 추가합니다.
                for(int i=0;i<4;i++){
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];

                    // 인접 노드가 지도 범위를 벗어나거나, 이미 방문했던 노드이거나 이동 불가능한 지점일 경우 건너뜁니다.
                    if(nextX < 0 || nextY < 0 || nextX >= height || nextY >= width){
                        continue;
                    } else {
                        if(!visited[nextX][nextY] && map[nextX][nextY] != 'X'){
                            queue.add(new Node(nextX,nextY)); // 인접 노드를 큐에 추가합니다.
                            visited[nextX][nextY] = true; // 인접 노드를 방문 표시합니다.
                        }
                    }
                }
            }

            return sum; // 탐색이 끝나면 이동 가능한 경로의 합을 반환합니다.
        }
    }

    class Node{ // 노드의 좌표를 나타내는 클래스 선언
        int x; // 노드의 x 좌표
        int y; // 노드의 y 좌표

        // x, y 좌표를 입력받아 노드 객체를 생성하는 생성자
        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

}
