package get_json;

/**此处用于规划路线</br>
 * 批量算路目前支持驾车、摩托车、骑行（电动车/自行车）、步行。</br>
 * 根据起点和终点，批量计算路线的距离和耗时</br>
 * 融入出行策略（不走高速、常规路线、距离较短），路线和耗时计算考虑实时路况</br>
 * 驾车模式支持输入起点车头方向，提升准确性</br>
 * 步行时任意起终点之间的距离不得超过200KM，超过此限制会返回参数错误</br>
 * 一次最多计算50条路线，起终点个数之积不能超过50。 比如2个起点25个终点，50个起点1个终点等</br>
 * 只调用getJson方法,具体参考getJson函数</br>
 */
public class GetRoadCalculation extends GetJsonObject{
    /**
     * 使用TravelMode
     */
    TravelMode travelMode;
    /**
     * 起始点坐标,</br>
     * 输入格式为经度,纬度|经度,纬度</br>
     */
    String origin;
    /**
     * 终点坐标</br>
     * 输入格式为：经度,纬度|经度,纬度</br>
     */
    String destination;

    /**
     * @param travelMode 交通工具。无transit即公交
     * @param origin 起点 经度,纬度|经度,纬度
     * @param destination 终点 经度,纬度|经度,纬度
     */
    public GetRoadCalculation(TravelMode travelMode, String origin, String destination) {
        this.travelMode = travelMode;
        this.origin = origin;
        this.destination = destination;
        super.serverUrl="https://api.map.baidu.com/routematrix/v2/driving?output=json&origins="+this.origin+"&destinations="+this.destination+"&ak="+super.AK;
    }


}
