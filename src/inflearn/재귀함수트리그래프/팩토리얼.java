package inflearn.재귀함수트리그래프;

public class 팩토리얼 {

    public static int DFS(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * DFS(num-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(DFS(5));
    }

}
