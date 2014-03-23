package jason.practice.concurrency.executors.getthefirstresult;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * User: Jason Weng
 * Date: 14年2月23日
 * Time: 下午10:26
 */
public class UserValidator {

    private String name;

    public UserValidator(String name) {
        this.name=name;
    }

    public boolean validate(String name, String password) {
        Random random=new Random();

        try {
            long duration=(long)(Math.random()*10);
            System.out.printf("Validator %s: Validating a user during %d seconds\n",this.name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            return false;
        }
        return random.nextBoolean();
    }

    public String getName(){
        return name;
    }
}
