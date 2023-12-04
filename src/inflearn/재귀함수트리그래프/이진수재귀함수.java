package inflearn.재귀함수트리그래프;

public class 이진수재귀함수 {

    public static void DFS(int num) {

        if (num==0) {
            return;
        } else {
            DFS(num/2);
            System.out.print(num%2 + " ");
        }


    }

    public static void main(String[] args) {
        DFS(11);
    }

}
