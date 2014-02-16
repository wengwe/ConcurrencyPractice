package jason.practice.concurrency.syncutility.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * User: Jason Weng
 * Date: 14年2月8日
 * Time: 下午6:05
 */
public class Core {
    public static void main(String[] args) {
        List<String> buffer1=new ArrayList<>();
        List<String> buffer2=new ArrayList<>();

        Exchanger<List<String>> exchanger=new Exchanger<>();

        Producer producer=new Producer(buffer1, exchanger);
        Consumer consumer=new Consumer(buffer2, exchanger);

        Thread threadProducer=new Thread(producer);
        Thread threadConsumer=new Thread(consumer);

        threadProducer.start();
        threadConsumer.start();

    }
}
