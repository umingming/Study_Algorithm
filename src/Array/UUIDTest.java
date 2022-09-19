package Array;

import java.util.UUID;

public class UUIDTest {

    public static void main(String[] args) {

//        System.out.println(version1());
        System.out.println(version2());

    }

    public static long version1() {

        long beforeTime = System.currentTimeMillis();
        String temp1 = UUID.randomUUID().toString();
        long afterTime = System.currentTimeMillis();
        long result = afterTime - beforeTime;

       return result;
    }

    public static long version2() {

        long beforeTime = System.currentTimeMillis();

        String temp2 = UUID.fromString("3051a8d7-aea7-1801-e0bf-bc539dd60cf3").toString();

        long afterTime = System.currentTimeMillis();

        long result = afterTime - beforeTime;

        return result;

    }

}
