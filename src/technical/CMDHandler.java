package technical;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class CMDHandler {

    public static void main(String[] args) {



        String ipconfig = execCmd("docker version");
        System.out.println(ipconfig);

    }

    public static String execCmd(String cmd) {
        try {
            Process process = Runtime.getRuntime().exec("cmd /c " + cmd);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));


            String line = null;
            StringBuffer sb = new StringBuffer();
            sb.append(cmd);
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }

            String s = sb.toString();
            String s2 = new String(s.getBytes("utf-8"));

            return s2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
