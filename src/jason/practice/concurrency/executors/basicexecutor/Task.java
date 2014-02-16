package jason.practice.concurrency.executors.basicexecutor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: Jason Weng
 * Date: 14年2月9日
 * Time: 上午11:47
 */
public class Task implements  Runnable {

    private Date  initDate;
    private String name;

    public Task(String name){
        initDate=new Date();
        this.name=name;
    }

    @Override
    public void run() {
        System.out.printf("%s: Task %s: Created on: %s\n",Thread.currentThread().getName(),name,initDate);
        System.out.printf("%s: Task %s: Started on: %s\n",Thread.currentThread().getName(),name,new Date());

        try {
            Long duration=(long)(Math.random()*10);
            System.out.printf("%s: Task %s: Doing a task during %d seconds\n",Thread.currentThread().getName(),name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s: Task %s: Finished on: %s\n",Thread.currentThread().getName(),name,new Date());

    }

}
