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
    enum TravelMode{
        driving("驾车"),
        riding("骑行"),
        walking("步行"),
        transit("公交");
        private TravelMode( String display) {
        }
    }
    public final String AK ="bxG3716uVo8E4g2lzTjYGVtSIsQWWzAS";
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
    public Object getJson(String serverUrl){
        JSONObject json=this.getResponse(serverUrl);
        Object results=null;
        if(json==null){
            return results;
        }
        try {
            results=json.getJSONArray("result");
        }
        catch (Exception e){
            results=json.getJSONObject("result");
        }
//        results=json.getJSONObject("result");
        return results;
    }

}
