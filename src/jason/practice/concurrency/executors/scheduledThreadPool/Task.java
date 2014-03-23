package jason.practice.concurrency.executors.scheduledThreadPool;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * User: Jason Weng
 * Date: 14年2月23日
 * Time: 下午11:02
 */
public class Task implements Callable<String>{

    private String name;

    public Task(String name) {
        this.name=name;
    }

    public String call() throws Exception {
        System.out.printf("%s: Starting at : %s\n",name,new Date());
        return "Hello, world";
    }

}
