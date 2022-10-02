package technical;

import java.util.UUID;

public class UUIDTest {

    public static void main(String[] args) {


        UUID uuid = UUID.fromString("3840002asdasdasd2020-8casdasdf0-11bd-b23e-10b96e4ef00d");

        System.out.println(uuid);

    }

    public static long version1() {

        long beforeTime = System.currentTimeMillis();
        String temp1 = UUID.randomUUID().toString();
        long afterTime = System.currentTimeMillis();
        long result = afterTime - beforeTime;

       return result;
    }

    public static long version2() {
        //UUID 형식인지를 체킹 하는 메소드

        long beforeTime = System.currentTimeMillis();

        UUID uuid = UUID.fromString("38400022020-8cf0-11bd-b23e-10b96e4ef00d");

        System.out.println(uuid);
        long afterTime = System.currentTimeMillis();


        long result = afterTime - beforeTime;

        return result;

    }

}
