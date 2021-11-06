package get_json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * 地理编码</br>
 * 将具体位置转为坐标
 */
public class GetGeocodingJson extends GetJsonObject{
//    https://api.map.baidu.com/geocoding/v3/?
//    address=北京市海淀区上地十街10号&output=json&ak=您的ak&callback=showLocation
    /**
     * 待解析的地址
     */
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GetGeocodingJson(String address) {
        this.address = address;
        super.serverUrl="https://api.map.baidu.com/geocoding/v3/?address="+this.address+"&output=json&ak=" +super.AK;
    }

}
