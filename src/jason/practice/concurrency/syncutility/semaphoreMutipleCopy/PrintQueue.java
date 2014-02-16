package jason.practice.concurrency.syncutility.semaphoreMutipleCopy;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: Jason Weng
 * Date: 14年2月7日
 * Time: 下午12:06
 */
public class PrintQueue {

    private final Semaphore semaphore;

    private boolean freePrinters[];

    private Lock lockPrinters;

    public PrintQueue() {
        this.semaphore = new Semaphore(3);
        freePrinters = new boolean[3];
        for(int i=0;i<3;i++) {
            freePrinters[i] =true;
        }
        lockPrinters = new ReentrantLock();
    }

    public void printJob(Object document){
        try {
            semaphore.acquire();  //tryAcquire()
            int assignedPrinter = getPrinter();
            long duration=(long)(Math.random()*10);
            System.out.printf("%s: PrintQueue: Printing a Job in Printer%d during %d seconds\n",Thread.currentThread().getName(),assignedPrinter,duration);
            TimeUnit.SECONDS.sleep(duration);
            freePrinters[assignedPrinter]=true;
        }  catch (InterruptedException e){
            e.printStackTrace();
        }   finally {
            semaphore.release();
        }

    }

    private int getPrinter() {
        int ret=-1;

        try {
            lockPrinters.lock();

            for (int i=0; i<freePrinters.length; i++) {
                if (freePrinters[i]){
                    ret=i;
                    freePrinters[i]=false;
                    break;
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock();
        }
        return ret;
    }
}
