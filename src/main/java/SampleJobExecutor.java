import com.sun.syndication.io.FeedException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;

public class SampleJobExecutor implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            new RSSReader();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FeedException e) {
            e.printStackTrace();
        }
    }
}
