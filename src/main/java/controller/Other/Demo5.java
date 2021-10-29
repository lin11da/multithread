package controller.Other;

/**
 * TODO
 *  多个线程操作一个对象
 *  买火车票的例子  线程并发问题
 * @author chen
 * @version 1.0
 * @date 2021/10/28 16:04
 */
public class Demo5 implements Runnable{
    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        Demo5 demo5 = new Demo5();

        new Thread(demo5,"小米").start();
        new Thread(demo5,"老师").start();
        new Thread(demo5,"大儿").start();
    }

}
