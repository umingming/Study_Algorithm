package gpt;

import technical.A;

public class Maze {

    public static void main(String[] args) {

        int[] arr = new int[10];

        for (int i = 0; i < arr.length; ++i) {

            arr[i] = 0;

        }

        Array.stream(arr).forEach(f -> System.out.println(f));

    }

}
