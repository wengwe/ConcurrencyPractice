package jason.practice.concurrency.executors.basicexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: Jason Weng
 * Date: 14年2月9日
 * Time: 上午11:49
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server(){
        executor=(ThreadPoolExecutor) Executors.newCachedThreadPool();
    }


    public Server(ThreadPoolExecutor executor) {
        this.executor = executor;
    }

    public void executeTask(Task task){
        System.out.printf("Server: A new task has arrived\n");

        executor.execute(task);

        System.out.printf("Server: Pool Size: %d\n",executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n",executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n",executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }
}


/**The cached thread pool you have created creates new threads if needed to execute the new tasks,
 and reuses the existing ones if they have finished the execution of the task they were running, which are now available.
 The reutilization of threads has the advantage that it reduces the time taken for thread creation.
 The cached thread pool has, however, a disadvantage of constant lying threads for new tasks,
 so if you send too many tasks to this executor, you can overload the system.
 **/
