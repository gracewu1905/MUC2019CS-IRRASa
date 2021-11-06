package get_json;

/**地点输入提示</br>
 * 只调用getJson方法,具体参考getJson函数</br>
 * */
public class GetLocationInputPrompt extends GetJsonObject{
    /**
     * q为关键字，对应数据库的name字段，如天安门，必选项
     */
    String q;

    /**
     * @param q  关键字，对应数据库的name字段，如天安门，必选项
     */
    public GetLocationInputPrompt(String q) {
        this.q = q;
        super.serverUrl = "https://api.map.baidu.com/place/v2/suggestion?" +
                "query=" +q+
                "&region=北京&city_limit=true&output=json&ak="
                +super.AK;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }


}
