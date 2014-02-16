package jason.practice.concurrency.syncutility.countdownLatch;

import java.util.concurrent.TimeUnit;

/**
 * User: Jason Weng
 * Date: 14年2月7日
 * Time: 下午6:15
 */
public class Participant implements Runnable  {

    private Videoconference videoConference;

    private String name;

    public Participant(Videoconference videoConference, String name) {
        this.videoConference = videoConference;
        this.name = name;
    }


    @Override
    public void run() {
        long duration=(long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        videoConference.arrive(name);
    }
}
