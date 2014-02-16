package jason.practice.concurrency.syncutility.countdownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * User: Jason Weng
 * Date: 14年2月7日
 * Time: 下午6:10
 */
public class Videoconference implements Runnable {

    private final CountDownLatch controller;

    public Videoconference(int number){
        this.controller = new CountDownLatch(number);
    }

    public void arrive(String name){
        System.out.printf("%s has arrived.",name);
        controller.countDown();
        System.out.printf("Videoconference: Waiting for %d participants.\n",controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("Videoconference: Initialization: %d participants.\n",controller.getCount());
        try {
            controller.await();
            System.out.printf("Videoconference: All the participants have come\n");
            System.out.printf("Videoconference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
