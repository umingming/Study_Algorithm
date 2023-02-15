package technical;

import com.sun.xml.internal.ws.util.StringUtils;

public class GetMethod {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("".length());
    }


}
