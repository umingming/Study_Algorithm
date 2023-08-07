package inflearn.배열;



public class 큰수출력하기 {

    public boolean solution (int[] arr) {

        System.out.println(arr[0]);

        for(int i=1; i<arr.length; ++i) {

            if (arr[i-1] < arr[i]) {
                System.out.println(arr[i]);
            }

        }

        return false;
    }



    public static void main (String[] args) {
        큰수출력하기 T = new 큰수출력하기();
//        Scanner kb = new Scanner(System.in);
//        String str = kb.next();
        int[] arr = {7, 3, 9, 5, 6, 12};
        System.out.print(T.solution(arr));
    }

}
