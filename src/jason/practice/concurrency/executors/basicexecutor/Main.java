package jason.practice.concurrency.executors.basicexecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: Jason Weng
 * Date: 14年2月9日
 * Time: 上午11:51
 */
public class Main {

    public static void main(String[] args) {
        Server server;
       /* Server server=new Server();
        for (int i=0; i<100; i++){
            Task task=new Task("Task "+i);
            server.executeTask(task);
        }
        server.endServer();*/

        ThreadPoolExecutor executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(5);
        server=new Server(executor);
        for (int i=0; i<100; i++){
            Task task=new Task("Task "+i);
            server.executeTask(task);
        }
        server.endServer();
    }


}
