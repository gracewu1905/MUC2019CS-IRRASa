package get_json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;


/**
 * 用于地点检索，获取地点（POI）基础或详细地理信息
 * @author ASUS
 * uids为必选选项,传入一堆uid，以String数组方式传入,最多十个
 * scope为必选项，1,代表基本信息，2代表详细信息
 * output选择输出形式json，xml，默认json
 * uids非必选，
 */
public class GetLocationSearch extends GetJsonObject{

    private String[] uids;
    private int scope;



    public GetLocationSearch(int scope, String...uids) {
        this.uids = uids;
        this.scope = scope;
    }


    public String[] getUids() {
        return uids;
    }

    public void setUids(String[] uids) {
        this.uids = uids;
    }


    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    /**
     * @return JSONArray数组
     * 返回result
     * 格式如下
     *  "result":[
     *         {
     *             "uid":"435d7aea036e54355abbbcc8",
     *             "street_id":"435d7aea036e54355abbbcc8",
     *             "name":"百度大厦",
     *             "location":{
     *                 "lng":116.30789936414,
     *                 "lat":40.05703792689
     *             },
     *             "address":"北京市海淀区上地十街10号",
     *             "province":"北京市",
     *             "city":"北京市",
     *             "area":"海淀区",
     *             "detail":1
     *         },
     *         {
     *             "uid":"5ffb1816cf771a226f476058",
     *             "street_id":"5ffb1816cf771a226f476058",
     *             "name":"中国工商银行(天通苑西区支行)",
     *             "location":{
     *                 "lng":116.42068503448,
     *                 "lat":40.07296906732
     *             },
     *             "address":"天通苑5区西单商场1层",
     *             "province":"北京市",
     *             "city":"北京市",
     *             "area":"昌平区",
     *             "telephone":"(010)84821191",
     *             "detail":1
     *         }
     *     ]
     * examples:
     *LocationSearch locationSearch = new LocationSearch(2, "435d7aea036e54355abbbcc8");
     * JSONArray jsonArray = locationSearch.getLocationSearchJson();
     * System.out.println(jsonArray);
     * //LocationSearch(int scope,String...uids)
     *然后json处理各种数据
     * */
    public JSONArray getLocationSearchJson(){

         String serverUrl = "https://api.map.baidu.com/place/v2/detail?uids=" +
                 StringUtils.join(uids,",")+"&output=json&scope="+ scope+"&ak="+super.AK;
        JSONObject json=super.getResponse(serverUrl);
        System.out.println(serverUrl);
        JSONArray results=null;
        if(json==null){
            return results;
        }
        results=json.getJSONArray("result");
        return results;
     }

    /**public static void main(String[] args) {

            //test类只能有一个构造器
            LocationSearch locationSearch = new LocationSearch(2, "435d7aea036e54355abbbcc8");
            JSONArray jsonArray = locationSearch.getLocationSearchJson();
            Object o = jsonArray.get(0);
            o=(JSONObject)o;
            System.out.println(o);
            System.out.println(jsonArray);

    }*/
    //https://api.map.baidu.com/place/v2/detail?uid=435d7aea036e54355abbbcc8&output=json&scope=2&ak=
}
