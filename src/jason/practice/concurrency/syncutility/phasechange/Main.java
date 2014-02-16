package jason.practice.concurrency.syncutility.phasechange;

/**
 * User: Jason Weng
 * Date: 14年2月8日
 * Time: 下午5:27
 */
public class Main {

    public static void main(String[] args) {
        MyPhaser phaser=new MyPhaser();

        Student students[]=new Student[5];
        for (int i=0; i<students.length; i++){
            students[i]=new Student(phaser);
            phaser.register();
        }

        Thread threads[]=new Thread[students.length];
        for (int i=0; i<students.length; i++){
            threads[i]=new Thread(students[i],"Student "+i);
            threads[i].start();
        }

        for (int i=0; i<threads.length; i++){
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("Main: The phaser has finished: %s.\n",phaser.isTerminated());


    }
}
