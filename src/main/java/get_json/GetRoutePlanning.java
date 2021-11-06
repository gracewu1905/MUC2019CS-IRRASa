package get_json;

import com.alibaba.fastjson.JSONArray;

/**路线规划
 * @author ASUS
 * 定义了一个TravelMode的枚举类，参数使用travelMode.DRIVING出行方式driving，riding，walking，transit（公交）
 *  String origin;起始点坐标,输入格式为经度,纬度
 * String destination;终点坐标
 *
 */
public class GetRoutePlanning extends GetJsonObject{
    TravelMode travelMode;
    enum TravelMode{
        DRIVING("driving","驾车"),
        RIDING("riding","骑行"),
        WALKING("walking","步行"),
        TRANSIT("transit","公交");
        private TravelMode(String mode, String display) {
        }
    }
    String origin;
    String destination;
    String servelUrl;
    public GetRoutePlanning(TravelMode travelMode, String origin, String destination) {
        this.travelMode = travelMode;
        this.origin = origin;
        this.destination = destination;
        this.servelUrl="https://api.map.baidu.com/directionlite/v1/"+travelMode+"?origin="+this.origin+"&destination"+this.destination+"&ak="+super.AK;
    }

    public static void main(String[] args) {
        GetRoutePlanning getRoutePlanning=new GetRoutePlanning(TravelMode.DRIVING,
                "40.01116,116.339303","39.936404,116.452562");
        JSONArray jsonArray = getRoutePlanning.getJson(getRoutePlanning.servelUrl);

    }
    //    https://api.map.baidu.com/directionlite/v1/driving?
//    origin=40.01116,116.339303&destination=39.936404,116.452562&ak=bxG3716uVo8E4g2lzTjYGVtSIsQWWzAS
//    https://api.map.baidu.com/directionlite/v1/riding?
//    origin=40.01116,116.339303&destination=39.936404,116.452562&ak=bxG3716uVo8E4g2lzTjYGVtSIsQWWzAS
//    https://api.map.baidu.com/directionlite/v1/walking?
//    origin=40.01116,116.339303&destination=39.936404,116.452562&ak=bxG3716uVo8E4g2lzTjYGVtSIsQWWzAS
//    https://api.map.baidu.com/directionlite/v1/transit?
//    origin=40.056878,116.30815&destination=39.909263,116.39269&ak=bxG3716uVo8E4g2lzTjYGVtSIsQWWzAS
}
