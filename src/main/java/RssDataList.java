import java.util.ArrayList;
import java.util.List;

public class RssDataList {

    private List<RssData> rssDatas = new ArrayList<>();

    public List<RssData> getRssDatas() {
        return rssDatas;
    }

    public void setRssDatas(RssData rssData) {
        rssDatas.add(rssData);
    }
}
