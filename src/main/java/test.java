import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;


public class test {
    public static void main(String[] args) {
        String s=getResponse("https://api.map.baidu.com/place/v2/search?query=ATM机&tag=银行&region=北京&output=json&ak=ETSvjlCgK50DcDbXWKnaINS1m1dpqled");
        System.out.println(s);
    }
    public static String getResponse(String serverUrl){
        //用JAVA发起http请求，并返回json格式的结果
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(serverUrl);
            URLConnection conn = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

            String line;
            while((line = in.readLine()) != null){
                result.append(line);
            }
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
