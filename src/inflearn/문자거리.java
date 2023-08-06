package inflearn;

public class 문자거리 {

    public int[] solution (String str) {

        int[] answer = new int[str.length()];

        String word = str.split(" ")[0];
        String target = str.split(" ")[1];

        int p = 1000;
        for(int i=0; i<word.length(); ++i) {
            if (word.charAt(i) == target.charAt(0)) {
                p = 0;
            }
            answer[i] = p;
            p++;
        }

        for(int i=word.length()-1; i>=0; --i) {
            if (word.charAt(i) == target.charAt(0)) {
                p = 0;
            }

            if (answer[i] > p) {
                answer[i] = p;
            }
            p++;
        }



        return answer;

    }



    public static void main (String[] args) {
        문자거리 T = new 문자거리();
//        Scanner kb = new Scanner(System.in);
//        String str = kb.next();
        System.out.print(T.solution("teachermode e"));
    }

}
