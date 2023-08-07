package inflearn.배열;

public class 에라토네스체 {

    public void solution (int count) {

        int[] arr = new int[count+1];
        int result = 0;
        for(int i=2; i<=count; ++i) {

            if (arr[i] == 0) {
                result++;
                for(int j=i; j<=count; j=j+i) arr[j] = 1;
            }

        }

        System.out.println(result);



    }


    public static void main (String[] args) {
        에라토네스체 T = new 에라토네스체();

        T.solution(20);
    }


}
