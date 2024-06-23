import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 다익스트라알고리즘 {

    static class Edge implements Comparable<Edge>{
        public int vex;
        public int cost;
        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge ob){
            return this.cost - ob.cost;
        }
    }

    static int n, m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    public void solution(int v){
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0));
        dis[v] = 0;
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost > dis[now]) continue;
            for(Edge ob : graph.get(now)){
                if(dis[ob.vex] > nowCost + ob.cost){
                    dis[ob.vex] = nowCost + ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
                }
            }
        }
    }

    public static void main(String[] args){
        다익스트라알고리즘 T = new 다익스트라알고리즘();

        n = 6; // 노드의 개수
        m = 9; // 간선의 개수

        graph = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Edge>());
        }

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        // 간선 정보 직접 입력
        int[][] edges = {
                {1, 2, 12},
                {1, 3, 4},
                {2, 1, 2},
                {2, 3, 5},
                {3, 4, 5},
                {4, 2, 2},
                {4, 5, 5},
                {4, 6, 5},
                {6, 4, 5}
        };

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];
            graph.get(a).add(new Edge(b, c));
        }

        T.solution(1);

        for(int i = 2; i <= n; i++){
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i + " : " + dis[i]);
            else System.out.println(i + " : impossible");
        }
    }
}
