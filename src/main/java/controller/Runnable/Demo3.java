package controller.Runnable;

import controller.Thread.Demo1;

/**
 * TODO
 *  创建线程方式2 ：实现runnable接口，重写run方法  执行线程需要丢入runnable接口实现类，调用start方法
 * @author chen
 * @version 1.0
 * @date 2021/10/28 15:47
 */
public class Demo3 implements Runnable{
    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("我在敲代码！"+i);
        }
    }

    public static void main(String[] args) {

        //创建runnable接口的线程对象
        Demo3 demo3 = new Demo3();

        //创建线程对象，通过线程对象来开启我们的线程,代理
        Thread thread = new Thread(demo3);

        thread.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在睡觉！"+i);
        }
    }
}
