import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class RSSReader {

    public RSSReader() throws IOException, FeedException {
        String url = "https://dev-monkey-dugi.tistory.com/rss";
        SyndFeed feed = new SyndFeedInput().build(new XmlReader(new URL(url)));
        List<SyndEntry> entries = feed.getEntries();

        for (SyndEntry entry : entries) {
            System.out.println("title = " + entry.getTitle());
            System.out.println("link = " + entry.getLink());
            System.out.println("pubDate = " + entry.getPublishedDate());
            System.out.println("pubDate = " + entry.getDescription().getValue());
            System.out.println("======================================");
        }
    }
}
