package jason.practice.concurrency.syncutility.semaphore;

import java.util.concurrent.Semaphore;

/**
 * User: Jason Weng
 * Date: 14年2月7日
 * Time: 上午11:33
 */
public class PrintQueue {

    private final Semaphore semaphore;

    public PrintQueue() {
        this.semaphore = new Semaphore(1);
    }

    public void printJob(Object document){
        try {
            semaphore.acquire();  //tryAcquire()
            long duration=(long)(Math.random()*10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",Thread.currentThread().getName(),duration);
            Thread.sleep(duration);
        }  catch (InterruptedException e){
            e.printStackTrace();
        }   finally {
            semaphore.release();
        }

    }

}
