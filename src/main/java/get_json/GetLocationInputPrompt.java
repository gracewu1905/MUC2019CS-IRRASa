package get_json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**地点输入提示
 * @author ASUS
 * q为关键字，对应数据库的name字段，必选项
 */
public class GetLocationInputPrompt extends GetJsonObject{
    String q;

    public GetLocationInputPrompt(String q) {
        this.q = q;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    /**
     * @return JSONArray数组
     * "result":[
     *         {
     *             "name":"天安门",
     *             "location":{
     *                 "lat":39.915119,
     *                 "lng":116.403963
     *             },
     *             "uid":"65e1ee886c885190f60e77ff",
     *             "province":"北京市",
     *             "city":"北京市",
     *             "district":"东城区",
     *             "business":"",
     *             "cityid":"131",
     *             "tag":"风景区",
     *             "address":"北京市-东城区-长安街",
     *             "children":[
     *                 {
     *                     "uid":"fd975efc10193656734b879a",
     *                     "name":"天安门-入口 北京市东城区",
     *                     "show_name":"入口"
     *                 },
     *                 {
     *                     "uid":"eea3f9dd77b6ddfd980050f0",
     *                     "name":"天安门-北一号门 北京市东城区",
     *                     "show_name":"北一号门"
     *                 },
     *                 {
     *                     "uid":"e6ee2fd26fcc65482b11d179",
     *                     "name":"天安门-存取包处 北京市东城区",
     *                     "show_name":"存取包处"
     *                 },
     *                 {
     *                     "uid":"970b4739a91efb3c43ab9aeb",
     *                     "name":"天安门-出口 北京市东城区",
     *                     "show_name":"出口"
     *                 }
     *             ],
     *             "adcode":"110101"
     *         },
     *         {
     *             "name":"天安门广场-出入口",
     *             "location":{
     *                 "lat":39.91141,
     *                 "lng":116.405768
     *             },
     *             "uid":"936d2c05d294e0135d17c349",
     *             "province":"北京市",
     *             "city":"北京市",
     *             "district":"东城区",
     *             "business":"",
     *             "cityid":"131",
     *             "tag":"出入口",
     *             "address":"北京市-东城区-广场东侧路",
     *             "children":[
     *
     *             ],
     *             "adcode":"110101"
     *         }
     *     ]
     * examples:
     * LocationInputPrompt locationSearch = new LocationInputPrompt("天安");
     * JSONArray jsonArray = locationSearch.getLocationInputPromptJson();
     * Object o = jsonArray.get(0);
     * o=(JSONObject)o;
     * System.out.println(o);
     * System.out.println(jsonArray);
     *然后json处理各种数据
     * */
    public JSONArray getLocationInputPromptJson(){

        String serverUrl = "https://api.map.baidu.com/place/v2/suggestion?" +
                "query=" +q+
                "&region=北京&city_limit=true&output=json&ak="
                +super.AK;
        JSONObject json=super.getResponse(serverUrl);
        System.out.println(serverUrl);
//        System.out.println(json);
        JSONArray results=null;
        if(json==null){
            return results;
        }
        results=json.getJSONArray("result");
        return results;
    }
    /**public static void main(String[] args) {
        LocationInputPrompt locationSearch = new LocationInputPrompt("天安");
        JSONArray jsonArray = locationSearch.getLocationInputPromptJson();
        Object o = jsonArray.get(0);
        o=(JSONObject)o;
        System.out.println(o);
        System.out.println(jsonArray);

     }*/

}
