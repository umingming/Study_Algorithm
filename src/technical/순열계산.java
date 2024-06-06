package technical;

/**
 * 1, 2, 3이 있을 떄 이 1, 2, 3으로 구할 수 있는 순열을 구하자
 *
 * 1.
 */
public class 순열계산 {

    public static void main(String[] args) {
        DFS();
    }

    public static void DFS() {
        DFS("", 0);
    }

    public static void DFS(String word, int L) {
        if (L == 4) {
            return;
        }

        if (!word.equals("")) {
            System.out.println(word);
        }

        for(int i=0; i<3; ++i) {
            DFS(word + " " + "123".charAt(i), L+1);
        }
    }

}
