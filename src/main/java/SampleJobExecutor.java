import com.sun.syndication.io.FeedException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;
import java.text.ParseException;

public class SampleJobExecutor implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            new RSSReader("https://dev-monkey-dugi.tistory.com/").validate();
//            new RSSReader("https://jojoldu.tistory.com/").validate();
        } catch (IOException | FeedException | ParseException e) {
            e.printStackTrace();
        }
    }
}
