package jason.practice.concurrency.executors.withresults;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * User: Jason Weng
 * Date: 14年2月16日
 * Time: 下午10:01
 */
public class Main {

    public static void main(String[] args){

        ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        List<Future<Integer>> resultList=new ArrayList<>();
        //Future: This interface has some methods to obtain the result generated by a Callable object and to manage its state
        Random random=new Random();

        for (int i=0; i<10; i++){
            Integer number= random.nextInt(10);
            FactorialCalculator calculator=new FactorialCalculator(number);
            Future<Integer> result=executor.submit(calculator);
            resultList.add(result);
        }

        do {
            System.out.printf("Main: Number of Completed Tasks: %d\n",executor.getCompletedTaskCount());
            for (int i=0; i<resultList.size(); i++) {
                Future<Integer> result=resultList.get(i);
                System.out.printf("Main: Task %d: %s\n",i,result.isDone());
            }

            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }}
        while(
                executor.getCompletedTaskCount()<resultList.size()
                    );

        System.out.printf("Main: Results\n");
        for (int i=0; i<resultList.size(); i++) {
            Future<Integer> result=resultList.get(i);
            Integer number=null;
            try {
                number=result.get();
                /*When you call the get() method of a Future object and the task controlled by this object hasn't finished yet, the method blocks until the task finishes.
                                The Future interface provides another version of the get() method.
                                get(longtimeout,TimeUnitunit): This version of the get method, if the result of the task isn't available, waits for it for the specified time. If the specified period of time passes and the result isn't yet available, the method returns a null value.
                                The TimeUnit class is an enumeration with the following constants: DAYS, HOURS, MICROSECONDS, MILLISECONDS, MINUTES, NANOSECONDS, and SECONDS.
                              */


            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            System.out.printf("Main: Task %d: %d\n",i,number);
        }
        executor.shutdown();

        }
}