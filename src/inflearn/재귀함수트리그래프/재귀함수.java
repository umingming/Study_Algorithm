package inflearn.재귀함수트리그래프;

public class 재귀함수 {

    public static void DFS(int num) {
        if (num <= 0) {
            return;
        } else {
            System.out.print(num);
            DFS(num-1);
        }
    }

    public static void main(String[] args) {
        DFS(3);
    }

}
