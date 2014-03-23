package jason.practice.concurrency.syncutility.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: Jason Weng
 * Date: 14年2月7日
 * Time: 下午7:28
 */
public class Main {
    /*
    In this recipe, you will learn how to use the CyclicBarrier class to synchronize a set of threads in a determined point. You will also use a Runnable object that will execute after all the threads have arrived to that point.
     In the example, you will look for a number in a matrix of numbers.
     The matrix will be divided in subsets (using the divide and conquer technique), so each thread will look for the number in one subset.
     Once all the threads have finished their job, a final task will unify the results of them.

      */


    public static void main(String[] args) {
        final int ROWS=10000;
        final int NUMBERS=1000;
        final int SEARCH=5;
        final int PARTICIPANTS=5;
        final int LINES_PARTICIPANT=  NUMBERS / PARTICIPANTS;

        MatrixMock mock=new MatrixMock(ROWS, NUMBERS,SEARCH);

        Results results=new Results(ROWS);

        Grouper grouper=new Grouper(results);

        CyclicBarrier barrier=new CyclicBarrier(PARTICIPANTS,grouper);

        Searcher searchers[]=new Searcher[PARTICIPANTS];

        ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.newFixedThreadPool( PARTICIPANTS );

        for (int i=0; i<PARTICIPANTS; i++){
            searchers[i]=new Searcher(i*LINES_PARTICIPANT, (i*LINES_PARTICIPANT)+LINES_PARTICIPANT, mock, results, SEARCH,barrier);
            Thread thread=new Thread(searchers[i]);
            //thread.start();
            executor.execute(thread);  //submit will return a Future object.
        }
        System.out.printf("Main: The main thread has finished.\n");

       executor.shutdown();

    }
}
