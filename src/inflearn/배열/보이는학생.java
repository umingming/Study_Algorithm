package inflearn.배열;

public class 보이는학생 {

    public void solution (int[] arr) {

        int maxNum = 0;
        int count = 0;

        for(int i=0; i<arr.length; ++i) {

            if (arr[i] > maxNum) {
                maxNum = arr[i];
                count++;
            }

        }

        System.out.print(count);

    }



    public static void main (String[] args) {
        보이는학생 T = new 보이는학생();
//        Scanner kb = new Scanner(System.in);
//        String str = kb.next();
        int[] arr = {130, 135, 148, 140, 145, 150, 150, 153};
        T.solution(arr);
    }

}
