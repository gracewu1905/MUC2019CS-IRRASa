package get_json;

import org.apache.commons.lang3.StringUtils;


/**
 *用于地点检索，获取地点（POI）基础或详细地理信息</br>
 *只调用getJson方法,具体参考getJson函数</br>
 */
public class GetLocationSearch extends GetJsonObject{

    /**
     * uid集合,传入一堆uid，以String数组方式传入,最多十个，
     */
    private String[] uids;

    /**
     * @param uids 传入一堆uid，以String数组方式传入,最多十个，</br>
     *             如GetLocationSearch(“123”,"23","3")
     */
    public GetLocationSearch(String...uids) {
        this.uids = uids;
        super.serverUrl = "https://api.map.baidu.com/place/v2/detail?uids=" +
                StringUtils.join(uids,",")+"&output=json&scope=2&ak="+super.AK;
    }


    public String[] getUids() {
        return uids;
    }

    public void setUids(String[] uids) {
        this.uids = uids;
    }


}
