package jason.practice.concurrency.syncutility.cyclicbarrier;

import java.util.Random;

/**
 * User: Jason Weng
 * Date: 14年2月7日
 * Time: 下午7:07
 */
public class MatrixMock {

    private int[][] data;

    public MatrixMock(int size, int length, int number) {
        int counter=0;
        data=new int[size][length];
        Random random=new Random();

        for (int i=0; i<size; i++) {
            for (int j=0; j<length; j++){
                data[i][j]=random.nextInt(10);
                if (data[i][j]==number){
                    counter++;
                }
            }
        }

        System.out.printf("Mock: There are %d ocurrences of number in generated data.\n",counter,number);
    }


    public int[] getRow(int row){
        if ((row>=0)&&(row<data.length)){
            return data[row];
        }
        return null;
    }
}
