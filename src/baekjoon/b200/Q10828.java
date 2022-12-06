package baekjoon.b200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q10828 {

    public static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(reader.readLine());

        for(int i=0; i<count; ++i) {
            String input = reader.readLine();

            if (input.startsWith("push")) {
                push(Integer.parseInt(input.substring(input.indexOf(" ") + 1)));
            } else if (input.equals("pop")) {
                sb.append(pop()).append("\n");
            } else if (input.equals("size")) {
                sb.append(size()).append("\n");
            } else if (input.equals("empty")) {
                sb.append(empty()).append("\n");
            } else if (input.equals("top")) {
                sb.append(top()).append("\n");
            }
        }

        System.out.println(sb);


    }

    public static void push(int data) {
        list.add(data);
    }

    public static int pop() {
        if(list.size() == 0) {
            return -1;
        } else {
            int result = list.get(list.size()-1);
            list.remove(list.size()-1);
            return result;
        }
    }

    public static int size() {
        return list.size();
    }

    public static int empty() {
        if (list.size() == 0){
            return 1;
        } else {
            return 0;
        }
    }

    public static int top () {
        if(list.size() == 0) {
            return -1;
        } else {
            return list.get(list.size()-1);
        }
    }

}
