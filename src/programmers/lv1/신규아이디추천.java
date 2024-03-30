package programmers.lv1;


public class 신규아이디추천 {
    public String solution(String new_id) {

        new_id = new_id.toLowerCase()
                .replaceAll("[^a-z0-9._-]", "")
                .replaceAll("\\.+", ".")
                .replaceAll("^\\.|\\.$", "");


        if (new_id.isEmpty()) {
            new_id = "a";
        }

        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
            new_id = new_id.replaceAll("\\.$", "");
        }

        while (new_id.length()<3) {
            new_id += new_id.charAt(new_id.length()-1) + "";
        }

        return new_id;

    }



    public static void main(String[] args) {
        신규아이디추천 solution = new 신규아이디추천();
        System.out.println(solution.solution("...!@BaT#*..y.abcdefghijklm"));
    }
}
