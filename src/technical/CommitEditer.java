package technical;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class CommitEditer {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        String temp = localDateTime.toString();
        String semiDate = ((temp.replaceAll("-", "")).replaceAll(":", ""));
        String date = semiDate.substring(0, 8);
        System.out.println(date);

        String code = "cd C:\\Users\\aim\\Desktop\\Study-AimTraining\\commit && echo print('hello world') > "+ date +".txt && git add *&& git commit -m \""+ date +"\"&&git push origin main";

        String ipconfig = execCmd(code);


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
