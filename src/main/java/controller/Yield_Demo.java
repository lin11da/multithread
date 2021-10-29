package controller;

/**
 * TODO
 *  礼让线程测试
 * @author chen
 * @version 1.0
 * @date 2021/10/28 19:58
 */
public class Yield_Demo {
    public static void main(String[] args) {
        Myyield myyield = new Myyield();
        new Thread(myyield,"小米").start();
        new Thread(myyield,"哒哒").start();
    }
}

class Myyield implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 线程开始执行");
        Thread.yield();//礼让
        System.out.println(Thread.currentThread().getName()+" 线程停止执行");
    }
}
