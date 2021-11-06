package get_json;

/**路线规划</br>
 * 注意该对象返回jsonobject对象</br>
 * 只调用getJson方法,具体参考getJson函数</br>
 */
public class GetRoutePlanning extends GetJsonObject{
    /**
     * 使用TravelMode
     */
    TravelMode travelMode;
    /**
     * 起始点坐标,v
     * 输入格式为经度,纬度</br>
     */
    String origin;
    /**
     * 终点坐标</br>
     * 输入格式为：经度,纬度v
     */
    String destination;

    /**
     * @param travelMode 交通工具。无transit即公交
     * @param origin 起点 经度,纬度
     * @param destination 终点 经度,纬度
     */
    public GetRoutePlanning(TravelMode travelMode, String origin, String destination) {
        this.travelMode = travelMode;
        this.origin = origin;
        this.destination = destination;
        super.serverUrl="https://api.map.baidu.com/directionlite/v1/"+travelMode+"?origin="+this.origin+"&destination="+this.destination+"&ak="+super.AK;
    }
}
