package get_json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;


public class GetJsonObject {
    /**
     * 我的密钥
     */
    public final String AK ="bxG3716uVo8E4g2lzTjYGVtSIsQWWzAS";
//    @Test
//    public void test(){
//        System.out.println(getResponse("https://api.map.baidu.com/directionlite/v1/driving?origin=40.01116,116.339303&destination=39.936404,116.452562&ak="+AK+"d&callback=showLocation"));
//    }
    /**
     * 根据传入的url，获取相关的json文件对象,并判断是否合法,如果不合法为null
     * @param serverUrl 传入的URL
     * @return json对象
     * 调用使用getString(属性名)
     */
    public JSONObject getResponse(String serverUrl){
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
        JSONObject json=JSONObject.parseObject(result.toString());
        if(Integer.parseInt(json.getString("status"))!=0){
            return null;
        }
        else {
            return json;
        }
    }
    public JSONArray getJson(String serverUrl){
        JSONObject json=this.getResponse(serverUrl);
        System.out.println(serverUrl);
        JSONArray results=null;
        if(json==null){
            return results;
        }
        results=json.getJSONArray("result");
        return results;
    }

}
