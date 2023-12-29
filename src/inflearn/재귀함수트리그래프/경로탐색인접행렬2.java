package inflearn.재귀함수트리그래프;

/**
 * 인접 행렬을 통해 경로의 경우의 수를 탐색하는 Class
 * 체화 하기 위하여 한 번 더 푼다
 */
public class 경로탐색인접행렬2 {

    static int vertexCount;

    static int answer;

    static int graph[][];

    static int ch[];

    public static void DFS(int v) {
        if (v == vertexCount) {
            answer++;
        } else {
            for(int i=1; i<=vertexCount; ++i) {
                if (graph[v][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(i);
                    ch[i] = 0;
                }
            }

        }
    }

    public static void main(String[] args) {
        // 정점의 갯수
        vertexCount = 5;

        graph = new int[vertexCount+1][vertexCount+1];
        ch = new int[vertexCount+1];

        graph[1][2] = 1;
        graph[1][3] = 1;
        graph[1][4] = 1;
        graph[2][1] = 1;
        graph[2][3] = 1;
        graph[2][5] = 1;
        graph[3][4] = 1;
        graph[4][2] = 1;
        graph[4][5] = 1;

        ch[1] = 1;
        DFS(1);
        System.out.println(answer);

    }

}
