package syn;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *  线程不安全的集合
 * @author chen
 * @version 1.0
 * @date 2021/10/31 11:10
 */
public class UnsafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->
                    list.add(Thread.currentThread().getName())).start();
        }
        Thread.sleep(1000);
        System.out.println(list.size());    //结果应该是10000
    }
}
