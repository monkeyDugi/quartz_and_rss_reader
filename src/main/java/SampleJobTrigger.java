import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class SampleJobTrigger {

    private SchedulerFactory factory;
    private Scheduler scheduler;

    public SampleJobTrigger() {
        try {
            // Job 구현 내용이 담긴 클래스로 JobDetail 생성
            JobDetail jobDetail = JobBuilder.newJob(SampleJobExecutor.class)
                    .withIdentity("jobName", Scheduler.DEFAULT_GROUP)
                    .build();

            // 실행 시점을 결정하는 Trigger 생성
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("triggerName", Scheduler.DEFAULT_GROUP)
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 * * ? * *"))
                    .build();

            // 스케줄러 실행 및 JobDetail과 Trigger 정보로 스케줄링
            factory = new StdSchedulerFactory();
            scheduler = factory.getScheduler();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
