package jason.practice.concurrency.executors.scheduledThreadPool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User: Jason Weng
 * Date: 14年2月23日
 * Time: 下午11:03
 */
public class Main {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor=(ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

        System.out.printf("Main: Starting at: %s\n",new Date());
        for (int i=0; i<5; i++) {
            Task task=new Task("Task "+i);
            executor.schedule(task,i+1 , TimeUnit.SECONDS);
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Ends at: %s\n",new Date());
    }
}
