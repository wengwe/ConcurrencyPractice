package jason.practice.concurrency.syncutility.cyclicbarrier;

/**
 * User: Jason Weng
 * Date: 14年2月7日
 * Time: 下午7:18
 */
public class Results {

    private int data[];

    public Results(int size){
        data=new int[size];
    }

    public void  setData(int position, int value){
        data[position]=value;
    }

    public int[] getData(){
        return data;
    }
}
