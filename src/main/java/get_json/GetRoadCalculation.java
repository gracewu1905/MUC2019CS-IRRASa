package get_json;

/**此处用于规划路线
 * 批量算路目前支持驾车、摩托车、骑行（电动车/自行车）、步行。
 * 根据起点和终点，批量计算路线的距离和耗时
 * 融入出行策略（不走高速、常规路线、距离较短），路线和耗时计算考虑实时路况
 * 驾车模式支持输入起点车头方向，提升准确性
 * 步行时任意起终点之间的距离不得超过200KM，超过此限制会返回参数错误
 * 一次最多计算50条路线，起终点个数之积不能超过50。 比如2个起点25个终点，50个起点1个终点等
 * @author ASUS
 *  定义了一个TravelMode的枚举类，参数使用travelMode.DRIVING出行方式driving，riding，walking，transit（公交）
 * String origin;起始点坐标,
 * 输入格式为经度,纬度|经度,纬度
 * String destination;终点坐标
 * 输入格式为：经度,纬度|经度,纬度
 */
public class GetRoadCalculation extends GetJsonObject{
    TravelMode travelMode;
    String origin;
    String destination;
    String servelUrl;
//    public GetRoadCalculation(TravelMode travelMode, String...s) {
//        this.travelMode = travelMode;
//        this.origin = s[0]+"|"+s[1];
//        this.destination = s[1]+"|"+s[2];
//        this.servelUrl="https://api.map.baidu.com/routematrix/v2/driving?output=json&origins="+this.origin+"&destinations="+this.destination+"&ak="+super.AK;
//    }
    public GetRoadCalculation(TravelMode travelMode, String origin, String destination) {
        this.travelMode = travelMode;
        this.origin = origin;
        this.destination = destination;
        this.servelUrl="https://api.map.baidu.com/routematrix/v2/driving?output=json&origins="+this.origin+"&destinations="+this.destination+"&ak="+super.AK;
    }
    /**
     * public static void main(String[] args) {
     *         GetRoadCalculation getRoadCalculation=new GetRoadCalculation(TravelMode.driving,
     *                 "40.45,116.34|40.54,116.35","40.34,116.45|40.35,116.46");
     *         JSONArray jsonObject = (JSONArray) getRoadCalculation.getJson(getRoadCalculation.servelUrl);
     *         System.out.println(jsonObject);
     *     }
     *  [{
     * 	"duration": {
     * 		"text": "12分钟",
     * 		"value": 724
     *        },
     * 	"distance": {
     * 		"text": "19.3公里",
     * 		"value": 19319
     *    }
     * }, {
     * 	"duration": {
     * 		"text": "13分钟",
     * 		"value": 772
     *    },
     * 	"distance": {
     * 		"text": "20.6公里",
     * 		"value": 20613
     *    }
     * }, {
     * 	"duration": {
     * 		"text": "28分钟",
     * 		"value": 1696
     *    },
     * 	"distance": {
     * 		"text": "45.2公里",
     * 		"value": 45236
     *    }
     * }, {
     * 	"duration": {
     * 		"text": "29分钟",
     * 		"value": 1744
     *    },
     * 	"distance": {
     * 		"text": "46.5公里",
     * 		"value": 46530
     *    }
     * }]
     * */



}
