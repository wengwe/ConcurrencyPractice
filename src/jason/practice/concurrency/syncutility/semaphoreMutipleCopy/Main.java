package jason.practice.concurrency.syncutility.semaphoreMutipleCopy;



/**
 * User: Jason Weng
 * Date: 14年2月7日
 * Time: 下午12:21
 */
public class Main {

    public static void main (String args[]){
       PrintQueue printQueue = new PrintQueue();

        Thread thread[]=new Thread[10];
        for (int i=0; i<10; i++){
            thread[i]=new Thread(new Job(printQueue),"Thread"+i);
        }

        for (int i=0; i<10; i++){
            thread[i].start();
        }
    }
}
