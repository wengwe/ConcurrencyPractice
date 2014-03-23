package jason.practice.concurrency.executors.getthefirstresult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: Jason Weng
 * Date: 14年2月23日
 * Time: 下午10:31
 */
public class Main {

    public static void main(String[] args) {

        String username="test";
        String password="test";

        UserValidator ldapValidator=new UserValidator("LDAP");
        UserValidator dbValidator=new UserValidator("DataBase");

        TaskValidator ldapTask=new TaskValidator(ldapValidator, username, password);
        TaskValidator dbTask=new TaskValidator(dbValidator,username,password);

        List<TaskValidator> taskList=new ArrayList<>();
        taskList.add(ldapTask);
        taskList.add(dbTask);

        ExecutorService executor=(ExecutorService) Executors.newCachedThreadPool();
        String result;

        /*
        The key of the example is in the Main class. The invokeAny() method of the ThreadPoolExecutor class receives a list of tasks, launches them,
         and returns the result of the first task that finishes without throwing an exception.
        This method returns the same data type that the call() method of the tasks you launch returns. In this case, it returns a String value.

         */

        try {
            result = executor.invokeAny(taskList);
            System.out.printf("Main: Result: %s\n",result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
        System.out.printf("Main: End of the Execution\n");


    }
}
