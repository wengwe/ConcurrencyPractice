package jason.practice.concurrency.forkJoin;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Jason Weng
 * Date: 14年3月23日
 * Time: 下午9:57
 */
public class ProductListGenerator {

    public List<Product> generate (int size) {
        List<Product> ret=new ArrayList<Product>();

        for (int i=0; i<size; i++){
            Product product=new Product();
            product.setName("Product "+i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;

    }

}
