package jason.practice.concurrency.syncutility.countdownLatch;

/**
 * User: Jason Weng
 * Date: 14年2月7日
 * Time: 下午6:17
 */
public class Main {

    public static void main(String[] args) {

        Videoconference conference=new Videoconference(10);

        Thread threadConference=new Thread(conference);
        threadConference.start();

        for (int i=0; i<10; i++){
            Participant p=new Participant(conference, "Participant "+i);
            Thread t=new Thread(p);
            t.start();
        }

    }

}
