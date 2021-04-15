import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RSSReader {

    private final String url;
    private final String rssUrl;

    public RSSReader(String url) throws IOException, FeedException {
        rssUrl = url + "rss";
        this.url = url;
    }

    public void saveTestData() throws IOException, FeedException {
        SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(rssUrl)));
        List<SyndEntry> entries = feed.getEntries();

        String mainLink = feed.getLink();
        System.out.println("mainLink = " + mainLink);

        MemoryDB memoryDB = new MemoryDB();
        RssDataList rssDataList = new RssDataList();

        for (SyndEntry entry : entries) {
            String title = entry.getTitle();
            String link = entry.getLink();
            Date pubDate = entry.getPublishedDate();
            String description = entry.getDescription().getValue();

            RssData rssData = new RssData(title, pubDate, link, description);
            rssDataList.setRssDatas(rssData);
        }

        memoryDB.save(mainLink, rssDataList);
    }

    public void validate() throws ParseException {
        System.out.println("================== DB에서 블로그 조회 ====================");
        MemoryDB memoryDB = new MemoryDB();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        List<RssData> rssDatas = memoryDB.findById(url).getRssDatas();
        for (RssData rssData : rssDatas) {
            // 2021-04-11 10:31:42
            Date pubDate = dateFormat.parse((dateFormat.format(rssData.getPubDate())));
            Date customDate = dateFormat.parse("2021-04-11 10:31:43");

            int compare = pubDate.compareTo(customDate);
            if (compare < 0) {
                // 요 때 신규 게시글 insert
                System.out.println("최신 글 있음 insert");
            } else {
                System.out.println("최신글 없음");
            }

            System.out.println("title = " + rssData.getTitle());
            System.out.println("link = " + rssData.getLink());
            System.out.println("description = " + rssData.getDescription());
            System.out.println("======================================");
        }
    }
}
