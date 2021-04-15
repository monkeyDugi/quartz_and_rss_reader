import com.sun.syndication.io.FeedException;

import java.io.IOException;
import java.text.ParseException;

public class App {

    public static void main(String[] args) throws FeedException, IOException, ParseException {
        new RSSReader("https://dev-monkey-dugi.tistory.com/").saveTestData();
        new RSSReader("https://jojoldu.tistory.com/").saveTestData();

        new SampleJobTrigger();
    }
}
