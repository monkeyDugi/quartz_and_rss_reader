import java.util.Date;

public class RssData {

    private String title;
    private Date pubDate;
    private String link;
    private String description;

    public RssData(String title, Date pubDate, String link, String description) {
        this.title = title;
        this.pubDate = pubDate;
        this.link = link;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }
}
