package Array;

import java.util.UUID;

public class UUIDTest {

    public static void main(String[] args) {

        String temp1 = UUID.randomUUID().toString();
        System.out.println(temp1);

        String temp2 = UUID.fromString("3051a8d7-aea7-1801-e0bf-bc539dd60cf3").toString();
        System.out.println(temp2);

    }

}
