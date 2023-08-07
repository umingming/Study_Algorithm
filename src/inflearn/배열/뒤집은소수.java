package inflearn.배열;

public class 뒤집은소수 {

    public boolean isPrime(int num) {
        if (num == 1) return false;
        else {
            for(int i=2; i<num; ++i) if (num % i == 0) return false;
            return true;
        }
    }

    public void solution (String[] arr) {

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {

            sb.setLength(0);
            int num = Integer.parseInt(sb.append(s).reverse().toString());

            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }



    }


    public static void main (String[] args) {
        뒤집은소수 T = new 뒤집은소수();

        String[] arr = {"32", "55", "62", "20", "250", "370", "200", "30", "100"};
        T.solution(arr);
    }


}
